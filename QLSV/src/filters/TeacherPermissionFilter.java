package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_login.SelectRoleServlet;

/**
 * Servlet Filter implementation class TeacherPermissionFilter
 */

public class TeacherPermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TeacherPermissionFilter() {
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String roleOfUser = (String) req.getSession().getAttribute("roleOfUser");
		if(SelectRoleServlet.ROLE_TEACHER.equals(roleOfUser)) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("no_permission_path", req.getServletPath());
			req.getServletContext().getRequestDispatcher("/WEB-INF/jsps/no_permission.jsp").forward(req, resp);
			return;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
