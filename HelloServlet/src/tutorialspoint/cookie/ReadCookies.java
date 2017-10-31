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
 * Servlet implementation class ReadCookie
 */
@WebServlet("/ReadCookies")
public class ReadCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Need to run this on a browser, not on Eclipse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cookies = request.getCookies();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		for(Cookie c : cookies) {
			//pw.println(c.getName() + " | " + c.getValue() + " | " + c.getMaxAge() + " | " + c.getDomain() + " | " + c.getPath());
			pw.println("c.getName() = " + c.getName() + "<br/>");
			pw.println("c.getValue() = " + c.getValue() + "<br/>");
			pw.println("c.getMaxAge() = " + c.getMaxAge() + "<br/>");
			pw.println("c.getDomain() = " + c.getDomain() + "<br/>");
			pw.println("c.getPath() = " + c.getPath() + "<br/><br/>");
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
