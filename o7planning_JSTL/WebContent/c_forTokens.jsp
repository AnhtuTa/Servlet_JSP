<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>c:forTokens  dùng để lặp trên chuỗi (tokens) được phân cách bởi một dấu nào đó, giống StringTokenizer trong Java.</h3>
	<ol>
		<c:forTokens items="Anhtu|Nguyen|Toan|Huy" delims="|" var="friends">
			<li><c:out value="${friends}" /></li>
		</c:forTokens>
	</ol>
</body>
</html>