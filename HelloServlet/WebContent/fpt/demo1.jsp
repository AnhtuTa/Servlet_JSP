<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="fpt.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP page</title>
</head>
<body>
	Hello world!<br/>
	Current time is <%= new java.util.Date() %><br/>	<!-- Đây là 1 Expression -->
	<!-- Giống như lệnh out.print() ở dưới -->
	
	<!-- Scriptlets -->
	<%
		out.print("Current time is " + new java.util.Date());
	%>
	
	<!-- Declaration -->
	<%!
		//ví dụ 1 method của class
		private void sayHello() {
			System.out.println("Hello Servlet and JSP");	//in ra console
		}
		
		//ví dụ số biến instance của class
		String name = "Anhtu";
		int age;

		public void setName(String n) {
			this.name = n;
		}
		
		public void setAge(int a) {
			this.age = a;
		}
		
		public String getInfo() {
			return this.name + " - " +this.age;
		}
	%>
	
	<!-- Demo form -->
	<form name="frm" method="post">
		<input type="text" name="amount"><br/>
		<input type="submit" name="btn" value="Generate">
	</form>
	<%
		String s = request.getParameter("amount");
		try {
			if(s != null && !s.equals("")) {
				int n = Integer.valueOf(s);
				for(int i = 0; i<n; i++) {
					out.println(i);
				}
			} else {
				out.println("Please enter a number!");
			}
		} catch(java.lang.NumberFormatException e) {
			out.println("<div style=\"color: red;\"><b>wrong number, idiot!</b></div>");
		}
		out.println("<br/>");
		sayHello();
		out.println("<br/>name = "+name);
		setName("Trung Nguyen");
		setAge(29);
		out.println("<br/>now name = "+name);
		out.print("<br/>Student's info: " + getInfo());
	%>
	
	<!-- other examples --><br/>
	<%
		ArrayList<String> nameList = new ArrayList<>();
		nameList.add("anhtu");
		nameList.add("nguyen");
		nameList.add("trung anh");
		nameList.add("phanh lee");
		nameList.add("giang");
		
		for(String name : nameList) {
			out.print("<br/>" + name);
		}

		Map<String, Student> stMap = new HashMap<String, Student>();
		
		ArrayList<Student> stList = new ArrayList<>();
		stList.add(new Student("3219", "att", 23));
		stList.add(new Student("elwa", "nguyen", 22));
		stList.add(new Student("fega", "trung anh", 11));
		stList.add(new Student("212a", "Phuong Anh le", 24));
		stList.add(new Student("eagea", "Nam", 43));
		stList.add(new Student("rr33", "Van anh", 20));
		
		for(Student st : stList) {
			stMap.put(st.getId(), st);
		}
		
		for(String key : stMap.keySet()) {
			out.print("<br/>" + stMap.get(key).getInfo());
		}
	%>
</body>
</html>