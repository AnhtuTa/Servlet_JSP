package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DatabaseManagement;
import objects.MyImage;

/**
 * Servlet implementation class Authentication
 */
//Controler= Authentication.java
//Model=database(images,...)
//View=jsp (includes: login, show)

public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		DatabaseManagement dm=new DatabaseManagement();
		
		Cookie cookie = new Cookie("location", "Vietnam");
		response.addCookie(cookie);
		
		if(dm.checkUser(username, password)) {
			HttpSession session = request.getSession();
			
			RequestDispatcher dispacher = request.getRequestDispatcher("/ImageShow");	//dispacher có thể gọi tới 1 servlet khác hoặc 1 trang jsp
			request.setAttribute("imageName", "Songoku vs Vegeta");		//chuyển data từ thằng servlet này sang thằng show.jsp, vì thằng show.jsp dùng nó 
			//request.setAttribute("user", username);
			session.setAttribute("user", username);		//nếu dùng session thì sau khi đăng nhập, load lại trang sẽ ko phải đăng nhập lại nữa, nhưng nếu dùng request.setAttribute thì phải login lại 
			
			MyImage img = new MyImage("Goku and vegeta", 200, 300);
			request.setAttribute("gokuImage", img);
			dispacher.forward(request, response);
		}
		else {
			response.sendRedirect("login.jsp"); //nếu nhập sai thì giao diện vẫn là trang login này
			
		}
		
	}
}
