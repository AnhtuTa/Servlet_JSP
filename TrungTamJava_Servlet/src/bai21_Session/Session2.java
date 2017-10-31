package bai21_Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/session2"})
public class Session2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		
		String name = "";
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("name");
		if(obj != null) {
			name = String.valueOf(obj);
		} else {
			resp.sendRedirect("/TrungTamJava_Servlet/sessoon1");
		}
		
		int age = Integer.valueOf(String.valueOf(httpSession.getAttribute("age")));
		PrintWriter pw = resp.getWriter();
		pw.println("Xin chao "+name+" - "+age);
	}
}
