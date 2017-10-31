<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>		<!-- Nếu = true thì trang này ko sử dụng đc EL -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP EL</title>
</head>
<body>
	<h2>JSP EL examples (EL = Expression Language)</h2>
	
	<%pageContext.setAttribute("thisScope", "Page Context"); %>
	Scope of the attribute: <%=pageContext.getAttribute("thisScope") %><br/><br/>
	Scope of the attribute by EL: ${pageScope.thisScope} <br/><br/>
	
	Session scope of attribute by EL: ${sessionScope.otherScope }<br/><br/>
	request scope of attribute by EL: ${requestScope.otherScope }<br/><br/>
	application scope of attribute by EL: ${applicationScope.otherScope }<br/><br/>
	Student name is: ${requestScope.stAce.getName()}<br/><br/>
	Student name is: ${requestScope.stAce.name}<br/><br/>
	Init param song: <%=application.getInitParameter("song") %><br/><br/>
	Init param song by EL: ${initParam.song}<br/><br/>
	
	Languages: ${requestScope.languages}<br/><br/>
	2nd Languages: ${requestScope.languages[1]}<br/><br/>
	
	4 + 5 = ${4+5} <br/><br/>
	
	<jsp:useBean id="stAce" class="objects.Student" scope="request" />
	Get property name (useBean): <jsp:getProperty property="name" name="stAce"/><br/><br/>
	<jsp:setProperty property="name" name="stAce" value="WhiteBeard"/>
	Get property name after setProperty (useBean): <jsp:getProperty property="name" name="stAce"/><br/><br/>
	
	<!-- nếu request ko setAttribute nào mà có key = stLuffy -->
	<jsp:useBean id="stLuffy" type="objects.Person" class="objects.Student" scope="request"></jsp:useBean>	<!-- Tự động tạo ra 1 Bean mới stLuffy -->
	<jsp:setProperty property="name" name="stLuffy" value="Luffy"/>
	Get property name (useBean): <jsp:getProperty property="name" name="stLuffy"/><br/><br/>
	
</body>
</html>