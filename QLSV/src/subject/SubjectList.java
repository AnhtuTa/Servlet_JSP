package subject;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Subject;
import database.SubjectUtils;
import servlet_login.SelectRoleServlet;

/**
 * Servlet implementation class SubjectList
 */

public class SubjectList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Subject> subjectList;
	//Course [] subjects;
	//int index;
	//boolean isFinalPage;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	SubjectUtils su = new SubjectUtils();
		su.connect();
		subjectList = su.getAllSubjects();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("subjectList", subjectList);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser + "/subject_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
