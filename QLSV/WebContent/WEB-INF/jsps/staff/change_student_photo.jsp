<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Change student's photo</title>
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
			
			<form action="${pageContext.request.contextPath}/change-student-photo" method="post" enctype="multipart/form-data">
				<h3>Change ${txtID}'s photo</h3><br>
				<table class="table_edit_info">
					<tr>
						<th class="label_info">Mã số sinh viên</th>
						<td><input type="text" name="txtID" value="${txtID}"></td>
					</tr>
					<tr>
						<th class="label_info">Chọn ảnh mới</th>
						<td><input type="file" name="filePhoto"></td>
					</tr>
				</table>
				
				<input type="submit" value="Upload" />
			</form>
			
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>