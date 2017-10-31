package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DatabaseManagement;

/**
 * Servlet implementation class Controller
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("tennguoidung");
		String pass = request.getParameter("matkhau");
		
		if(DatabaseManagement.checkUser(user.trim(), pass.trim())) {
			//sau lần đăng nhập đầu tiên, nếu đăng nhập đúng thì gửi 1 session là 1 String.
			//Sau này nếu người dùng cần đăng nhập lại thì chỉ cần kiểm tra String đó,
			//nếu nó null thì mới phải login lại, nếu khác null thì ám chỉ đã login rồi và ko cần login nữa!
			HttpSession session = request.getSession();
			session.setAttribute("controller_tendangnhap", user);		//sẽ dùng bên GokuController.java
			//CHÚ Ý: comment dòng ở trên và chạy lại, khi muốn xem ảnh goku thì phải đăng nhập lại!
			//cần chạy lại ở browser khác hoặc xóa hết session trước khi chạy lại!
			//session.invalidate();	//xóa hết session
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}
	}

}
