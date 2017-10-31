package tutorialspoint;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageHitCounter
 */
@WebServlet("/PageHitCounter")
public class PageHitCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int hitCount; 

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		hitCount = 0;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// This method executes whenever the servlet is hit
		// increment hitCount
		hitCount++;
		PrintWriter pw = response.getWriter();
		pw.println("<h1 align=\"center\">Total Number of Hits</h1>\n");
		pw.println("<h2 align=\"center\">" + hitCount + "</h2>\n");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
