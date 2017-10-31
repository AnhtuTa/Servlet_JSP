package bai22_login_using_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/session-login"})
public class SessionLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Tạo form login:
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<form action='/TrungTamJava_Servlet/session-login' method='post'>");
		pw.println("username: <input type='text' name='user'>");
		pw.println("password: <input type='password' name='pass'>");
		pw.println("<input type='submit' value='login'>");
		pw.println("</form>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//lay gia tri gui len server:
		String name = req.getParameter("user");		//user này là param ở dòng 22, nghĩa là khi người dùng nhập tên vào "user" của form thì biến name = giá trị nhập vào đó
		String pass = req.getParameter("pass");
		
		if(name.equals("anhtu") && pass.equals("5555")) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("username", name);
			//httpSession.setAttribute("password", pass);
			
			resp.sendRedirect("/TrungTamJava_Servlet/welcome-session");
		} else {
			resp.sendRedirect("/TrungTamJava_Servlet/session-login");
		}
	}
}
