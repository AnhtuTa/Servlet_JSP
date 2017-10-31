package bai21_Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/session1"})
public class Session1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();		//Tạo mới session nếu chưa có, nếu có rồi thì lấy
		httpSession.setAttribute("name", "anh tu ta");
		httpSession.setAttribute("age", new Integer(23));
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("Xin chao anhtu - set session");
	}
}
