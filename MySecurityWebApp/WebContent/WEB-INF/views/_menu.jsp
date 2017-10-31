<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<a href="${pageContext.request.contextPath}/">Home page</a>
||
<a href="${pageContext.request.contextPath}/employeeTask">Employee Task</a>
||
<a href="${pageContext.request.contextPath}/managerTask">Manager Task</a>
||
<a href="${pageContext.request.contextPath}/userInfo">User Info</a>       
||
<a href="${pageContext.request.contextPath}/login">Login</a>
||
<a href="${pageContext.request.contextPath}/logout">Logout</a>
 
&nbsp;
<span style="color:red">[ ${loginedUser.username} ]</span>	<!-- Gọi tới hàm getUsername() của UserAccount.java -->
