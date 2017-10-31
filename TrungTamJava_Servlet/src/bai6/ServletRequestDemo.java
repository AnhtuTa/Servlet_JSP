package bai6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/test-request"})

public class ServletRequestDemo extends HttpServlet {
	String name;
	
	private static final long serialVersionUID = 1L;
	
    @Override
    public void init() throws ServletException {
    	int a = 193932;
    	
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
