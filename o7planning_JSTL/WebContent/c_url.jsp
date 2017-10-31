<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<style type="text/css">
		a {
			color: blue;
			text-decoration: none;
		}
		a:hover {
			color: green;
			font-size: 30px;
		}
	</style>
</head>
<body>
	<h2>c:url,c:param example</h2>
	
	<h4>c:url  Để tạo một URL với các tham số tùy chọn (optional query string parameters).</h4>
	<h4>c:param  Được sử dụng với c:url để truyền các tham số</h4>
	
	<c:url value="http://example.com/showPage.jsp" var="myURL">
	  <c:param name="color" value="red"/>
	  <c:param name="background" value="blue"/>	<!-- Truyền 2 tham số vào url -->
	</c:url>
	 
	<div>Ket qua cua c:url va c:param da viet o tren: <c:out value="${myURL}"/></div>
	
	<c:url value="https://www.google.com.vn/search" var="searchgg">
		<c:param name="q" value="Servlet la gi"></c:param>
	</c:url>
	<c:url value="https://www.google.com.vn/search" var="searchgg2">
		<c:param name="q" value="JSP la gi"></c:param>
	</c:url><br/>
	
	<div>More infor abour servelt: <a href="<c:out value="${searchgg}" />">Servlet la gi</a></div>
	<div>More infor abour JSP: <a href="<c:out value="${searchgg2}" />">JSP la gi</a></div>
	<div>Visit my page: <a href="facebook.com/taanhtu95">Tu xoc xu</a></div>
	
</body>
</html>