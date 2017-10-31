package filterdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/***
 * 
 * @author AnhTu
 * Cũng giống với Servlet, bạn có thể khởi tạo các tham số cho Filter.
 * Ví dụ dưới đây một Filter làm nhiệm  vụ ghi ra log vào một file, 
 * bạn có thể cấu hình trong web.xml tên file để ghi.
 */
public class Log2Filter implements Filter {

	private String logFile;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();
		if(logFile!=null) {
			PrintWriter pw = new PrintWriter(logFile);
			pw.println("[Log2Filter] #INFO " + new Date() + " - ServletPath :" + servletPath + ", URL =" + req.getRequestURL());
			pw.close();
		} else {
			System.out.println("File not found!");
		}
		// Cho phép request được đi tiếp. (Vượt qua Filter này).
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.logFile = fConfig.getInitParameter("logFile");
		System.out.println("logFile = "+logFile);
	}

}