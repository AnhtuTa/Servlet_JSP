<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>c:remove Loại bỏ biến ra khỏi phạm vi đã cho.</h3>
	<c:set scope="request" var="greeting" value="Hello everybody! Are you guys stupid?"/>
	Greeting: <c:out value="${greeting}" /><br/>
	
	<c:remove scope="request" var="greeting"/>
	Greeting: <c:out value="${greeting}" /><br/>
</body>
</html>