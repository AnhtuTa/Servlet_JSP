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
 * Servlet implementation class StudentInformation
 */
@WebServlet("/student-information")
public class StudentInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentID = Integer.valueOf(request.getParameter("studentID"));
		StudentUtils su = new StudentUtils();
		su.connect();
		Student st = su.getStudentByID(studentID);
		su.disConnect();
		request.setAttribute("st", st);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/student_information.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
