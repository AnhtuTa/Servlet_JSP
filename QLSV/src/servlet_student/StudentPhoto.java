//package servlet_student;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import database.StudentUtils;
//
///**
// * Servlet implementation class StudentPhoto
// */
//@WebServlet("/student-photo")
//public class StudentPhoto extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String studentID = request.getParameter("studentID");
//		StudentUtils su = new StudentUtils();
//		su.connect();
//		try {
//			response.getOutputStream().write(su.getStudentPhoto(Integer.valueOf(studentID)));
//		} catch (java.lang.NumberFormatException e) {
//			System.out.println("[StudentPhoto] MSSV ko hop le");
//			request.getRequestDispatcher("/ErrorNumberFormat.html").forward(request, response);
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
