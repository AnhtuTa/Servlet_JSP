<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link href="website.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h3>Login Page</h3>
	<p style="color: red;">${errorWhenLogin}</p>
	
	<form action="${pageContext.request.contextPath}/login" method="POST">		<!-- action = LoginServlet.java -->
		<table style="margin-bottom: 10px;">
			<tr>
				<td style="padding-right: 5px;">Username</td>
				<td><input type="text" name="txtUser" style="width: 150px;"></td>
			</tr>
			<tr>
				<td style="padding-right: 5px;">Password</td>
				<td><input type="password" name="txtPass" style="width: 150px;"></td>
			</tr>
		</table> 
		<input type="submit" value="OK" style="width: 50px;">
		<a href="${pageContext.request.contextPath}/">Cancel</a>
	</form>
	
	<p style="color:blue;">Login with:</p>
	employee1/123 <br>
	manager1/123 <br/>
	admin/123
</body>
</html>