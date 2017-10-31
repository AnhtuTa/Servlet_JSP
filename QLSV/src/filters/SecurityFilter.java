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
import javax.servlet.http.HttpSession;

import beans.Student;

/**
 * Servlet Filter implementation class SecurityFilter
 */

public class SecurityFilter implements Filter {
	final String EMPLY_STRING = "";
	final String SELECT_ROLE = "/select-role";
	final String LOGIN_PATH = "/login";
	

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
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String servletPath = req.getServletPath();
		String roleOfUser = (String) session.getAttribute("roleOfUser");
		System.out.println("roleOfUser = " + roleOfUser);

		if (roleOfUser != null && servletPath.equals(LOGIN_PATH)) {
			chain.doFilter(req, resp);
			return;
		}

		if (servletPath.equals(SELECT_ROLE)) {
			chain.doFilter(req, resp);
			return;
		}

		if ((Object) session.getAttribute("loginedUser") == null) {
			resp.sendRedirect(req.getContextPath() + "/select-role");
			return;
		}

		chain.doFilter(req, resp);
	}

	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	//Dưới đây là hàm doFilter ban đầu
	public void doFilter_(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("this is SecurityFilter");
         
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
         
        String servletPath = req.getServletPath();
        String roleOfUser = (String) session.getAttribute("roleOfUser");
        Student st = (Student) session.getAttribute("loginedUser");
 
        System.out.println("roleOfUser = " + roleOfUser);
        if(st != null) System.out.println("st = " + st.getName());
         
        if(roleOfUser != null && servletPath.equals(LOGIN_PATH)) {
            chain.doFilter(req, resp);
            return;
        }
         
        if(servletPath.equals(SELECT_ROLE)) {
            chain.doFilter(req, resp);
            return;
        }
         
        if(st == null) {
            resp.sendRedirect(req.getContextPath() + "/select-role");
            return;
        }
        
        chain.doFilter(req, resp);
    }
}
