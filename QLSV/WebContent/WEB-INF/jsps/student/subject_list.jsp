<%@page import="beans.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css" />
	<link href="timetable.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="wrapper">
		<%@ include file="_menu_student.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<h3>Danh sách học phần</h3>
			<div style="margin: 5px; color: red;">${errorString}</div>
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã học phần</th>
					<th>Tên học phần</th>
					<th>Số TC</th>
					<th>TC học phí</th>
					<th>Trọng số</th>
					<th>Khối lượng giảng dạy</th>
				</tr>
					<%
						@SuppressWarnings("unchecked")
						List<Subject> subjectList = (List<Subject>) request.getAttribute("subjectList");
					%>
				<c:forEach items="${subjectList}" var="subjectList">
					<tr>
						<td>${subjectList.id}</td>
						<td>${subjectList.name}</td>
						<td>${subjectList.credit}</td>
						<td>${subjectList.feeCredit}</td>
						<td>${subjectList.weight}</td>
						<td>${subjectList.teachingWeight}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>