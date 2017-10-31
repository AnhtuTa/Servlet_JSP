package utils;

import javax.servlet.http.HttpSession;

import bean.UserAccount;

public class AppUtils {
	public static void storeLoginedUser(HttpSession session, UserAccount user) {
		session.setAttribute("loginedUser", user); 	// Trên JSP có thể truy cập thông qua ${loginedUser}
	}
	
	public static UserAccount getLoginedUser(HttpSession session) {
		return (UserAccount) session.getAttribute("loginedUser");
	}
}
