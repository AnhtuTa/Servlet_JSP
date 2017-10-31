<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Get context init param (local param) -->
	The song param in web.xml: <%=application.getInitParameter("song") %><br/><br/>
	
	<%pageContext.setAttribute("thisScope", "Page Context"); %>
	Scope of the attribute: <%=pageContext.getAttribute("thisScope") %><br/><br/>
	
	<!-- Tìm attribute: ban đầu nó sẽ tìm attribute trong phạm vi của file này (trong scope này),
		nếu ko thấy nó sẽ tìm ở request, sau đó đến session -> application
		Tóm lại thứ tự tìm Attribute của hàm này như sau:
		trong file này -> request -> session -> application
	-->
	Other attribute in another place that we found: <%=pageContext.findAttribute("otherScope") %><br/><br/>
	
	<!-- Lấy các attribute của request, session và application ở chỗ khác -->
	Session scope of attribute: <%=pageContext.getAttribute("otherScope", PageContext.SESSION_SCOPE) %><br/><br/>
	request scope of attribute: <%=pageContext.getAttribute("otherScope", PageContext.REQUEST_SCOPE) %><br/><br/>
	application scope of attribute: <%=pageContext.getAttribute("otherScope", PageContext.APPLICATION_SCOPE) %><br/><br/>
	
</body>
</html>