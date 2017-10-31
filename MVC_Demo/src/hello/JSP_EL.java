package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.Student;

/**
 * Servlet implementation class JSP_EL
 */
@WebServlet("/JSP_EL")
public class JSP_EL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		this.getServletContext().setAttribute("otherScope", "Application scope");
		session.setAttribute("otherScope", "session scope");
		request.setAttribute("otherScope", "request scope");	//hàm fineAttribute sẽ tìm thằng này trước thằng ở trên
		
		Student st = new Student("Portgas D. Ace");
		request.setAttribute("stAce", st);
		
		List<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("C#");
		languages.add("PHP");
		languages.add("IOS");
		request.setAttribute("languages", languages);
		
		request.getRequestDispatcher("JSPDemo/JSP_EL.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
