<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="helloBean" class="jsp_action_useBean.HelloBean"></jsp:useBean>
	
	<h3>Say hello</h3>
	<jsp:getProperty property="sayHello" name="helloBean"/>		<!-- invoke method getSayHello() in helloBean -->
	
	<jsp:setProperty property="fullName" value="Son go ku" name="helloBean"/>
	<h3>Say hello after setName</h3>
	<jsp:getProperty property="sayHello" name="helloBean"/>
	
	<jsp:setProperty property="fullName" value="" name="helloBean"/>
	
	<h3>Say hello</h3>
	<jsp:getProperty property="myProfessionalUniversity" name="helloBean"/>		<!-- invoke method getMyProfessionalUniversity() in helloBean -->
	
	<!-- Set property fullName for helloBean -->
	<jsp:setProperty property="fullName" name="helloBean" value="Anhtu95"/>
	<h3>Say hello after setName</h3>
	<jsp:getProperty property="myProfessionalUniversity" name="helloBean"/>
</body>
</html>