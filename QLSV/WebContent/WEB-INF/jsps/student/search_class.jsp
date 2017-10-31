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
			<div style="color: blue;">Note: search by className hasn't support yet! This feature will be released in next version!</div>
			<div style="color: cyan; margin-bottom: 10px;">Try this one: 30458</div>
			<form action="search-class" method="post">
				<table class="table_edit_info">
					<tr>
						<td>Enter class ID</td>
						<td><input class="inputStID" type="text" name="classID"></td>
					</tr>
					<tr>
						<td>Or class name</td>
						<td><input class="inputStID" type="text" name="className"></td>
					</tr>
				</table>
				<input type="submit" class="btnSearch" value="Search">
			</form>
			
			<div style="margin: 5px; color: red;">${errorString}</div>
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã lớp</th>
					<th>Tên lớp</th>
				</tr>
				<c:forEach items="${clList}" var="cl">
					<tr>
						<td>${cl.id}</td>
						<td><a href="student-class?classID=${cl.id}">${cl.name}</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>