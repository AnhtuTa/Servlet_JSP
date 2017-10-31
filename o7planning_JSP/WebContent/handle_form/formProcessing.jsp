<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:declaration>
		String myName = "Taanhtu95";
		public String getMySchool() {
			return "Hanoi University of Science and Technology";
		}
	</jsp:declaration>
	<h3><i>Chú ý: Đây là một ví dụ mang tính minh họa, trong thực tế bạn nên xử lý Form bởi một Servlet thay vì JSP.  Nên coi JSP đơn thuần chỉ cách để hiển thị nội dung.</i></h3>
	<%
		String user = request.getParameter("userName");
		String pass = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
	
		String []addresses = request.getParameterValues("address");
	%>
	
	Username: <%=user %><br/>
	Password: <%=pass %><br/>
	First Name: <%=firstName %><br/>
	Last Name: <%=lastName %><br/>
	Gender: <%=gender %> <br>
	
	<%
		if(addresses != null) {
			for(String addr : addresses) {
				%>
				Address: <%=addr %><br/>
				<%
			}
		}
	%>
	
	<br/><h3>the below infor is just some example</h3>
	<%=new Date() %><br/>
	<jsp:expression>
		new Date()
	</jsp:expression><br/>
	My name: <%=myName %><br/>
	My school: <%=getMySchool() %><br/>
</body>
</html>