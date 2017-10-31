<%@page import="java.util.Date"%>
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
	// Ví dụ sử dụng biến out.
	out.println("<h1>Now is "+ new Date()+"</h1>");
	 
	// Ví dụ sử dụng biến request
	String serverName= request.getServerName();
	out.println("serverName = "+serverName);
	 
	// Ví dụ sử dụng biến response
	//response.sendRedirect("http://eclipse.org");
	 
	%>
</body>
</html>