package servlet_home;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet_login.SelectRoleServlet;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String startNewYear, today;
	public static int currentTerm;

	@Override
	public void init() throws ServletException {
		System.out.println("[HomeServlet] This is init()");
		Calendar cNow = Calendar.getInstance();
		today = cNow.get(Calendar.DAY_OF_MONTH) + "/" + (cNow.get(Calendar.MONTH)+1) + "/" + cNow.get(Calendar.YEAR);
		startNewYear = this.getServletContext().getInitParameter("startNewYear");
		currentTerm = Integer.valueOf(this.getServletContext().getInitParameter("currentTerm"));
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("currentTerm", currentTerm);
		session.setAttribute("today", today);
		try {
			Date startNewYearDate = df.parse(startNewYear);
			long startNewYearTime = startNewYearDate.getTime();
			long currentTime = System.currentTimeMillis();
			
			int chenhLechNgay = (int) ((currentTime - startNewYearTime)/(24*3600*1000));
			int currentWeek = (chenhLechNgay/7 + 1);
			session.setAttribute("currentWeek", currentWeek);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/home_" + SelectRoleServlet.roleOfUser + ".jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void main(String[] args) {
		try {
			Date startNewYearDate = df.parse("21/08/2017");
			long startNewYearTime = startNewYearDate.getTime();
			long currentTime = System.currentTimeMillis();
			
			int chenhLechNgay = (int) ((currentTime - startNewYearTime)/(24*3600*1000));
			System.out.println("chenhLechNgay = "+chenhLechNgay);
			System.out.println("current week = "+ (chenhLechNgay/7 + 1));
			
			Calendar cNow = Calendar.getInstance();
			System.out.println(cNow.get(Calendar.DAY_OF_MONTH) + " - " + (cNow.get(Calendar.MONTH)+1) + " - " + cNow.get(Calendar.YEAR));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
