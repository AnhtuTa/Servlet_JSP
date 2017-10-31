package tutorialspoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatusCodeDemo
 */
@WebServlet("/StatusCodeDemo")
public class StatusCodeDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int errorNum = Integer.valueOf(request.getParameter("errorNumber"));
		System.out.println("errorNum = "+errorNum);
		//response.sendError(407, "Ý nghĩa của status code 407: Proxy Authentication Required   <br/>Bạn phải xác nhận với một Proxy server trước khi yêu cầu này có thể được phục vụ?");
		response.sendError(errorNum, "This is a message for demo! Please read the description below for more information");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
