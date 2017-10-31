package tutorialspoint.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReadSessions
 */
@WebServlet("/ReadSessions")
public class ReadSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h3>Session's attributes</h3><br/>");
		
		HttpSession session = request.getSession();
		Enumeration<String> attributeName = session.getAttributeNames();
		while(attributeName.hasMoreElements()) {
			String name = attributeName.nextElement();
			String value = String.valueOf(session.getAttribute(name));
			pw.println(name + " - " + value + "<br/>");
		}
		pw.println("<br/>session.getId() = " + session.getId() + "<br/>");
		pw.println("session.getCreationTime() = " + new Date(session.getCreationTime()) + "<br/>");
		pw.println("session.getLastAccessedTime() = " + new Date(session.getLastAccessedTime()) + "<br/>");
		pw.println("session.getMaxInactiveInterval() = " + session.getMaxInactiveInterval() + "<br/>");
		pw.println("session.getClass() = " + session.getClass() + "<br/>");
		pw.println("session.getServletContext() = " + session.getServletContext() + "<br/>");
		pw.println("session.getSessionContext() = " + session.getSessionContext() + "<br/>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
