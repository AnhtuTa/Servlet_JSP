package tutorialspoint.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTrack
 */
@WebServlet("/SessionTrack")
public class SessionTrack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		  // Create a session object if it is already not  created.
	      HttpSession session = request.getSession(true);
	      // Get session creation time.
	      Date createTime = new Date(session.getCreationTime());
	      // Get last access time of this web page.
	      Date lastAccessTime = new Date(session.getLastAccessedTime());

	      String title = "Welcome Back to my website";
	      int visitCount = 0;
	      String visitCountKey = "visitCount_keyatt";
	      String userIDKey = "userID";
	      String userID = "ABCD";

	      System.out.println("session.isNew() = "+session.isNew());
	      System.out.println("session = "+session);
	      // Check if this is new comer on your web page.
	      if(session.isNew()) {
	    	  title = "Welcome to my website";
	    	  session.setAttribute(userIDKey, userID);
	    	  session.setAttribute(visitCountKey, 0);
	    	  System.out.println("[session.isNew] session.getAttribute(visitCountKey) = "+session.getAttribute(visitCountKey));
	      } else {
	    	  System.out.println("session.getAttribute(visitCountKey) = "+session.getAttribute(visitCountKey));
	    	  visitCount = (int) session.getAttribute(visitCountKey);
	    	  visitCount++;
	      }
	      session.setAttribute(visitCountKey, visitCount);
	      
	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
		                "<body bgcolor=\"#f0f0f0\">\n" +
			                "<h1 align=\"center\">" + title + "</h1>\n" +
			                 "<h2 align=\"center\">Session Infomation</h2>\n" +
			                "<table border=\"1\" align=\"center\">\n" +
			                "<tr bgcolor=\"#949494\">\n" +
			                "  <th>Session info</th><th>value</th></tr>\n" +
			                "<tr>\n" +
			                "  <td>id</td>\n" +
			                "  <td>" + session.getId() + "</td></tr>\n" +
			                "<tr>\n" +
			                "  <td>Creation Time</td>\n" +
			                "  <td>" + createTime + 
			                "  </td></tr>\n" +
			                "<tr>\n" +
			                "  <td>Time of Last Access</td>\n" +
			                "  <td>" + lastAccessTime + 
			                "  </td></tr>\n" +
			                "<tr>\n" +
			                "  <td>User ID</td>\n" +
			                "  <td>" + userID + 
			                "  </td></tr>\n" +
			                "<tr>\n" +
			                "  <td>Number of visits</td>\n" +
			                "  <td>" + visitCount + "</td></tr>\n" +
			                "</table>\n" +
		                "</body>" +
		            "</html>");
		} catch (java.lang.NullPointerException ex) {
			response.sendRedirect("tutorialspoint/session_error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
