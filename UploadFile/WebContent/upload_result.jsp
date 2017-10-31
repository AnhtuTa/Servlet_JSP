<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Upload result</h2>
	<div>Thư mục chứa file vừa tải lên: ${dirUrl}</div>
	<div>File name: ${nameimg}</div>
	<div>Full image's path: ${dirUrl}&#92;${nameimg}</div>
	<div>Error (nếu có): 
	<%
		Exception ex = (Exception) request.getAttribute("ex");
		if(ex != null) ex.printStackTrace();
	%></div>
	
	<div>Ảnh vừa upload</div>
	<img alt="alt = ảnh_vừa_upload_lên" src="${dirUrl}&#92;${nameimg}">
</body>
</html>