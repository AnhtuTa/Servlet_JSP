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
	<c:forEach items="${departments}" var="depts">
		<c:forEach items="${depts.employees}" var="emp">
			<c:out value="${emp.empName}"></c:out> - <i>(<c:out value="${emp.job}"></c:out>)</i><br/>
		</c:forEach>
	</c:forEach>
</body>
</html>