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
	<title>Add student</title>
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
				<h3>Add new Student</h3><br/>
				<table class="table_edit_info">
					<tr>
						<th class="label_info">Mã số sinh viên</th>
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
						<th class="label_info">Chương trình đào tạo</th>
						<td><input type="text" name="txtProgram"></td>
					</tr>
					<tr>
						<th class="label_info">Hệ học</th>
						<td><input type="text" name="txtHeHoc"></td>
					</tr>
					<tr>
						<th class="label_info">Trạng thái</th>
						<td><input type="text" name="txtStatus"></td>
					</tr>
					<tr>
						<th class="label_info">Giới tính</th>
						<td><input type="text" name="txtSex"></td>
					</tr>
					<tr>
						<th class="label_info">Địa chỉ</th>
						<td><input type="text" name="txtAddress"></td>
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
						<th class="label_info">Mã lớp SV</th>
						<td><input type="text" name="txtClassID"></td>
					</tr>
					<tr>
						<th class="label_info">Ảnh 3x4</th>
						<td><input type="file" name="filePhoto"></td>
					</tr>
				</table>
				<input class="btnSubmit" type="submit" value="Add student">
				<a href="home">Cancel</a>
			</form>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>