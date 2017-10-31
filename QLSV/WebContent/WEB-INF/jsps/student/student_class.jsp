<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Danh sách sinh viên</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_student.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<div>Danh sách sinh viên lớp ${classID}</div><br>
			<table border="1" class="table_timetable">
				<tr>
					<th>Mã SV</th>
					<th>Tên SV</th>
				</tr>
				<c:forEach items="${stList}" var="st">
					<tr>
						<td>${st.id}</td>
						<td><a href="student-information?studentID=${st.id}">${st.name}</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>