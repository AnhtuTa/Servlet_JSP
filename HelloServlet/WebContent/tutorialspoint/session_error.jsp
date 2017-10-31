<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page for SessionTrack</title>
</head>
<body>
	<h2 style="color: red; font-family: Consolas;">Error!</h2>
	<h3>This error occured because you run these files in this order: DeleteSessions ==> ReadSession.java ==> SessionTrack.java</h3>
	<p>
	   Hãy mở file SessionTrack.java để xem. Điều này khiến session.isNew() luôn = false vì khi chạy file ReadSession.java,
	   session sẽ đc khởi tạo ngay lúc đó và do đó điều kiện if trong file SessionTrack.java luôn sai
	   do đó ko bao h thực hiện đc 2 lệnh: <br/>
	   <div style="font-family: Consolas;">session.setAttribute(userIDKey, userID);</div>
	   <div style="font-family: Consolas;">session.setAttribute(visitCountKey, 0);</div>
	   <br/>Dẫn tới việc dùng lệnh sau sẽ lỗi: session.getAttribute(visitCountKey);		==> <i>NullPointerException</i>
	</p>
	Click vào <a href="../DeleteSessions">đây</a> để xóa session sau đó run lại file SessionTrack.java!
</body>
</html>