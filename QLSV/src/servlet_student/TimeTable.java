package servlet_student;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Course;
import database.ScoreboardUtils;
import database.StudentUtils;
import servlet_home.HomeServlet;
import servlet_login.LoginServlet;

/**
 * Servlet implementation class TimeTableServlet
 */

public class TimeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showTimetable(request, response, LoginServlet.loginedStudent.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stIDString = request.getParameter("stID");
		int studentID;
		try {
			studentID = Integer.valueOf(stIDString);
		} catch (java.lang.NumberFormatException ex) {
			request.setAttribute("errorString", "Wrong format for ID!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/time_table.jsp").forward(request, response);
			return;
		}
		
		showTimetable(request, response, studentID);
	}

	private void showTimetable(HttpServletRequest request, HttpServletResponse response, int studentID) throws ServletException, IOException {
		String studentName;
		ScoreboardUtils sbu = new ScoreboardUtils();
		sbu.connect();
		Set<Course> courseSet = sbu.getTimetable(studentID, HomeServlet.currentTerm);
		if(courseSet == null) {
			request.setAttribute("errorString", "Student ID didn't exist, or this student didn't enroll any course this term.");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/time_table.jsp").forward(request, response);
			return;
		}
		StudentUtils su = new StudentUtils();
		su.connect();
		studentName = su.getStudentNameByID(studentID);
		
		sbu.disConnect();
		su.disConnect();
		
		request.setAttribute("infoString", "Timetable of student " + studentName + ", in term " + HomeServlet.currentTerm);
		request.setAttribute("courseSet", courseSet);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/time_table.jsp").forward(request, response);
	}
}
