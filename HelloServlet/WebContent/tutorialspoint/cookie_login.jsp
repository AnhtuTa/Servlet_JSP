<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String uname="", pw="";
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				String str = c.getName();
				if(str.equals("user_ck")) uname = c.getValue();
				else if(str.equals("pass_ck")) pw = c.getValue();
			}
		}
	%>
	<form action="../CookieLogin" method="post">
		Username: <input type="text" name="user" value="<%=uname %>" /><br />
		Password: <input type="password" name="pass" value="<%=pw %>" /><br />
		<input type="submit" value="Go" />
	</form>
</body>
</html>