<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${tc.name}</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		#caiNayDeCanGiua_ {
			margin-left: 30%;
			float: left;
		}
		td {
			font-family: Arial;
		}
	</style>
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_student.jsp" %>
		
		<div class="inner_wrapper">
			<div class="infor_div" id="caiNayDeCanGiua_">
				<table class="table_edit_info">
					<tr>
						<td class="label_info">Mã GV</td>
						<td>${tc.id}</td>
					</tr>
					<tr>
						<td class="label_info">Tên GV</td>
						<td>${tc.name}</td>
					</tr>
					<tr>
						<td class="label_info">Bộ môn</td>
						<td>${tc.department}</td>
					</tr>
					<tr>
						<td class="label_info">Khoa/viện</td>
						<td>${tc.faculty}</td>
					</tr>
					<tr>
						<td class="label_info">Địa chỉ nơi làm việc</td>
						<td>${tc.workplace}</td>
					</tr>
					<tr>
						<td class="label_info">Website</td>
						<td><a href="https://${tc.website}">${tc.website}</a></td>
					</tr>
					<tr>
						<td class="label_info">Email</td>
						<td>${tc.email}</td>
					</tr>
					<tr>
						<td class="label_info">Điện thoại LH</td>
						<td>${tc.phone}</td>
					</tr>
					<tr>
						<td class="label_info">Phân công giảng dạy</td>
						<td><a href="teaching-schedule?teacherID=${tc.id}">Xem lịch phân công giảng dạy<br/>của giảng viên này</a></td>
					</tr>
				</table>
			</div>
			<div class="photo_div">
				<img alt="anh dai dien" src="images/teachers/${tc.id}.jpg">
			</div>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>