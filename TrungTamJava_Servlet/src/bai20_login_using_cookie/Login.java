package bai20_login_using_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//BÀI NÀY SAI CHƯA SỬA ĐC
@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<form action='TrungTamJava_Servlet/login' method='post'>");
		pw.println("Username: <input type='text' name='username_from_form'>");
		pw.println("Password: <input type='password' name='password_from_form'>");
		pw.println("<input type='submit' value='login'>");
		pw.println("</form>");
		
		pw.close();
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String user = req.getParameter("username_from_form");
		String pass = req.getParameter("password_from_form");
		
		if(user.equals("anhtu") && pass.equals("5555")) {
			Cookie c = new Cookie("key_username", user);
			c.setMaxAge(30);
			resp.addCookie(c);
			resp.sendRedirect("/TrungTamJava_Servlet/welcome");
			
		} else {
//			PrintWriter pw = resp.getWriter();
//			pw.println("username or pass is not correct!");
			resp.sendRedirect("/TrungTamJava_Servlet/login");
		}
	}
}
