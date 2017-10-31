<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Timetable</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_student.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<form action="time-table" method="post">
				Enter Student ID  <input class="inputStID" type="text" name="stID">
				<input type="submit" class="btnSearch" value="Search">
			</form>
			<div style="color: red; margin: 10px;">${errorString}</div>
			<div style="color: #1a5fce; margin: 10px;">${infoString}</div>
			
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã lớp học</th>
					<th>Mã học phần</th>
					<th>Thứ</th>
					<th>Giờ học</th>
					<th>Tên học phần</th>
					<th>Phòng học</th>
					<th>Loại lớp</th>
					<th>Tuần học</th>
				</tr>
				<c:forEach items="${courseSet}" var="course">
					<tr>
						<td>${course.courseID}</td>
						<td>${course.subjectID}</td>
						<td>${course.dayOfWeek}</td>
						<td>${course.time}</td>
						<td>${course.subjectName}</td>
						<td>${course.room}</td>
						<td>${course.courseType}</td>
						<td>${course.week}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>