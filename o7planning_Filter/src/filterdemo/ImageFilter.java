package filterdemo;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
		urlPatterns={"*.jpg", "*.png", "*.PNG", "*.gif"},
		initParams={@WebInitParam(name="notFoundImage", value="/images/no_image.PNG")}
)
public class ImageFilter implements Filter {

	private String notFoundImage;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("ImageFilter destroyed!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		printExamples(req);
		String servletPath = req.getServletPath();
		//Nếu truy cập link http://localhost:8080/o7planning_Filter/images/flower.PNG
		//thì servletPath = /images/flower.PNG
		//
		//Nếu truy cập link http://localhost:8080/o7planning_Filter/images/abefwijfkeaw.PNG
		//thì servletPath = /images/abefwijfkeaw.PNG
		//sau đó servletPath = /images/no_image.PNG
		
		// Đường dẫn tuyệt đối của thư mục gốc của WebApp (WebContent).
		String rootPath = request.getServletContext().getRealPath("");
		//rootPath = C:\Users\AnhTu\Dropbox\Java EE projects\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\o7planning_Filter\
		
		// Đường dẫn tuyệt đối tới file ảnh.
		String imagePath = rootPath + servletPath;
		//imagePath = C:\Users\AnhTu\Dropbox\Java EE projects\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\o7planning_Filter\/images/flower.PNG

		File file = new File(imagePath);
		// Kiểm tra xem ảnh có tồn tại không.
		if (file.exists()) {
			// Cho phép request được đi tiếp. (Vượt qua Filter này).
			// (Để đi tiếp tới file ảnh yêu cầu).
			chain.doFilter(request, response);
		} else if (!servletPath.equals(this.notFoundImage)) {
			// Redirect (Chuyển hướng) tới file ảnh 'image not found'.
			// ==> /o7planning_Filter + /images/image-not-found.png
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath() + this.notFoundImage);
			//tương đương với resp.sendRedirect("http://localhost:8080/o7planning_Filter/images/no_image.PNG");
			
			//có thể sử dụng chuyển tiếp (Forward) thay vì chuyển hướng (Redirect)
			//req.getRequestDispatcher(this.notFoundImage).forward(req, resp);
			//tương đương với req.getRequestDispatcher("/images/no_image.PNG").forward(req, resp);
			
			//có thể thấy sự khác nhau của tham số giữa sendRedirect và forward
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		notFoundImage = filterConfig.getInitParameter("notFoundImage");
	}

	private void printExamples(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();	//đường dẫn tương đối của servlet mà ta đang gọi, do phần này gọi tới 1 image nên đường dẫn này là vị trí của ảnh đó
		int contentLength = request.getContentLength();
		String authType = request.getAuthType();
		String rootPath = request.getServletContext().getRealPath("");	// Đường dẫn tuyệt đối của thư mục gốc của WebApp (WebContent).
		String imagePath = rootPath + servletPath;		//đường dẫn tuyệt đối của ảnh mà client request trên đường link
		
		System.out.println("[demo] contextPath = "+contextPath);
		System.out.println("[demo] servletPath = "+servletPath);
		System.out.println("[demo] contentLength = "+contentLength);
		System.out.println("[demo] authType = "+authType);
		System.out.println("[demo] rootPath = "+rootPath);
		System.out.println("[demo] imagePath = "+imagePath);
		/*
		 * truy cập http://localhost:8080/o7planning_Filter/images/flower.PNG
		 * kq: 
		 *  [demo] contextPath = /o7planning_Filter
			[demo] servletPath = /images/flower.PNG
			[demo] contentLength = -1
			[demo] authType = null
			[demo] rootPath = C:\Users\AnhTu\Dropbox\Java EE projects\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\o7planning_Filter\
			[demo] imagePath = C:\Users\AnhTu\Dropbox\Java EE projects\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\o7planning_Filter\/images/flower.PNG
		 */
	}
}
