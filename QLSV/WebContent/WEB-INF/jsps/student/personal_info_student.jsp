<%@page import="database.DatabaseUtils"%>
<%@page import="servlet_home.HomeServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Profile</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css" />
	<link href="timetable.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		.infor_div {
			width: 600px;
			background: #cbd0f2;
			margin-left: 20%;
			float: left;
		}
		.infor_head {
			background: #1a5fce;
			color: #fff;
			margin-bottom: 10px;
			padding: 5px;
		}
		.infor_body {
			margin-left: 20px;
			color: #000;
			margin-bottom: 20px;
		}
	</style>
</head>
<body>
	<div class="wrapper">
		<%@ include file="_menu_student.jsp" %>
		
		<div class="inner_wrapper">
			<h4 style="color: #00ee11;" id="caiNayDeCanGiua">${result_update_info}</h4><br/>
			<div align="left" class="infor_div" id="caiNayDeCanGiua">
				<h3 class="infor_head">Public information</h3>
				<div class="infor_body">
					<div>Mã số SV: ${loginedUser.id}</div>
					<div>Họ tên: ${loginedUser.name}</div>
					<div>Ngày sinh: ${loginedUser.birthday}</div>
					<div>Lớp: ${loginedUser.SVClassName}</div>
					<div>Chương trình đào tạo: ${loginedUser.educationProgram}</div>
					<div>Trạng thái: ${loginedUser.status}</div>
					<div>Giới tính: ${loginedUser.sex}</div>
					<div>Email: ${loginedUser.email}</div>
				</div>
				
				<h3 class="infor_head">Private information</h3>
				<div class="infor_body">
					<div>Địa chỉ: ${loginedUser.address}</div>
					<div>Số đt: ${loginedUser.phone}</div>
				</div>
			</div>
			<div class="photo_div">
				<img alt="Ảnh 3x4" width="200px;" src="images/students/${loginedUser.id}.jpg">  <!-- ko dung: src = ${pageContext.request.contextPath}/student-photo?studentID=${loginedUser.id} -->
			</div>
			<div style="clear: both;"></div>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>