package bai24_filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Logger implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}


	//Dùng để xử lí req gửi lên và resp trả về
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//xử lý các request đến:
		System.out.println("filter 1");
		
		//cho phép req đi đến servlet đích:
		arg2.doFilter(arg0, arg1);	//cho phép request đi đến filter tiếp theo hoặc đi đến servlet đích
		
		//xử lý response:
		arg1.setContentType("text/plain");
		
	}

	

}
