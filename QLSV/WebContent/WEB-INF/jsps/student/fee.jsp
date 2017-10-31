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
	<style type="text/css">
		.ul_fee {
			list-style: square;
			margin-left: 20px;
			margin-top: 20px;
		}
		.div_fee {
			background: #cbd0f2;
			color: #000;
			width: 400px;
			padding: 5px;
		}
	</style>
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_student.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<div align="left" class="div_fee">
				<div style="color: #1a5fce; margin: 10px;">${infoString}</div>
				
				<ul class="ul_fee">
					<li>Mã SV: ${fee.studentID}</li>
					<li>Số tín chỉ: ${fee.numOfCredit}</li>
					<li>Số tín chỉ đặc biệt: ${fee.extraNumOfCredit}</li>
					<li>Phụ phí: ${fee.extraFee}000</li>
					<li>Tổng học phý: <b>${fee.total}000</b></li>
					
				</ul>
			</div>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>