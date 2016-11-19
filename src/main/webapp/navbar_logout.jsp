<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--Navbar start-->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid navbar-transp">
		<div class="navbar-header">
			<!--start collapsed navbar-->
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="index.jsp"> <img alt="Brand" src="images/logo.png">
				<!--Brand logo image-->
			</a>
		</div>
		<!-- end collapsed navbar-->
		<div id="navbar" class="navbar-collapse collapse">
			<!--start un-collapsed navbar-->

			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a
					href="
						<%-- Check in which profile page the user should go --%>
						<%if (isPro) {%>
							profile_professional
						<%} else if (isSimple) {%>
							profile_simple
						<%}%>">
						<span class="glyphicon glyphicon-user"></span>My Profile
				</a></li>
				<li><a href="logout_user"><span
						class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</ul>
		</div>
		<!-- end un-collapsed navbar-->
	</div>
</nav>
<!--Navbar end-->
