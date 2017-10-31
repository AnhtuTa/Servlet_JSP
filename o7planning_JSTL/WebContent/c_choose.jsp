<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>c:choose,c:when,c:otherwise example</h2>
	<c:choose>
		<c:when test="${param.colour=='red'}">		<!-- colour là param ở trên url -->
			<p style="color: red;">This is red color!</p>
		</c:when>
		<c:when test="${param.colour=='blue'}">
			<p style="color: blue;">This is blue color!</p>
		</c:when>
		<c:when test="${param.colour=='cyan'}">
			<p style="color: cyan;">This is cyan color!</p>
		</c:when>
		<c:otherwise>
			<p><i>Other colors</i></p>
		</c:otherwise>
	</c:choose>
	
	<div style="color: <%=request.getParameter("colour") %>">This text display a lot of color you enter</div>
</body>
</html>
<!-- try this: http://localhost:8080/o7planning_JSTL/c_choose.jsp?colour=red -->