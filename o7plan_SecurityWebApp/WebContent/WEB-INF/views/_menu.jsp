<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<a href="${pageContext.request.contextPath}/employeeTask">Employee Task</a>		<!-- employeeTask là đường dẫn tới servlet EmployeeTaskServlet -->
||
<a href="${pageContext.request.contextPath}/managerTask">Manager Task</a>		<!-- Thằng này cũng dẫn tới 1 servlet -->
||
<a href="${pageContext.request.contextPath}/userInfo">User Info</a>       
||
<a href="${pageContext.request.contextPath}/login">Login</a>
||
<a href="${pageContext.request.contextPath}/logout">Logout</a>
 
&nbsp;
<span style="color:red">[ ${loginedUser.userName} ]</span>
