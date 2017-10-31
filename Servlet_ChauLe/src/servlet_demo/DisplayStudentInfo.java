package servlet_demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayStudentInfo
 */
@WebServlet(urlPatterns={"/display-student-info"})
public class DisplayStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String day = request.getParameter("day");
		if(day.equals("1")) {
			day = day + "st";
		} else if(day.equals("2")) {
			day = day + "nd";
		} else if(day.equals("3")) {
			day = day + "rd";
		} else {
			day = day + "th";
		}
		pw.println("<h1 style=\"color: blue;\">Here is your information, idiot!</h1>");
		pw.println("<p style=\"color: #dd00dd; font: 20px Comic Sans MS, Arial;\">Your name is "
					+ request.getParameter("student_name")
					+ ", you're living in " + request.getParameter("address")
					+ ". You're " + request.getParameter("age") + " years old and now you're studying at "
					+ request.getParameter("school")
					+ "</p>"
					+ "<p style=\"color: green;\"><div style=\"color: green; font: 18px Comic Sans MS; margin-bottom: 10px;\">Here is more information about you</div>"
					+ "<div style=\"color: #dd00dd; font: 14px Comic Sans MS;\">Sex: " + request.getParameter("sex") + "</div>"
					+ "<div style=\"color: #dd00dd; font: 14px Comic Sans MS;\">Birthday: " + request.getParameter("month") + " " + day + ", " + request.getParameter("year") + "</div>"
					+ "</p>"
				);
		
		String cbFb = request.getParameter("fb");
		String cbFr = request.getParameter("fr");
		String cbTw = request.getParameter("tw");
		String cbgg = request.getParameter("gg");
		pw.println("<div>The reason you register this program:</div>");
		if(cbFb != null) pw.println("<div>" + cbFb + "</div>");
		if(cbFr != null) pw.println("<div>" + cbFr + "</div>");
		if(cbTw != null) pw.println("<div>" + cbTw + "</div>");
		if(cbgg != null) pw.println("<div>" + cbgg + "</div>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
