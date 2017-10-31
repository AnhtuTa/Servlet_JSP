<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><b>Param1: </b><%=request.getParameter("param1") %>
		<li><b>Param2: </b><%=request.getParameter("param2") %>
		<li><b>Param3: </b><%=request.getParameter("param3") %>
	</ul>
</body>
</html>