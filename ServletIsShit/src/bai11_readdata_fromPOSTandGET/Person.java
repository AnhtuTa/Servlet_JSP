package bai11_readdata_fromPOSTandGET;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/add-person"})
public class Person extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//client gui len server:
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String addr = req.getParameter("address");
		
		pw.println("name = "+name+" age = "+age+" address = "+addr);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("this method is GET");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String addr = req.getParameter("address");
		
		pw.println("name = "+name+" age = "+age+" address = "+addr);
		
	}
	
	
}
