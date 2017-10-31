package contactdemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DatabaseManagement;
import objects.Contact;

/**
 * Servlet implementation class CheckPhone
 */
@WebServlet("/CheckPhone")
public class CheckPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseManagement dm = new DatabaseManagement();
		//Connection conn = dm.connect();
		System.out.println(request.getParameter("tfPhone"));
		Contact ct = dm.getContactByPhone(request.getParameter("tfPhone"));
		if(ct != null) {
			request.setAttribute("foundContact", ct);
			request.getRequestDispatcher("show_contact.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("contact_not_found.jsp").forward(request, response);
		}
		
	}

}
