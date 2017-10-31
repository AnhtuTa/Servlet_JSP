package tutorialspoint.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo
 */
@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		Cookie fnCookie = new Cookie("first_name_ck", firstName);
		Cookie lnCookie = new Cookie("last_name_ck", lastName);
		
		fnCookie.setMaxAge(60*60);	//1 hour
		lnCookie.setMaxAge(60*60);
		
		response.addCookie(fnCookie);
		response.addCookie(lnCookie);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<b>First Name</b>: " + firstName + "<br/>" +
				   "<b>Last Name</b>: " + lastName + "<br/>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
