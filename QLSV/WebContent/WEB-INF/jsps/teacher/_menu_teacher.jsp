<div class="welcome">
	<span style="font-size: 15px;">Welcome <span style="color: blue; font-weight: bold;">${loginedUser.name}</span> [<a href="logout">Logout</a>]<br/></span>
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
		<li style="width: 80px;"><a href="javascript:void(0)">Profile</a>
			<ul class="sub-menu">
				<li><a href="personal-information">Personal Information</a></li>
				<li><a href="edit-information">Edit Information</a></li>
				<li><a href="change-password">Change password</a></li>
			</ul>
		</li>
		<li><a style="width: 180px;" href="my-teaching-schedule">My Teaching schedule</a></li>
		<li><a href="submit-score">Submit score</a></li>
		<li><a href="subject-list">Subject List</a></li>
		<li><a href="course-list">Course List</a></li>	<!-- Danh sach lop hoc -->
	</ul>
</header>
