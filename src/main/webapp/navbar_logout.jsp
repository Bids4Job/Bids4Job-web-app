<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.SimpleUser"%>
<%@ page import="domain.ProfessionalUser"%>

<%-- 
Use isPro and isSimple booleans (from index.jsp)
that indicate if a user is logged in as 
a Professional or a Simple User respectively 
--%>
<%
	// Get parameters from the request
	boolean isPro = Boolean.parseBoolean(request.getParameter("isPro"));
	boolean isSimple = Boolean.parseBoolean(request.getParameter("isSimple"));
	// Get attributes from session
	String username = isPro ? ((ProfessionalUser) session.getAttribute("pro")).getUsername()
			: ((SimpleUser) session.getAttribute("simple-user")).getUsername();
%>

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

			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a class="profile-image"
					href="
						<%-- Check in which profile page the user should go --%>
						<%if (isPro) {%>
							profile_professional
						<%} else if (isSimple) {%>
							profile_simple
						<%}%>">
						<img src=<%=request.getContextPath() + "/user_image"%>
						class="img-circle">&nbsp;<%=username%>
				</a></li>
				<li><a href="#" data-toggle="modal"
					data-target="#contracts-modal"><span
						class="glyphicon glyphicon-list-alt"></span>&nbsp;My Contracts</a></li>
				<li><a href="logout_user"><span
						class="glyphicon glyphicon-log-out"></span>&nbsp;Logout</a></li>
			</ul>
		</div>
		<!-- end un-collapsed navbar-->
	</div>
</nav>
<!--Navbar end-->
