package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadParameter(request, response, "doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadParameter(request, response, "doPost");
	}

	private void loadParameter(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
		PrintWriter pw = response.getWriter();
		pw.println("Hello world by "+method);
		pw.println("This tutorial was created by Study and share");
		
		ServletConfig config = this.getServletConfig();
		String baihat = config.getInitParameter("song");	//servlet parameter
		pw.println("This is the default value of song: "+baihat);
		String param = config.getInitParameter("param_from_jsp");
		pw.println("param_from_jsp = " + param);	//null, vì param_from_jsp chỉ là biến local đc init trong sample.jsp, nghĩa là chỉ thằng jsp đó có thể xài đc
		
		ServletContext context = this.getServletContext();	//chú ý: config chỉ của riêng thằng HelloWorld này thôi, còn context là của chung cho tất cả, mỗi thằng servlet có config khác nhau nhưng đều chung thằng context
		String userDefault = context.getInitParameter("user_default");
		String passDefault = context.getInitParameter("pass_default");
		pw.println("user default is: " + userDefault);
		pw.println("pass default is: " + passDefault);

		String song_globalParam = context.getInitParameter("song");		//context parameter
		pw.println("value of global song is: " + song_globalParam);
	}
}
