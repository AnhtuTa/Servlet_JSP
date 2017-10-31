package trungtamjava;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/redirect-fb"})
public class Bai15_ServletRedirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//chuyển hướng tới trang sau:
		//resp.sendRedirect("https://www.facebook.com/taanhtu95");
		
		//cach2:
		resp.setStatus(resp.SC_MOVED_PERMANENTLY);
		resp.setHeader("Location", "https://www.facebook.com/taanhtu95");
	}
}
