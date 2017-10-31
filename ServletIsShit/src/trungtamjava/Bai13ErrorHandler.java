package trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Chú ý, chạy trên trình duyệt mới đc chứ chạy = eclipse ko đc, cụ thể ví dụ ta truy cập link:
//http://localhost:8080/ServletIsShit/abcdnfakfefe
//nó sẽ thông báo lỗi chứ ko hiện trang 404 nữa

@WebServlet(urlPatterns={"/handle-error"})
public class Bai13ErrorHandler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("Da xay ra loi, vui long thu lai");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
