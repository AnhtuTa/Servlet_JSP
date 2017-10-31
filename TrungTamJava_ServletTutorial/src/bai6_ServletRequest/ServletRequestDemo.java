package bai6_ServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/test-request"})

public class ServletRequestDemo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String demo;
	int id;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req là đối tượng request từ client gửi lên
		System.out.println("phuong thuc cua request = "+req.getMethod());
		//req chứa tất cả thông tin mà client gửi lên server
		System.out.println(req.getContentType());
		System.out.println(req.getServerName());
		System.out.println(req.getContextPath());
	}
	
}
