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
 * Servlet implementation class CookieLogin
 */
@WebServlet("/CookieLogin")
public class CookieLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		if("at".equals(user) && "1".equals(pass)) {
			//create a cookie for saving these information
			Cookie c1 = new Cookie("user_ck", user);
			Cookie c2 = new Cookie("pass_ck", pass);
			response.addCookie(c1);
			response.addCookie(c2);
			
			//welcome user
			pw.println("Welcome! Your account is valid! The previous form using cookie");
			pw.println("Now go back and try login again, your these textfields: <b>username</b> and <b>password</b> have been <b>filled up</b> by using cookie");
		} else {
			response.sendRedirect("tutorialspoint/cookie_login.jsp");
		}
		
	}

}
