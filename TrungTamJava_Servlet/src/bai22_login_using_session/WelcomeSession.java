package bai22_login_using_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/welcome-session"})
public class WelcomeSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String name="";
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("username");
		if(obj!=null) name = String.valueOf(obj);
		else resp.sendRedirect("/TrungTamJava_Servlet/session-login");
		
		pw.println("Xin chao "+name);
		pw.println("<br/>Log out: <a href='/TrungTamJava_Servlet/logout'>Click here to Logout</a>");
		
		//phần: "Click here to Logout" sẽ được gạch chân và có màu xanh, đó là 1 đường link dẫn tới trang logout, chứ ko phải click vào chỗ: "Log out:"
	}
}
