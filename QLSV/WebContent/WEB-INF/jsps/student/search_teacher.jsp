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
			<form action="" method="post">
				Enter teacher ID  <input class="inputStID" type="text" name="txtTeacherID">
				<span style="margin-left: 20px;">Or enter teacher's name:  <input class="inputStID" type="text" name="txtTeacherName"></span>
				<input type="submit" class="btnSearch" value="Search">
			</form>
			<div style="color: red; margin: 10px;">${errorString}</div>
			<div style="color: #1a5fce; margin: 10px;">${infoString}</div>
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã GV</th>
					<th>Tên GV</th>
				</tr>
				<c:forEach items="${tcList}" var="tc">
					<tr>
						<td>${tc.id}</td>
						<td><a href="teacher-information?teacherID=${tc.id}">${tc.name}</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>