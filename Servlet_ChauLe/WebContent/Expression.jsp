<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP Expression</h2>
	<ul>
		<li>Current time: <%= new java.util.Date() %>
		<li>Server: <%=application.getServerInfo() %>
		<li>Session IDL <%= session.getId() %>
		<li>The <code>testParam</code> from parameter: <%= request.getParameter("testParam") %>
	</ul>
</body>
</html>
<!-- run demo: http://localhost:8080/Servlet_ChauLe/Expression.jsp?testParam=Anhtuta -->