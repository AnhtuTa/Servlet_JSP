package servlet_login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SelectRoleServlet
 */

public class SelectRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ROLE_STUDENT = "student";
	public static final String ROLE_TEACHER = "teacher";
	public static final String ROLE_STAFF = "staff";
	public static String roleOfUser;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/select_role.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String str = request.getParameter("roleOfUser");
		String role;
		switch (str) {
		case "Login with student":
			role = ROLE_STUDENT;
			break;
			
		case "Login with teacher":
			role = ROLE_TEACHER;
			break;
			
		case "Login with academic staff":
			role = ROLE_STAFF;
			break;

		default:
			role = ROLE_STUDENT;
			break;
		}

		session.setAttribute("roleOfUser", role);
		roleOfUser = role;
		System.out.println("[SelectRole] roleOfUser = "+role);
		response.sendRedirect(request.getContextPath() + "/login");
	}

}
