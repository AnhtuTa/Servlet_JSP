package trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/refresh"})
public class Bai16AutoRefresh extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setHeader("Refresh", "1");		//key = Refresh, trong 1 giay
		
		PrintWriter pw = resp.getWriter();
		pw.println("thoi gian hien tai: "+new Date());
		
	}
	
}
