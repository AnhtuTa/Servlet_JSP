package bai11_readdata_fromPOSTandGET;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/form-person"})
public class FormPerson extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<form action='/ServletIsShit/add-person' method='post'>");
		//sau khi ấn submit thì nó sẽ gọi tới /add-person
		//nếu method='get' thì sau khi nhập form và ấn submit nó chuyển tới link sau:
		//http://localhost:8080/ServletIsShit/add-person?name=anhtu&age=23&address=ha+noi
		//và kq trang web có dòng này:
		//this method is GET name = anhtu age = 23 address = ha noi 
		
		//nếu method='post' thì sau khi nhập form và ấn submit nó chuyển tới link sau:
		//http://localhost:8080/ServletIsShit/add-person
		//và kq trang web có dòng này tương tự như trên:
		//this method is GET name = anhtu age = 23 address = ha noi 
		
		//Nhận xét: GET và POST khác nhau ở chỗ đường link đó, GET thì hiển thị tất cả thông tin
		//do đó nếu thông tin thay đổi thì luôn có 1 đường link mới, ví dụ ServletIsShit/add-person?name=songoku&age=73&address=Tokyo
		//nhưng với POST thì link luôn ko đổi và = ServletIsShit/add-person
		
		pw.println("ten: <input type='text' name='name'>");
		pw.println("tuoi: <input type='text' name='age'>");
		pw.println("dia chi: <input type='text' name='address'>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		
		
	}
	
}
