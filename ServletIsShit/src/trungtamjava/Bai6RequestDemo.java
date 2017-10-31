package trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/test-request"})
public class Bai6RequestDemo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req sẽ chứa tất cả thông tin từ client gửi lên server
		//Ví dụ in ra console các thông tin sau:
		System.out.println(req.getContentType());
		System.out.println(req.getContextPath());
		System.out.println(req.getSession());
		System.out.println(req.getServerName());
		System.out.println(req.getServletPath());
		
		System.out.println("\nCac keys lay tu client:\n");
		Enumeration<String> keys = req.getHeaderNames();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key +":" + req.getHeader(key));
		}
        
        ServletOutputStream out = resp.getOutputStream();
    	out.println("<html>");
        out.println("<head><title>Hello world</title></head>");
        out.println("<body>");
        out.println("<p>Bai nay phai xem phan console</p>");
        out.println("</body>");
        out.println("<html>");
	}
	
}
