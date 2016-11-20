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
			<a href="index"> <img alt="Brand" src="images/logo.png"> <!--Brand logo image-->
			</a>
		</div>
		<!-- end collapsed navbar-->
		<div id="navbar" class="navbar-collapse collapse">
			<!--start un-collapsed navbar-->
			<div class="navbar-form navbar-right">
				<a href="#" data-toggle="modal" data-target="#login-modal"
					class="btn btn-info" role="button">Log in</a> <a href="signup.jsp"
					class="btn btn-info" role="button">Sign up</a>
			</div>
		</div>
		<!-- end un-collapsed navbar-->
	</div>
</nav>
<!--Navbar end-->