package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserAccount;
import request.UserRoleRequestWrapper;
import utils.AppUtils;
import utils.SecurityUtils;

/**
 * Servlet Filter implementation class SecurityFilter
 * SecurityFilter là một Servlet Filter, nó làm nhiệm vụ kiểm tra các request trước khi cho phép truy cập vào các trang (page) được bảo hộ. 
 * SecurityFilter đọc "các cấu hình bảo mật" đã được khai báo trong lớp SecurityConfig.
 */
//CHÚ Ý: Nếu ko có Servlet Logout.java thì do tất cả các url đều đi qua filter này, nên sự thiếu đó vẫn ko báo lỗi!
//CẨN THẬN VỚI ĐIỀU NÀY!

@WebFilter("/*")
public class SecurityFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String servletPath = request.getServletPath();		//kq la cai duong link cua servlet ma di qua cai filter nay, VD: /hello, /login

		// Thông tin người dùng đã được lưu trong Session
		// (Sau khi đăng nhập thành công).
		UserAccount loginedUser = AppUtils.getLoginedUser(request.getSession());

		if (servletPath.equals("/login")) {
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest wrapRequest = request;

		if (loginedUser != null) {
			// User Name
			String userName = loginedUser.getUserName();

			// Các vai trò (Role).
			List<String> roles = loginedUser.getRoles();

			// Gói request cũ bởi một Request mới với các thông tin userName và
			// Roles.
			wrapRequest = new UserRoleRequestWrapper(userName, roles, request);
		}

		// Các trang bắt buộc phải đăng nhập.
		if (SecurityUtils.isSecurityPage(request)) {

			// Nếu người dùng chưa đăng nhập,
			// Redirect (chuyển hướng) tới trang đăng nhập.
			if (loginedUser == null) {

				String requestUri = request.getRequestURI();

				// Lưu trữ trang hiện tại để redirect đến sau khi đăng nhập
				// thành công.
				int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

				response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
				return;
			}

			// Kiểm tra người dùng có vai trò hợp lệ hay không?
			boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
			if (!hasPermission) {

				RequestDispatcher dispatcher //
						= request.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDeniedView.jsp");

				dispatcher.forward(request, response);
				return;
			}
		}

		chain.doFilter(wrapRequest, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
