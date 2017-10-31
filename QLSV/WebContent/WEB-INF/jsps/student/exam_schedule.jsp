<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My exam schedule</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_student.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<div style="color: #1a5fce; margin: 10px;">${infoString}</div>
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã lớp thi</th>
					<th>Mã lớp học</th>
					<th>Tên học phần</th>
					<th>Ngày thi</th>
					<th>Phòng thi</th>
					<th>Kíp thi</th>
				</tr>
				<c:forEach items="${examList}" var="examList">
					<tr>
						<td>${examList.examID}</td>
						<td>${examList.courseID}</td>
						<td>${examList.subjectName}</td>
						<td>${examList.day}</td>
						<td>${examList.room}</td>
						<td>${examList.kip}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>