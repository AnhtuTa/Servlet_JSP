package servlet_login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Staff;
import beans.Student;
import beans.Teacher;
import database.StaffUtils;
import database.StudentUtils;
import database.TeacherUtils;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentUtils stu;
	TeacherUtils tu;
	StaffUtils su;

	public static Student loginedStudent;
	public static Teacher loginedTeacher;
	public static Staff loginedStaff;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        stu = new StudentUtils();
        tu = new TeacherUtils();
        su = new StaffUtils();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginedUser") == null) {
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);
		}
		else request.getServletContext().getRequestDispatcher("/login_info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("txtUser");
		String pass = request.getParameter("txtPass");
		String roleOfUser;
		
		if(user.equals("") || user==null) {
			request.setAttribute("error_login", "Error! Username must be not null!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);
			return;
		}
		
		roleOfUser = (String) request.getSession().getAttribute("roleOfUser");
		switch (roleOfUser) {
		case SelectRoleServlet.ROLE_STUDENT:
			loginWithStudentRole(request, response, user, pass);
			break;
		
		case SelectRoleServlet.ROLE_TEACHER:
			loginWithTeacherRole(request, response, user, pass);
			break;
			
		case SelectRoleServlet.ROLE_STAFF:
			loginWithStaffRole(request, response, user, pass);
			break;

		default:
			loginWithStudentRole(request, response, user, pass);
			break;
		}
	}

	private void loginWithStudentRole(HttpServletRequest request, HttpServletResponse response, String user, String pass) throws ServletException, IOException {
		Student st;
		stu.connect();
		try {
			st = stu.check(Integer.valueOf(user), pass);
		} catch (java.lang.NumberFormatException ex) {
			request.setAttribute("error_login", "Error! Username must be a number!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);
			return;
		}
		
		if(st != null) {
			//store logined user using session
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", st);
			loginedStudent = st;
			session.setMaxInactiveInterval(3600);	//session co hieu luc toi da trong 1h
			//request.getServletContext().getRequestDispatcher("/home").forward(request, response);		ko nên dùng, vì dù chuyển đến servlet khác nhưng thanh URL ko thay đổi tên
			//nghĩa là: đang ở trang /login, nếu dùng lệnh trên thì sẽ chuyển sang trang /home nhưng thanh URL vẫn là /login
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		} else {
			request.setAttribute("error_login", "Invalid username or password!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);
			return;
		}
	}

	private void loginWithTeacherRole(HttpServletRequest request, HttpServletResponse response, String user, String pass) throws IOException, ServletException {
		tu.connect();
		Teacher tc = tu.check(user, pass);
		
		if(tc != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", tc);
			loginedTeacher = tc;
			session.setMaxInactiveInterval(3600);
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		} else {
			request.setAttribute("error_login", "Invalid username or password!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);
			return;
		}
	}

	private void loginWithStaffRole(HttpServletRequest request, HttpServletResponse response, String user, String pass) throws IOException, ServletException {
		su.connect();
		Staff as = su.check(user, pass);	//Academic Staff
		
		if(as != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", as);
			loginedStaff = as;
			session.setMaxInactiveInterval(3600);
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		} else {
			request.setAttribute("error_login", "Invalid username or password!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);
			return;
		}
	}
}
