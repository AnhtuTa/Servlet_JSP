package servlet_student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Teacher;
import database.TeacherUtils;


/**
 * Servlet implementation class SearchTeacher
 */

public class SearchTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/search_teacher.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtTeacherID = request.getParameter("txtTeacherID");
		String txtTeacherName = request.getParameter("txtTeacherName");
		TeacherUtils tu = new TeacherUtils();
		List<Teacher> tcList = null;
		tu.connect();
		
		if(txtTeacherID == null && txtTeacherName == null) {
			request.setAttribute("errorString", "Please enter something to search!");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/search_teacher.jsp").forward(request, response);
			return;
		}
		
		if(txtTeacherID != null && txtTeacherName != null) {
			tcList = tu.getTeachersLikeIDAndName(txtTeacherID, txtTeacherName);
		} else if(txtTeacherID != null) {
			tcList = tu.getTeachersLikeID(txtTeacherID);
		} else if(txtTeacherName != null) {
			tcList = tu.getTeachersLikeName(txtTeacherName);
		}
		request.setAttribute("tcList", tcList);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/search_teacher.jsp").forward(request, response);
	}

}
