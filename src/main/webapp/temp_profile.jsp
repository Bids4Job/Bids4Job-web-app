<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.SimpleUser" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bids4Job Log In Success</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Custom Style -->
<link rel="stylesheet" href="css/main.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<a href="index.jsp"> <img alt="Brand" src="images/logo.png">
				<!--Brand logo image-->
			</a>
		</div>
	</nav>

	<div class="container">
		<div class="page-header">
			<h1>Log In Succeeded!</h1>
		</div>


		<%
			SimpleUser simpleUser = (SimpleUser) session.getAttribute("simple-user");
			
			if (simpleUser != null) {
		%>
		<div class="alert alert-success" role="alert">
			<p class="strong">Simple User</p>
			<ol>
				<li><b>Username:</b> <%=simpleUser.getUsername()%></li>
				<li><b>First Name:</b> <%=simpleUser.getFirstName()%></li>
				<li><b>Surname:</b> <%=simpleUser.getLastName()%></li>
				<li><b>Email:</b> <%=simpleUser.getEmail()%></li>
				<li><b>Location:</b> <%=simpleUser.getLocation()%></li>
			</ol>
		</div>
		<%
			} else {
				request.setAttribute("errormessage", "No user profile loaded!");
		%>

		<jsp:forward page="errorprinter.jsp" />
		<%
			}
		%>

	</div>
	<!-- /container -->

	<p style="text-align: center;"><b><a href="/bids4job-web-app/logout_simple">Log out</a></b></p>

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>