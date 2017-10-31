package servlet_teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import database.ScoreboardUtils;
import database.StudentUtils;

/**
 * Servlet implementation class SubmitScoreForClass
 */

public class SubmitScoreForClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Student> stList;
	int courseID;
	String subjectName;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitScoreForClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		courseID = Integer.valueOf(request.getParameter("courseID"));
		subjectName = request.getParameter("subjectName");
		StudentUtils su = new StudentUtils();
		su.connect();
		stList = su.getStudentByCourseID(courseID);
		
		request.setAttribute("stList", stList);
		request.setAttribute("courseID", courseID);
		request.setAttribute("subjectName", subjectName);
		request.getRequestDispatcher("/WEB-INF/jsps/teacher/submit_score_for_class.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String diemQuaTrinh;
		String diemCuoiKy;
		ScoreboardUtils su = new ScoreboardUtils();
		su.connect();
		for(Student st : stList) {
			diemQuaTrinh = request.getParameter(st.getId() + "_qt");
			diemCuoiKy = request.getParameter(st.getId() + "_ck");
			if(!"".equals(diemQuaTrinh) && !"".equals(diemCuoiKy) && diemQuaTrinh != null && diemCuoiKy != null) {
				su.updateScore(st.getId(), courseID, Float.valueOf(diemQuaTrinh), Float.valueOf(diemCuoiKy));
			}
		}
		String prevPath = request.getRequestURI() + "?" + request.getQueryString();
		request.setAttribute("prevPath", prevPath);
		request.getRequestDispatcher("WEB-INF/jsps/teacher/submit_score_success.jsp").forward(request, response);
	}

}
