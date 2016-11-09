<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Error Printer</title>

<!-- Bootstrap -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- Custom themes -->
<link rel="stylesheet" href="css/error_page.css">
<link rel="stylesheet" href="css/nav_bar.css">
<link rel="stylesheet" href="css/footer.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body>
	<!-- Navigation Bar - fixed to top -->
	<%@include file="nav_bar.jsp"%>

	<!-- container -->
	<div class="container-fluid theme-showcase" id="wrapper" role="main">

		<!-- header -->
		<div id="header">
			<div class="jumbotron">
				<h1>Error Page</h1>
			</div>
			<div class="page-header">
				<h2>An error occurred</h2>
			</div>
		</div>

		<!-- main-content -->
		<div id="main-content">
			<%
				if (request.getAttribute("errorMessage") != null) {
			%>
			<div class="alert alert-danger" role="alert"><%=request.getAttribute("errorMessage").toString()%></div>
			<%
				} else {
			%>
			<div class="alert alert-danger" role="alert"><%="Please try again"%></div>
			<%
				}
			%>
		</div>

		<!-- footer -->
		<div id="footer">
			<%@include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>

