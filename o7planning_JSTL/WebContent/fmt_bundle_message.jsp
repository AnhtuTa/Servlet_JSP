<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${not empty param.language}">	<!-- CHÚ Ý: param.language là tham số trên URL, VD: khi nhập URL thêm tham số: ?language=en -->
	<c:set value="${param.language}" scope="session" var="ngon_ngu" />
</c:if>
<fmt:setLocale value="${ngon_ngu}" />
<fmt:setBundle basename="org.o7planning.bundles.MyBundle" />

	<c:set value="false" var="isSubmitYet"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>fmt:bundle example</title>
	
	<script type="text/javascript">
		function myFunction() {
			alert("The form was submitted");
		}
	</script>
</head>
<body>
	 <h2>fmt:bundle example</h2>
     <form action="" onsubmit="myFunction()">
        <table border="0">
           <tr>
              <td>
                 <fmt:message key="login.label.userName"/>
              </td>
              <td>
                 <input type="text" name="userName" />
              </td>
           </tr>
           <tr>
              <td>
                 <fmt:message key="login.label.password" var="label_pass"/>		<!-- Có thể lưu trữ giá trị trong biến label_pass thay vì in kq ra màn hình -->
                 <c:out value="${label_pass}" />	<!-- Bây giờ in giá trị của biến label_pass ra màn hình -->
              </td>
              <td><input type="password" name="userPass" /></td>
           </tr>
        </table>
        <input type="submit"  value="Login now!" />
     </form>
     
    <%
     	String user = request.getParameter("userName");
    	String pass = request.getParameter("userPass");
    	String labelLogin;
    	if("anhtu".equals(user) && "1111".equals(pass)) {
  			labelLogin = "<h4 style=\"color: blue;\">Welcome Anhtu</h4>";
  		} else {
  			labelLogin = "<h4 style=\"color: red;\">Incorrect Username or Password!</h4>";
  		}
  		out.print(labelLogin);
    %>
     
     
     <c:if test="${not empty param.language}">
     	<br/><i>Tham số bạn nhập trên URL là: <b>language=<c:out value="${param.language}" /></b></i>
     </c:if>
</body>
</html>