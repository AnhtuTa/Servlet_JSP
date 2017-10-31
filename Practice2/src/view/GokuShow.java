package view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DatabaseManagement;

/**
 * Servlet implementation class GokuShow
 */
public class GokuShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GokuShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showGoku(request, response);
	}

	private void showGoku(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("gokulogin_tennguoidung");
		String pass = request.getParameter("gokulogin_matkhau");
		
		if(DatabaseManagement.checkUser(user, pass)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("images/goku.png");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("goku_login.html");
		}
	}

}
