<div class="welcome">
	<span style="font-size: 15px;">Welcome <span style="color: blue; font-weight: bold;"><a href="personal-information">${loginedUser.name}</a></span> [<a href="logout">Logout</a>]<br/></span>
	<span style="font-size: 14px;">Today is ${today}, week ${currentWeek}, term ${currentTerm}</span>
</div>
<header class="head">
	<div style="float: left;">
		<a class="logo" href="home"><img height="79px" src="images/bkhn.png"/></a>
		<p class="pNextLogo">Student management system</p>
	</div>
	<div style="clear: both;"></div>
	<ul>
		<li><a href="home">Home page</a></li>
		<li style="width: 80px;"><a href="login">Login</a></li>
		<li style="width: 80px;"><a href="javascript:void(0)">Profile &nabla;</a>
			<ul class="sub-menu">
				<li><a href="personal-information">Personal Information</a></li>
				<li><a href="edit-information">Edit Information</a></li>
				<li><a href="change-password">Change password</a></li>
			</ul>
		</li>
		<li><a href="time-table">Timetable</a></li>
		<li><a href="subject-list">Subject List</a></li>
		<li><a href="javascript:void(0)">Scoreboard &nabla;</a>
			<ul class="sub-menu">
				<li><a href="personal-scoreboard">Personal Scoreboard</a></li>
				<li><a href="student-scoreboard">Student Scoreboard</a></li>	<!-- Tra cuu bang diem cua sinh vien khac -->
			</ul>
		</li>
		
		<li><a href="course-list">Course List</a></li>	<!-- Danh sach lop hoc -->
		<li><a href="javascript:void(0)">Teachers &nabla;</a>
			<ul class="sub-menu">
				<li class="sub-item-teacher"><a href="search-teacher">Search teacher</a></li>
				<li class="sub-item-teacher"><a href="search-teaching-schedule">Search teaching schedule</a></li>
			</ul>
		</li>
		<li><a style="width: 140px;" href="exam-schedule">Exam Schedule</a></li>	<!-- Tra cuu lich thi -->
		<li><a href="javascript:void(0)">Look up &nabla;</a>
			<ul class="sub-menu">
				<li class="sub-item-lookup"><a href="my-fee">My fee</a></li>
				<li class="sub-item-lookup"><a href="search-student">Search student</a></li>
				<li class="sub-item-lookup"><a href="search-class">Search class</a></li>
			</ul>
		</li>
	</ul>
</header>
