<%@page import="beans.Course"%>
<%@page import="java.util.List"%>
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
		.cl_divSwitchPage {
			padding-top: 10px;
			padding-right: 10px;
			padding-bottom: 10px;
			overflow: hidden;
		}
		.cl_btnSwitchPage {
			float: left;
			background-color: #405580;
		    color: #fff;
		    font-weight: bold;
		    width: 120px;
		    border-radius: 4px;
			height: 30px;
			text-align: center;
		}
		.firstBtn {
			margin-left: 40%;
		}
		.div_course {
			margin-left: 20%;
		}
		.table_course {
			border-collapse: collapse;
			width: 80%;
			min-width: 800px;
		}
		.div_coursename {
			background: #c1c1c1;
			width: 80%;
			min-width: 800px;
		}
		.th_dayOfWeek {
			width: 50px;
		}
		.th_time {
			width: 100px;
			text-align: left;
			padding-left: 7px;
		}
		.th_room {
			width: 100px;
			text-align: left;
			padding-left: 7px;
		}
		.th_week {
			width: 200px;
			text-align: left;
			padding-left: 7px;
		}
		.th_type {
			width: 100px;
			text-align: left;
			padding-left: 7px;
		}
		
	</style>
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_student.jsp" %>
		<div align="center" class="inner_wrapper">
			<h3>Danh sách lớp học học kỳ ${currentTerm}</h3>
			<div style="margin: 5px; color: red;">${errorString}</div>
				<div align="left" class="div_course">
				<%
					@SuppressWarnings("unchecked")
					List<Course> courseList = (List<Course>) request.getAttribute("courseList");
					for(int i = 0; i < courseList.size(); i++) {
						Course c, c2 = null;
						c = courseList.get(i);
						if(i < courseList.size() - 1) c2 = courseList.get(i+1);
						%>
					
						<div class="div_coursename" style="margin-top: 30px; font-size: 16px;">
							Mã lớp học: <b><%=c.getCourseID() %></b>
							<span style="padding-left: 20px; font-size: 16px;">Mã HP: <b><%=c.getSubjectID() %></b></span>
							<span style="padding-left: 20px; font-size: 16px;">Max ĐK: <b><%=c.getMaxNum() %></b></span>
							<span style="padding-left: 20px; font-size: 16px;">Đã ĐK: <b><%=c.getRegisteredNum() %></b></span>
						</div>
						<div class="div_coursename">Tên học phần: <b><%=c.getSubjectName() %></b></div>
						<div class="div_coursename">Ghi chú: <b><%=c.getNote() %></b></div>
						
						<table border="1" class="table_course">
							<tr>
								<th class="th_dayOfWeek">Thứ</th>
								<th class="th_time">Giờ học</th>
								<th class="th_room">Phòng học</th>
								<th class="th_week">Tuần học</th>
								<th class="th_type">Loại lớp</th>
							</tr>
							
							<tr>
								<td style="text-align: center;"><%=c.getDayOfWeek() %></td>
								<td><%=c.getTime() %></td>
								<td><%=c.getRoom() %></td>
								<td><%=c.getWeek() %></td>
								<td><%=c.getCourseType() %></td>
							</tr>
							
							<%
							if(c2 != null && c.getCourseID() == c2.getCourseID()) {
								i++;
							%>
							<tr>
								<td style="text-align: center;"><%=c2.getDayOfWeek() %></td>
								<td><%=c2.getTime() %></td>
								<td><%=c2.getRoom() %></td>
								<td><%=c2.getWeek() %></td>
								<td><%=c2.getCourseType() %></td>
							</tr>
							<%
							}
							%>
						</table>
						<%
					}
				%>
			</div>
			<div class="cl_divSwitchPage">
				<form class="cl_formSwitchPage; firstBtn" action="course-list" method="post">
					<input class="cl_btnSwitchPage" type="submit" value="previous" name="requestIndex">
				</form>
				
				<form class="cl_formSwitchPage" action="course-list" method="post">
					<input class="cl_btnSwitchPage" type="submit" value="next" name="requestIndex">
				</form>
			</div>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>