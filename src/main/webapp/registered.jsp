<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.SimpleUser"%>
<%@ page import="domain.ProfessionalUser"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bids4Job Sign Up Success</title>
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
			<h1>Sign Up Succeeded!</h1>
		</div>


		<%
			SimpleUser simpleUser = (SimpleUser) request.getAttribute("simpleUser");
			ProfessionalUser professionalUser = (ProfessionalUser) request.getAttribute("pro");

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
			} else if (professionalUser != null) {
		%>
		<div class="alert alert-success" role="alert">
			<p class="strong">Professional User</p>
			<ol>
				<li><b>Username:</b> <%=professionalUser.getUsername()%></li>
				<li><b>First Name:</b> <%=professionalUser.getFirstName()%></li>
				<li><b>Surname:</b> <%=professionalUser.getLastName()%></li>
				<li><b>Email:</b> <%=professionalUser.getEmail()%></li>
				<li><b>Location:</b> <%=professionalUser.getLocation()%></li>
				<li><b>Profession:</b> <%=professionalUser.getProfession()%></li>
			</ol>
		</div>
		<%
			} else {
				request.setAttribute("errormessage", "Bad request");
		%>

		<jsp:forward page="errorprinter.jsp" />
		<%
			}
		%>

	</div>
	<!-- /container -->


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