<%@page import="beans.Emp"%>
<%@page import="beans.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Khai báo sử dụng JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Demo 3</title>
</head>
<body>
	<h2>Departments and Employees</h2>
	<c:forEach items="${departments}" var="dept">
		
		<h3>${dept.deptName}</h3>
		<ul>
			<c:forEach items="${dept.employees}" var="emp">
				<li><b>${emp.empName}</b> - <i>(${emp.job})</i></li>
			</c:forEach>
			<c:if test="${empty dept.employees}">
				<div style="color: red;">There's nobody in this department</div>
			</c:if>
		</ul>
		
	</c:forEach>

</body>
</html>

<!-- c:if được sử dụng để kiểm tra một điều kiện nào đó là đúng hay sai. Chẳng hạn ví dụ trên
kiểm tra xem một tập hợp có phần tử hay không (Kiểm tra xem phòng ban hiện tại có nhân viên hay không).
Ví dụ này giống ví dụ 1 nhưng chỉ hiển thị các phòng ban có nhân viên. -->