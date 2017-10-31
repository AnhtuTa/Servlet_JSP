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
	<title>Add teacher</title>
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
		<%@ include file="_menu_staff.jsp" %>
		
		<div align="center" class="inner_wrapper">
			
			<form action="" method="post">
				<h3>Add new teacher</h3><br/>
				<table class="table_edit_info">
					<tr>
						<th class="label_info">Mã giảng viên</th>
						<td><input type="text" name="txtID"></td>
					</tr>
					<tr>
						<th class="label_info">Họ tên</th>
						<td><input type="text" name="txtName"></td>
					</tr>
					<tr>
						<th class="label_info">Mật khẩu</th>
						<td><input type="text" name="txtPass"></td>
					</tr>
					<tr>
						<th class="label_info">Ngày sinh</th>
						<td><input type="text" name="txtBirth"></td>
					</tr>
					<tr>
						<th class="label_info">Giới tính</th>
						<td><input type="text" name="txtSex"></td>
					</tr>
					<tr>
						<th class="label_info">Mã bộ môn</th>
						<td><input type="text" name="txtDepartment"></td>
					</tr>
					<tr>
						<th class="label_info">Địa chỉ làm việc</th>
						<td><input type="text" name="txtWorkplace"></td>
					</tr>
					<tr>
						<th class="label_info">Website</th>
						<td><input type="text" name="txtWebsite"></td>
					</tr>
					<tr>
						<th class="label_info">Email</th>
						<td><input type="text" name="txtEmail"></td>
					</tr>
					<tr>
						<th class="label_info">Điện thoại</th>
						<td><input type="text" name="txtPhone"></td>
					</tr>
					<tr>
						<th class="label_info">Ảnh 3x4</th>
						<td><input type="file" name="filePhoto"></td>
					</tr>
				</table>
				<input class="btnSubmit" type="submit" value="Add teacher">
				<a href="home">Cancel</a>
			</form>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>