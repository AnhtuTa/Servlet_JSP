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
		<li><a style="width: 160px;" href="change-password">Change password</a></li>
		<li style="width: 200px;"><a href="javascript:void(0)">Student management &nabla;</a>
			<ul class="sub-menu">
				<li><a href="search-student">Search student</a></li>
				<li><a href="add-student">Add student</a></li>
				<li><a href="change-student-photo">Change photo</a></li>
				<li><a href="change-student-password">Change password</a></li>
			</ul>
		</li>
		
		<li style="width: 200px;"><a href="javascript:void(0)">Teacher management &nabla;</a>
			<ul class="sub-menu">
				<li><a href="add-teacher">Add teacher</a></li>
				<li><a href="change-teacher-photo">Change photo</a></li>
				<li><a href="change-teacher-password">Change password</a></li>
			</ul>
		</li>
		
		
		<li><a href="add-subject">Add subject</a></li>
		
		<li><a href="subject-list">Subject List</a></li>
		<li><a href="course-list">Course List</a></li>	<!-- Danh sach lop hoc -->
	</ul>
</header>
