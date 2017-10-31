package servlet_student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Exam;
import database.ExamUtils;
import servlet_home.HomeServlet;
import servlet_login.LoginServlet;

/**
 * Servlet implementation class ExamSchedule
 */
@WebServlet("/ExamSchedule")
public class ExamSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExamUtils eu = new ExamUtils();
		eu.connect();
		int stID = LoginServlet.loginedStudent.getId();
		List<Exam> examList = eu.getExamSchedule(stID, HomeServlet.currentTerm);
		eu.disConnect();
		request.setAttribute("examList", examList);
		request.setAttribute("infoString", "Lịch thi của sinh viên " + stID + " học kỳ " + HomeServlet.currentTerm);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/exam_schedule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
