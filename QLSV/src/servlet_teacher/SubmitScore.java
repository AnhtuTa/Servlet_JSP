package servlet_teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Course;
import database.TeacherUtils;
import servlet_home.HomeServlet;
import servlet_login.LoginServlet;

/**
 * Servlet implementation class SubmitScore
 */
@WebServlet("/SubmitScore")
public class SubmitScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitScore() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherUtils tu = new TeacherUtils();
		tu.connect();
		List<Course> courseList = tu.getCourseForSubmitScore(LoginServlet.loginedTeacher.getId(), HomeServlet.currentTerm);
		request.setAttribute("courseList", courseList);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/teacher/submit_score.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
