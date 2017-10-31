<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Submit score</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		.btnSelectClass {
			background-color: #50699b;
		    color: #fff;
		    font-weight: bold;
		    width: 120px;
		    border-radius: 4px;
			height: 30px;
			text-align: center;
			padding: 10px, 10px, 15px, 10px;
			margin-bottom: 10px
		}
	</style>
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_teacher.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<div style="color: #1a5fce; margin: 10px;">${infoString}</div>
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã lớp học</th>
					<th>Mã học phần</th>
					<th>Tên học phần</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${courseList}" var="courseList">
					<tr>
						<td>${courseList.courseID}</td>
						<td>${courseList.subjectID}</td>
						<td>${courseList.subjectName}</td>
						<td>
							<form action="submit-score-for-class">
								<input style="display: none;" type="text" name="courseID" value="${courseList.courseID}">
								<input style="display: none;" type="text" name="subjectName" value="${courseList.subjectName}">
								
								<input class="btnSelectClass" type="submit" value="Submit">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>