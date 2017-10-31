<%@page import="objects.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search result</title>
</head>
<body>
	<h3>Search result</h3>
	<%
		Contact ct = (Contact) request.getAttribute("foundContact");
		out.println("Name: "+ct.getName() + "<br/>");
		out.println("\tPhone: "+ct.getPhone() + "<br/>");
		out.println("\tAddress: "+ct.getAddress() + "<br/>");
	%>
</body>
</html>