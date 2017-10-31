package view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ImageShow
 */
@WebServlet(urlPatterns={"/ImageShow"})
public class ImageShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(request == null || response==null) {
				System.out.println("request, response null");
			}
			doCheck(request, response);
		} catch (Exception e) {
			System.out.println("[ImageShow] Error");
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doCheck(request, response);
		
	}

	private void doCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Da vao imageshow");
		HttpSession session = request.getSession();
		//String user = (String) request.getAttribute("user");
		String user = (String) session.getAttribute("user");
		if(user==null) {
			RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
			dispacher.forward(request, response);
		} else {
			for(Cookie c : request.getCookies()) {
				System.out.println(c.getName()+": "+c.getValue());
			}
			RequestDispatcher dispacher = request.getRequestDispatcher("nguyenbka.jsp");
			dispacher.forward(request, response);
		}
		
	}

}
