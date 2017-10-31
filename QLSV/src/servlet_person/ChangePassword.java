package servlet_person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.StudentUtils;
import servlet_login.LoginServlet;
import servlet_login.SelectRoleServlet;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/change_password.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtOldPass = request.getParameter("txtOldPass");
		if(!LoginServlet.loginedStudent.getPassword().equals(txtOldPass)) {
			request.setAttribute("errorString", "Wrong password! Please retype old password");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/change_password.jsp").forward(request, response);
			return;
		} else {
			String txtNewPass = request.getParameter("txtNewPass");
			String txtRetype = request.getParameter("txtRetype");
			if(txtNewPass == null || txtRetype == null) {
				request.setAttribute("errorString", "Password doesn't match! Please retype new password!");
				request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/change_password.jsp").forward(request, response);
				return;
			} else {
				if(!txtNewPass.equals(txtRetype)) {
					request.setAttribute("errorString", "Password doesn't match! Please retype new password!");
					request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/change_password.jsp").forward(request, response);
					return;
				} else {
					StudentUtils su = new StudentUtils();
					su.connect();
					int kq = su.changeStudentPassword(LoginServlet.loginedStudent.getId(), txtNewPass);
					if(kq > 0) {
						request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/change_pass_success.jsp").forward(request, response);
						su.disConnect();
						LoginServlet.loginedStudent.setPassword(txtNewPass);
						return;
					}
				}
			}
		}
	}
}
