package servlet_person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import database.StudentUtils;
import servlet_login.SelectRoleServlet;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/search-student")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/search_student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentID = request.getParameter("studentID");
		StudentUtils su = new StudentUtils();
		su.connect();
		
		if(!"".equals(studentID)) {
			try {
				Student st = su.getStudentByID(Integer.valueOf(studentID));
				if(st == null) {
					request.setAttribute("errorString", "Mã SV không tồn tại!");
				}
				request.setAttribute("st", st);
				request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/search_student.jsp").forward(request, response);
			} catch (java.lang.NumberFormatException ex) {
				request.setAttribute("errorString", "Wrong format for student ID");
				request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/search_student.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("errorString", "Please enter a studentID");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/search_student.jsp").forward(request, response);
		}
	}

}
