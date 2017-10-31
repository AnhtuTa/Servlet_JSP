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
		.table_edit_info {
			padding: 7px;
			border: 2px;
			cellpadding: 5px;
			background-color: #cecece;
			margin-bottom: 12px;
			border-radius: 10px;
		}
		.label_info {
			text-align: right;
			font-family: Arial;
			text-shadow: 1px 1px 2px #888888;
		}
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
				<h3>Change password</h3><br/>
				<div style="color: red;">${errorString}</div>
				<table class="table_edit_info">
					<tr>
						<th class="label_info">Mật khẩu cũ</th>
						<td><input type="password" name="txtOldPass"></td>
					</tr>
					<tr>
						<th class="label_info">Mật khẩu mới</th>
						<td><input type="password" name="txtNewPass"></td>
					</tr>
					<tr>
						<th class="label_info">Nhập lại mật khẩu</th>
						<td><input type="password" name="txtRetype"></td>
					</tr>
				</table>
				<input class="btnSubmit" type="submit" value="Change password">
				<a href="home">Cancel</a>
			</form>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>