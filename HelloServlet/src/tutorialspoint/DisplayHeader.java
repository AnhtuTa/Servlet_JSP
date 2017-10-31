package tutorialspoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayHeader
 */
@WebServlet(urlPatterns={"/DisplayHeader"})
public class DisplayHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h3>Header Name - Header Value(s)</h3><br/>");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String paramName = headerNames.nextElement();
			pw.print("<b>" + paramName + "</b> - ");
			String paramValue = request.getHeader(paramName);
			pw.println(paramValue + "<br/>");
		}
		
		//hiện tại chưa có Attribute nào
		Enumeration<String> atbNames = request.getAttributeNames();
		while(atbNames.hasMoreElements()) {
			String paramName = atbNames.nextElement();
			pw.print("<b>" + paramName + "</b> - ");
			String paramValue = (String) request.getAttribute(paramName);
			pw.println(paramValue + "<br/>");
		}

		pw.println("<br/><h3>Parameter Name - Parameter Value(s)</h3><br/>");
		Enumeration<String> paraNames = request.getParameterNames();
		while(paraNames.hasMoreElements()) {
			String paramName = paraNames.nextElement();
			pw.print("<b>" + paramName + "</b> - ");
			String paramValue = (String) request.getParameter(paramName);
			pw.println(paramValue + "<br/>");
		}
		
		pw.println("<br/>getMethod(): "+request.getMethod());
		pw.println("<br/>getAuthType(): "+request.getAuthType());
		pw.println("<br/>getCharacterEncoding(): "+request.getCharacterEncoding());
		pw.println("<br/>getContentType(): "+request.getContentType());
		pw.println("<br/>getPathInfo(): "+request.getPathInfo());
		pw.println("<br/>getProtocol(): "+request.getProtocol());
		pw.println("<br/>getQueryString(): "+request.getQueryString());
		pw.println("<br/>getRemoteAddr(): "+request.getRemoteAddr());
		pw.println("<br/>getRemoteHost(): "+request.getRemoteHost());
		pw.println("<br/>getRequestURI(): "+request.getRequestURI());
		pw.println("<br/>getRequestedSessionId(): "+request.getRequestedSessionId());
		pw.println("<br/>getServletPath(): "+request.getServletPath());
		pw.println("<br/>isSecure(): "+request.isSecure());
		pw.println("<br/>getContentLength(): "+request.getContentLength());
		pw.println("<br/>getServerPort(): "+request.getServerPort());
	}
	//LINK: http://localhost:8080/HelloServlet/DisplayHeader?ten=anhtu&tuoi=23&school=HUST

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
