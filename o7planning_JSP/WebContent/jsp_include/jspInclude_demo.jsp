<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP include demo</title>
</head>
<body>
	<h2>This is demo of jsp:include action <i>(Note: this is diffirent with jsp_include directive)</i></h2>
	<jsp:include page="dateTime.jsp"></jsp:include>
	
	<%@include file="../directive_include/footer.html" %>
</body>
</html>