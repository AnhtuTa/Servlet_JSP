package trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Bai8_2ConfigInWebxml extends HttpServlet {

	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = super.getServletConfig().getInitParameter("myname");
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		pw.println("Hello "+name);	//lấy giá trị myname đc khởi tạo ở phần annotation
		pw.println("ServletConfig = "+getServletConfig().getServletName());
		pw.close();
	}
	
}
