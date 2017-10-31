package jsp_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAllCookies
 */
@WebServlet("/DeleteCookies")
public class DeleteCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<h3>This servlet just delete some cookies for testing cookieDemo.jsp</h3>");
		Cookie []cookies = request.getCookies();
		if(cookies == null || cookies.length == 0) {
			pw.println("<h4>There's no cookie no delete!</h4>");
			return;
		}
		pw.println("<h5>these following cookies will be deleted:</h5>");
		for(Cookie c : cookies) {
			pw.println(c.getName() + " - " + c.getValue());
			c.setMaxAge(0);
			c.setPath("/");
			response.addCookie(c);
		}
		pw.println("<h4>Deleted these above cookies! Now go back to test cookieDemo.jsp</h4>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
