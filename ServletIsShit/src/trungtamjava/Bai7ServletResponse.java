package trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/test-response"})
public class Bai7ServletResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp: nội dung từ server trả về cho client
		resp.setContentType("text/html");  //thiết lập nội dung trả về là kiểu text, và là kiểu html
		//resp.setContentType("text/plain");  //nếu để như thế này thì nó trả về kiểu plain text, nghĩa là với VD ở dưới server sẽ trả về 1 dòng như sau: <h1>Hello trung tam java</h1>, nghĩa là có cả thẻ <h1>
		
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Hello trung tam java</h1>");
//		resp.addCookie(new Cookie("a", "a"));
//		resp.addHeader("this_is_key", "this is value");
//		resp.sendError(200);
		
		pw.close();
	}
	
}
