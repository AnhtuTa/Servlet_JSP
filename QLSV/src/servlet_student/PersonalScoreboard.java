package servlet_student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Score;
import beans.Student;
import database.AvailableTerm;
import database.ScoreboardUtils;


/**
 * Servlet implementation class ScoreBoard
 */

public class PersonalScoreboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalScoreboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AvailableTerm at = new AvailableTerm();
		at.connect();
		List<Integer> termList = at.getAllTerms();
		request.setAttribute("availableTerm", termList);
		request.setAttribute("selectedTerm", "0");
		
		showScoreboard(request, response, "all");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedTerm = request.getParameter("select-term");
		request.setAttribute("selectedTerm", selectedTerm);
		
		AvailableTerm at = new AvailableTerm();
		at.connect();
		List<Integer> termList = at.getAllTerms();
		request.setAttribute("availableTerm", termList);
		
		showScoreboard(request, response, selectedTerm);
	}

	private void showScoreboard(HttpServletRequest request, HttpServletResponse response, String selectedTerm) throws ServletException, IOException {
		ScoreboardUtils su = new ScoreboardUtils();
		su.connect();
		Student st = (Student) request.getSession().getAttribute("loginedUser");
		int userID = st.getId();
		
		List<Score> scoreList;
		if(selectedTerm.equals("all")) {
			scoreList = su.getAllScoresByID(userID);
		} else {
			scoreList = su.getScoreByID(userID, Integer.valueOf(selectedTerm));
		}
		
		request.setAttribute("scoreList", scoreList);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/personal_scoreboard.jsp").forward(request, response);
	}
}
