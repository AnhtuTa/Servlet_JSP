package servlet_student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import database.SVClassUtils;

/**
 * Servlet implementation class StudentClass
 */
@WebServlet("/student-class")
public class StudentClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classID = Integer.valueOf(request.getParameter("classID"));
		SVClassUtils svc = new SVClassUtils();
		svc.connect();
		
		List<Student> stList = svc.getAllStudentsInClass(classID);
		request.setAttribute("stList", stList);
		request.setAttribute("classID", classID);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/student_class.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
