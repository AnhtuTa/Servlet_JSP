package studyandshare;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
//@WebServlet(urlPatterns={"/hello"})
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadParameter(request, response, "doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadParameter(request, response, "doPost");
	}

	private void loadParameter(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
		PrintWriter pw = response.getWriter();
		pw.println("Hello world by "+method);
		pw.println("This tutorial was created by Study and share");
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		if(user.equals("anhtu") && pass.equals("5555")) {
			pw.println("Hello "+user);
		} else {
			pw.println("username or password is incorrect!");
		}
		
	}
}
