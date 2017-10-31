<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page isErrorPage="true" %>
	<h1>Error</h1>
	<p>Math.jsp reported the following error: <i><%=exception %></i>. This problem occured in following place</p>
	<pre>
		<%@ page import="java.io.*" %>
		<% exception.printStackTrace(new PrintWriter(out)); %>
	</pre>
</body>
</html>