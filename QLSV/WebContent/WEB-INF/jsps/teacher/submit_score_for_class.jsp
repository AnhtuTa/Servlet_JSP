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
	<title>Submit score for class</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		.txtScore {
			width: 130px;
			padding: 2px;
		}
	</style>
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_teacher.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<div style="color: #1a5fce; margin: 10px;">${infoString}</div>
			<p>Submit điểm cho lớp <%=request.getAttribute("courseID") %>. Tên lớp: ${subjectName}</p>	<!-- Có thể dùng ${courseID} giống ${stList} ở dưới -->
			<div style="color: red;">Chú ý: bạn không thể sửa điểm sau khi đã nộp, và chỉ có 1 lần nộp điểm duy nhất cho mỗi sinh viên!<br>Sau khi ấn "Submit", điểm của các sinh viên sẽ được lưu lên hệ thống</div><br>
			<form action="" method="post">
				<table border="1" class="table_timetable">
					<tr>
						<th>Mã SV</th>
						<th>Tên SV</th>
						<th>Lớp</th>
						<th>Điểm quá trình</th>
						<th>Điểm cuối kỳ</th>
					</tr>
					
					<%
						@SuppressWarnings("unchecked")
						List<Student> stList = (List<Student>) request.getAttribute("stList");
						for(Student st : stList) {
							float processScore = st.getProcessScore();
							%>
							<tr>
								<td><%=st.getId() %></td>
								<td><%=st.getName() %></td>
								<td><%=st.getSVClassName( )%></td>
								
							<%
							if(processScore >= 0) {
								%>
								<td align="center"><input class="txtScore" disabled="disabled" type="text" value="<%=st.getProcessScore() %>" name="<%=st.getId() %>_qt"></td>
								<td align="center"><input class="txtScore" disabled="disabled" type="text" value="<%=st.getFinalScore() %>" name="<%=st.getId() %>_ck"></td>
								<%
							} else {
								%>
								<td align="center"><input class="txtScore" type="text" name="<%=st.getId() %>_qt"></td>
								<td align="center"><input class="txtScore" type="text" name="<%=st.getId() %>_ck"></td>
								<%
							}
							%>
							</tr>
							<%
						}
					%>
				</table>
				<input class="btnSubmit" type="submit" value="Submit scores">
			</form>
			
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>