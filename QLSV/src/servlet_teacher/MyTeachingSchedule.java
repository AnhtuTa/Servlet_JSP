package servlet_teacher;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Course;
import beans.Teacher;
import database.TeacherUtils;

/**
 * Servlet implementation class TeachingSchedule
 */

public class MyTeachingSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTeachingSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherUtils tu = new TeacherUtils();
		tu.connect();
		Teacher tc = (Teacher) request.getSession().getAttribute("loginedUser");
		String currentTerm = this.getServletContext().getInitParameter("currentTerm");
		Set<Course> courseSet = tu.getTeachingSchedule(tc.getId(), Integer.valueOf(currentTerm));
		request.setAttribute("courseSet", courseSet);
		request.setAttribute("infoString", "Teaching schedule of lecturer " + tc.getName() + ", in term " + currentTerm);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/teacher/teaching_schedule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
