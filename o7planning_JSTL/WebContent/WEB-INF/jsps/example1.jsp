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
<title>JSTL Demo 1</title>
</head>
<body>
	<h2>Departments and Employees</h2>
<!--
	<c:forEach items="${requestScope.departments}" var="dept">
		${dept.deptName}
	</c:forEach>
-->
	<!-- Hoặc (Bạn có thể không cần requestScope)  -->
	<c:forEach items="${departments}" var="dept">
		<h3>${dept.deptName}</h3>
		<ul>
			<!-- Dùng for để duyệt trên các nhân viên thuộc phòng ban hiện tại (chính là các nhân viên trong biến dept) -->
			<c:forEach items="${dept.employees}" var="emp">
				<li><b>${emp.empName}</b> - <i>(${emp.job})</i></li>
			</c:forEach>
		</ul>
	</c:forEach>
	
	<h3>Nếu ko dùng c:forEach</h3>
	<%
		List<Dept> deptList = (List<Dept>) request.getAttribute("departments");
		for(Dept d : deptList) {
			%>
			<h3><%=d.getDeptName() %></h3>
			<ol>
				<%
					for(Emp e : d.getEmployees()) {
						%>
						<li><%=e.getEmpName() %> - (<%=e.getJob() %>)</li>
						<%
					}
				%>
			</ol>
			<%
		}
	%>
	<!-- Rõ ràng dùng forEach dễ nhìn hơn và dễ code hơn! -->

</body>
</html>