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
			margin-left: 20%s;
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
		.photo_div {
			width: 30px;
			height: 40px;
			margin-left: 20px;
			float: left;
		}
		#caiNayDeCanGiua {
			margin-left: 20%;
		}
	</style>
</head>
<body>
	<div class="wrapper">
		<%@ include file="_menu_teacher.jsp" %>
		
		<div class="inner_wrapper" id="caiNayDeCanGiua">
			<div class="infor_div">
				<h3 class="infor_head">Teacher's information</h3>
				<div class="infor_body">
					<div>Mã giảng viên: ${loginedUser.id}</div>
					<div>Họ tên: ${loginedUser.name}</div>
					<div>Ngày sinh: ${loginedUser.birthday}</div>
					<div>Giới tính: ${loginedUser.sex}</div>
					<div>Email: ${loginedUser.email}</div>
					<div>Số đt: ${loginedUser.phone}</div>
					<div>Bộ môn: ${loginedUser.department}</div>
					<div>Khoa: ${loginedUser.faculty}</div>
					<div>Địa chỉ nơi làm việc: ${loginedUser.workplace}</div>
					<div>Website: ${loginedUser.website}</div>
				</div>
			</div>
			<div class="photo_div">
				<img width="200px" alt="Ảnh 3x4" src="images/teachers/${loginedUser.id}.jpg">
			</div>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>