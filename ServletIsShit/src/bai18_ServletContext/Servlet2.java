package bai18_ServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/servlet2"})
public class Servlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String name = (String) getServletContext().getAttribute("name");
		//name lấy giá trị từ getServletContext, và context này đc thiết lập bên class Servlet1.java
		//vậy đối tượng ServletContext có thể đc truy xuất ở mọi nơi trong servlet và 
		//mọi servlet có thể đọc đc.
		//ngoài ra có thể cấu hình đối tượng ServletContext trong web.xml
		
		pw.println("Hello "+name);
		
		String myname = getServletContext().getInitParameter("myname");
		pw.println("this is servlet2. my name = "+myname);
	}
}
