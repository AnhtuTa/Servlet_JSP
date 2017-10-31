package bai19_Cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/servlet1"})
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<font color='red'>hello</font> <font color='blue'>anhtu</font>");
		
		//create cookie:
//		Cookie cookie1 = new Cookie("name", "ta anh tu");
//		cookie1.setMaxAge(5);	//thoi gian song = 5 giay
//		resp.addCookie(cookie1);	//TẠI SAO DÒNG NÀY LẠI BỊ LỖI? Chằng lẽ tham số thứ 2 phải ko có dấu cách? KO PHẢI!
		
		Cookie c1 = new Cookie("myname", "anhtu");
		c1.setMaxAge(5);
		resp.addCookie(c1);
		
		//create another Cookie Object:
		Cookie c2 = new Cookie("age", "23");
		c2.setMaxAge(10);
		resp.addCookie(c2);
		
	}
}
