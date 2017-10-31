package servlet_student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SVClass;
import database.SVClassUtils;

/**
 * Servlet implementation class SearchClass
 */
@WebServlet("/search-class")
public class SearchClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub search_class
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/search_class.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classID = request.getParameter("classID");
		//String className = request.getParameter("className");
		SVClassUtils svc = new SVClassUtils();
		svc.connect();
		
		if(!"".equals(classID)) {
			try {
				List<SVClass> clList = svc.getClassByID(Integer.valueOf(classID));
				if(clList == null) {
					request.setAttribute("errorString", "Mã lớp không tồn tại!");
					System.out.println("class not exist!");
				}
				request.setAttribute("clList", clList);
				request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/search_class.jsp").forward(request, response);
			} catch (java.lang.NumberFormatException ex) {
				request.setAttribute("errorString", "Wrong format for class ID");
				request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/search_class.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorString", "Please enter a class ID");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/student/search_class.jsp").forward(request, response);
		}
	}

}
