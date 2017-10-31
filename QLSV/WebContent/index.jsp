<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%	
		out.print("index.jsp");
		//request.getServletContext().getRequestDispatcher("/home").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/home");	//người dùng sẽ ko biết rằng hệ thống gọi file này, vì trên thanh URL chỉ hiển thị /QLSV/home, chứ ko hiển thị /QLSV/index.jsp
		//Nếu dùng request.getRequestDispatcher() thì thanh URL sẽ hiển thị là /QLSV/index.jsp
	%>
</body>
</html>