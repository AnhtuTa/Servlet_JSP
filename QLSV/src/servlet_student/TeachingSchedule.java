package servlet_student;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Course;
import database.TeacherUtils;
import servlet_home.HomeServlet;

/**
 * Servlet implementation class TeachingSchedule
 */

public class TeachingSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachingSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacherID = request.getParameter("teacherID");
		TeacherUtils tu = new TeacherUtils();
		tu.connect();
		Set<Course> courseSet = tu.getTeachingSchedule(teacherID, HomeServlet.currentTerm);
		if(courseSet != null) {
			request.setAttribute("courseSet", courseSet);
			request.setAttribute("infoString", "Lịch phân công giảng dạy của giảng viên " + tu.getTeacherNameByID(teacherID) + " học kỳ " + HomeServlet.currentTerm);
		}
		else request.setAttribute("infoString", "Mã giảng viên không đúng hoặc giảng viên này không có lịch dạy trong kỳ này");
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/teaching_schedule.jsp").forward(request, response);
		tu.disConnect();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
