<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Include Directive</title>
</head>
<body>
	<%@include file="header.html" %>
	<h2>JSP tutorial for newbie</h2>
	<div>Hi! This is JSP tutorial...</div>
	<h3>This is demo of jsp_include directive <i>(Note: this is diffirent with jsp:include action)</i></h3>
	
	<%@include file="footer.html" %>
	
	<jsp:include page="../jsp_include/dateTime.jsp"></jsp:include>
</body>
</html>