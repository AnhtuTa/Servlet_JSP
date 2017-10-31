package servlet_student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Fee;
import database.FeeUtils;
import servlet_home.HomeServlet;
import servlet_login.LoginServlet;

/**
 * Servlet implementation class StudentFee
 */
@WebServlet("/my-fee")
public class MyFee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FeeUtils fu = new FeeUtils();
		fu.connect();
		Fee f = fu.getStudentFee(LoginServlet.loginedStudent.getId(), HomeServlet.currentTerm);
		
		request.setAttribute("infoString", "Học phý kỳ " + HomeServlet.currentTerm + " của sinh viên " + LoginServlet.loginedStudent.getId());
		request.setAttribute("fee", f);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/fee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
