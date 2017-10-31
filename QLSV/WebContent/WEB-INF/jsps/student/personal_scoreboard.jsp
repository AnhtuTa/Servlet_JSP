<%@page import="java.util.List"%>
<%@page import="beans.Course"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My Scoreboard</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_student.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<form action="personal-scoreboard" method="post">
				Select a term 
				<select name="select-term" style="width: 80px;">
					
					<%
						@SuppressWarnings("unchecked")
						List<Integer> termList = (List<Integer>) request.getAttribute("availableTerm");
						String selectedTerm = (String) request.getAttribute("selectedTerm");
						int selectedTerm_int = 0;
						if(!selectedTerm.equals("all")) {
							selectedTerm_int = Integer.valueOf(selectedTerm);
							%>
								<option value="all">All terms</option>
							<%
						} else {
							%>
								<option selected="selected" value="all">All terms</option>
							<%
						}
						for(Integer term : termList) {
							if(term == selectedTerm_int) {
							%>
								<option selected="selected" value="<%=term %>"><%=term %></option>
							<%
							} else {
							%>
								<option value="<%=term %>"><%=term %></option>
							<%
							}
						}
					%>
				</select>
				<input type="submit" class="btnSearch" value="Search">
			</form>
			
			<table border="1" class="table_timetable">
				<tr>
					<th>Học kỳ</th>
					<th>Mã lớp học</th>
					<th>Mã HP</th>
					<th>Tên HP</th>
					<th>Số TC</th>
					<th>Điểm QT</th>
					<th>Điểm cuối kỳ</th>
					<th>Điểm tổng</th>
					<th>Điểm chữ</th>
				</tr>
				<c:forEach items="${scoreList}" var="scoreList">
					<tr>
						<td>${scoreList.term}</td>
						<td>${scoreList.courseID}</td>
						<td>${scoreList.subjectID}</td>
						<td>${scoreList.subjectName}</td>
						<td>${scoreList.credits}</td>
						<td>${scoreList.processScore}</td>
						<td>${scoreList.finalScore}</td>
						<td>${scoreList.overall}</td>
						<td>${scoreList.letterScore}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>