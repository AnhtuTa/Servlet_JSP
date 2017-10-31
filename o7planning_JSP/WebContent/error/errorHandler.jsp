<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Error handler</h2>
	Message:
	<%=exception.getMessage() %>
	<!-- If use: exception.getMessage(); there's nothing will be print because exception.getMessage() return a String and do nothing -->
	<h3>StackTrace:</h3>
	<%
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		out.println("<pre>");
		out.println(sw);
		out.println("</pre>");
		pw.close();
		sw.close();
	%>
	
	<!-- anothe way to write down error more simple below -->
	<br/><br/>Message <i>another way to display:</i>
	<pre>
	<%
		exception.printStackTrace(new PrintWriter(out));
	%>
	</pre>
</body>
</html>