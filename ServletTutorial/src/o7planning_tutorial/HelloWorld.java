package o7planning_tutorial;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;
	 
    public HelloWorld() {}
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	ServletOutputStream out = resp.getOutputStream();
    	out.println("<html>");
        out.println("<head><title>Hello world</title></head>");
         
        out.println("<body>");
        out.println("<p>I'm taanhtu</p>");
        out.println("</body>");
        out.println("<html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
}
