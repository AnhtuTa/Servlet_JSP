package jsp_cookie;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class CookieUtils {
	public static void userCookieDemo(HttpServletRequest request, HttpServletResponse response, JspWriter out) throws IOException {
		boolean found = false;
		
		//danh sách cookie được website này lưu vào máy tính người dùng.
		Cookie [] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			String userName = null, lastLoginDatetime = null;
			out.println("<h3>Cookie list:</h3>");
			
			for(int i=0; i<cookies.length; i++) {
				out.println(cookies[i].getName() + " : " + cookies[i].getValue() + "<br>");
				if(cookies[i].getName().equals("userName")) userName = cookies[i].getValue();
				else if(cookies[i].getName().equals("lastLoginDatetime")) lastLoginDatetime = cookies[i].getValue(); 
			}
			
			if(userName != null && lastLoginDatetime != null) {
				found = true;
				out.println("<h4>Last login info:</h4>");
	            out.println("User Name: " + userName + "<br>");
	            out.println("Last Login Datetime: " + lastLoginDatetime + "<br>");
			}
			
			if(found == false) {
				out.println("<h3>No cookies founds!, write some cookies into client computer</h3>");
				
				// Ghi một vài thông tin Cookie vào máy tính người dùng.
		        // Chẳng hạn như userName họ đã từng login.
		        // Đây là cách nhớ user đã login
		        // Sau đây là việc mô phỏng ghi Cookie vào máy tính người dùng sau khi họ vừa login.
				
				userName = "someUserName";
				Cookie cookieUserName = new Cookie("userName", userName);
				
		        DateFormat df = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		        Date now = new Date();
		        lastLoginDatetime = df.format(now);
		        System.out.println("lastLoginDatetime = "+lastLoginDatetime);
		        Cookie cookieLoginDatetime = new Cookie("lastLoginDatetime", lastLoginDatetime);
		        
		        // Sét đặt thời gian sống của Cookie là 24h (Đã đổi ra giây).
		        cookieUserName.setMaxAge(24 * 60 * 60);
		        cookieLoginDatetime.setMaxAge(24 * 60 * 60);
		        
		        // ghi vào máy tính người dùng
		        response.addCookie(cookieUserName);
		        response.addCookie(cookieLoginDatetime);
			}
		}
	}
}