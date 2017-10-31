<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is error page!</title>
</head>
<body>
	<b>This is error page for chia-2-so.jsp</b>
	<h1 style="color: red;">Error!</h1>
	<h3>There're some errors occured, idiot!</h3>
	<h5>Here's some detail informations</h5>
	<pre>
	<%
		exception.printStackTrace(new PrintWriter(out));
	%>
	</pre>
</body>
</html>