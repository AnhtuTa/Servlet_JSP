package trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/get-request"})
//go to this link: http://localhost:8080/ServletIsShit/get-request?name=Ta anh tu&faculty=dien tu vien thong nhu shit&school=dai hoc bach khoa ha noi
//chu y la co ca dau cach nhe!

public class Bai10GetRequestFromURL extends HttpServlet {

	//chú ý: gửi qua 1 URL thì phương thức mặc định là get
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		pw.println("test");
		
		//lay ten from client:
		String ten = req.getParameter("name");
		String faculty = req.getParameter("faculty");
		String school = req.getParameter("school");
		
		pw.println("ten = "+ten);
		pw.println("\nfaculty = "+faculty);
		pw.println("\nSchool = "+school);
	}
	
}
