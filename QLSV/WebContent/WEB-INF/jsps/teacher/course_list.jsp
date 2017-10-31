<%@page import="beans.Course"%>
<%@page import="java.util.List"%>
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
	<style type="text/css">
		.cl_divSwitchPage {
			padding-top: 10px;
			padding-right: 10px;
			padding-bottom: 10px;
			overflow: hidden;
		}
		.cl_btnSwitchPage {
			float: left;
			background-color: #405580;
		    color: #fff;
		    font-weight: bold;
		    width: 120px;
		    border-radius: 4px;
			height: 30px;
			text-align: center;
		}
		.firstBtn {
			margin-left: 40%;
		}
	</style>
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_teacher.jsp" %>
		<div align="center" class="inner_wrapper">
			<h3>Danh sách lớp học học kỳ ${currentTerm}</h3>
			<div style="margin: 5px; color: red;">${errorString}</div>
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã lớp học</th>
					<th>Mã học phần</th>
					<th>Tên học phần</th>
					<th>Thứ</th>
					<th>Giờ học</th>
					<th>Phòng học</th>
					<th>Tuần học</th>
					<th>Loại lớp</th>
				</tr>
				
						<%
							@SuppressWarnings("unchecked")
							List<Course> courseList = (List<Course>) request.getAttribute("courseList");
						%>
				<c:forEach items="${courseList}" var="courseList">
					<tr>
						<td>${courseList.courseID}</td>
						<td>${courseList.subjectID}</td>
						<td>${courseList.subjectName}</td>
						<td>${courseList.dayOfWeek}</td>
						<td>${courseList.time}</td>
						<td>${courseList.room}</td>
						<td>${courseList.week}</td>
						<td>${courseList.courseType}</td>
					</tr>
				</c:forEach>
			</table>
			
			<div class="cl_divSwitchPage">
				<form class="cl_formSwitchPage; firstBtn" action="course-list" method="post">
					<input class="cl_btnSwitchPage" type="submit" value="previous" name="requestIndex">
				</form>
				
				<form class="cl_formSwitchPage" action="course-list" method="post">
					<input class="cl_btnSwitchPage" type="submit" value="next" name="requestIndex">
				</form>
			</div>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>