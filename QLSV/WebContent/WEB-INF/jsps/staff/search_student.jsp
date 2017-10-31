<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Search student</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_staff.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<form action="search-student" method="post">
				<table class="table_edit_info">
					<tr>
						<td>Enter student ID</td>
						<td><input class="inputStID" type="text" name="studentID"></td>
					</tr>
				</table>
				<input type="submit" class="btnSearch" value="Search">
			</form>
			
			<div style="margin: 5px; color: red;">${errorString}</div>
						
			<%
				if(request.getAttribute("st") != null) {
			%>
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã SV</th>
					<th>Tên SV</th>
				</tr>
				<tr>
					<td>${st.id}</td>
					<td><a href="student-information?studentID=${st.id}">${st.name}</a></td>
				</tr>
			</table>
			<%} %>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>