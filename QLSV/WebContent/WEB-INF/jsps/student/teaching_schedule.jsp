<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Teaching schedule</title>
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
					<th>Mã lớp học</th>
					<th>Mã học phần</th>
					<th>Thứ</th>
					<th>Giờ học</th>
					<th>Tên học phần</th>
					<th>Phòng học</th>
					<th>Loại lớp</th>
					<th>Tuần học</th>
				</tr>
				<c:forEach items="${courseSet}" var="courseSet">
					<tr>
						<td>${courseSet.courseID}</td>
						<td>${courseSet.subjectID}</td>
						<td>${courseSet.dayOfWeek}</td>
						<td>${courseSet.time}</td>
						<td>${courseSet.subjectName}</td>
						<td>${courseSet.room}</td>
						<td>${courseSet.courseType}</td>
						<td>${courseSet.week}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>