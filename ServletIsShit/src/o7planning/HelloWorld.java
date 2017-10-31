package o7planning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    @Override
    public void init() throws ServletException {
    	System.out.println("init servlet");
    }

    @Override
    public void destroy() {
    	System.out.println("Destroy servlet");
    }
    
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.service(arg0, arg1);
    	System.out.println("phuong thuc cua request: "+arg0.getMethod());
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
//    	ServletOutputStream out = resp.getOutputStream();
//    	out.println("<html>");
//        out.println("<head><title>Hello world</title></head>");
//         
//        out.println("<body>");
//        out.println("<p>I'm taanhtu</p>");
//        out.println("</body>");
//        out.println("<html>");
        
        resp.setContentType("text/html");
        
        PrintWriter pw = resp.getWriter();
        pw.println("hello, this is Trung tam Java's lesson!");
        pw.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
}
