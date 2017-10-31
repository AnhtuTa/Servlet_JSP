<%@page import="java.util.List"%>
<%@page import="beans.Student"%>
<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit information</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		tr td input {
			padding: 3px;
		}
	</style>
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_student.jsp" %>
		
		<div align="center" class="inner_wrapper">
			
			<form action="" method="post">
				<h3>Edit student's information</h3><br/>
				<table class="table_edit_info">
					<tr>
						<th class="label_info">Giới tính</th>
						<td><input type="text" value="${sessionScope.loginedUser.sex}" name="txtSex"></td>
					</tr>
					<tr>
						<th class="label_info">Địa chỉ</th>
						<td><input type="text" value="${sessionScope.loginedUser.address}" name="txtAddr"></td>
					</tr>
					<tr>
						<th class="label_info">Email</th>
						<td><input type="text" value="${sessionScope.loginedUser.email}" name="txtEmali"></td>
					</tr>
					<tr>
						<th class="label_info">Điện thoại</th>
						<td><input type="text" value="${sessionScope.loginedUser.phone}" name="txtPhone"></td>
					</tr>
				</table>
				<input class="btnSubmit" type="submit" value="Update information">
				<a href="home">Cancel</a>
			</form>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>