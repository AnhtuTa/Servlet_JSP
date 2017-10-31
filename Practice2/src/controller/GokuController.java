package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GokuController
 */
public class GokuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkLoginYet(request, response);
	}

	private void checkLoginYet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("controller_tendangnhap");
		if(user != null && !user.equals("")) {
			System.out.println("user = "+user);
			//đã đăng nhập rồi!
			System.out.println("Da login roi!");
			RequestDispatcher dispacher = request.getRequestDispatcher("images/goku.png");
			dispacher.forward(request, response);
		} else {
			//chưa đăng nhập lần nào cả
			System.out.println("Chua login!");
			RequestDispatcher dispacher = request.getRequestDispatcher("goku_login.html");
			dispacher.forward(request, response);
		}
		
	}
}
