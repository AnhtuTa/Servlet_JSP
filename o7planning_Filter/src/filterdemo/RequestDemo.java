package filterdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo
 */
@WebServlet("/RequestDemo")
public class RequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		int contentLength = request.getContentLength();
		String authType = request.getAuthType();
		//request.get
		
		PrintWriter pw = response.getWriter();
		pw.println("contextPath = "+contextPath);
		pw.println("servletPath = "+servletPath);
		pw.println("contentLength = "+contentLength);
		pw.println("authType = "+authType);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
