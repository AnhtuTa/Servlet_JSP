package filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserAccount;
import config.SecurityConfig;
import utils.AppUtils;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(urlPatterns={"/login", "/userInfo","/employeeTask", "/managerTask", "/userInfo"})
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("This is SecurityFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String servletPath = req.getServletPath();
		if(servletPath.equals("/login")) {
			if(req.getSession().getAttribute("loginedUser") != null) {
				//resp.sendRedirect("/WEB-INF/views/logoutFirstView.jsp");
				req.getServletContext().getRequestDispatcher("/WEB-INF/views/logoutFirstView.jsp").forward(req, resp);
				return;
			}
			chain.doFilter(request, response);
			return;
		}
		
		// Thông tin người dùng đã được lưu trong Session
		// (Sau khi đăng nhập thành công).
		UserAccount loginedUser = AppUtils.getLoginedUser(req.getSession());
		if(loginedUser != null) {
			SecurityConfig sc = new SecurityConfig();
			List<String> userRoles = loginedUser.getRoles();
			Set<String> urlPatterns = new HashSet<>();
			
			for(String userRole : userRoles) {
				urlPatterns.addAll(sc.getUrlPatternsForRole(userRole));
			}
			
			for(String str : urlPatterns) {
				System.out.println("urlPatterns = "+str);
			}
			
			System.out.println("req.getServletPath() = "+req.getServletPath());
			if(urlPatterns.contains(req.getServletPath())) {
				chain.doFilter(request, response);
				return;
			} else {
				req.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDeniedView.jsp").forward(req, resp);
				return;
			}
		} else {
			// Nếu người dùng chưa đăng nhập,
			// Redirect (chuyển hướng) tới trang đăng nhập
			
			// Lưu trữ trang hiện tại để redirect đến sau khi đăng nhập thành công.
			String url = req.getServletPath();
			req.getSession().setAttribute("urlBeforeLogin", url);
			
			// Bay gio thi chuyen den trang login
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
