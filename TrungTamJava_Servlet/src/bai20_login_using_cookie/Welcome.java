package bai20_login_using_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/welcome"})
public class Welcome extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String name = "";
		Cookie [] cookies = req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("key_username")) {
				name = c.getValue();
			}
		}
		if(name.equals("")) resp.sendRedirect("/TrungTamJava_Servlet/login");

		PrintWriter pw = resp.getWriter();
		pw.println("Xin chao "+name);
	}
}
