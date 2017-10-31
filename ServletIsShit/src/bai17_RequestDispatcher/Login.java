package bai17_RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String user = req.getParameter("user");
		if(user.equalsIgnoreCase("anhtu")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome");
			dispatcher.forward(req, resp);	//forword toàn bộ request và responese cũng như các phương thức là POST hay GET sang 1 servlet khác là /welcome 
		} else {
			pw.println("user ko chinh xac! vui long nhap lai!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/form-login");
			//include nội dung của /form-login:
			dispatcher.include(req, resp);
			//nếu ko có hàm trên thì nếu nhập sai nó chỉ hiện dòng user ko chinh xac... mà ko còn cái form-login nữa
			
		}
	}
	
}
