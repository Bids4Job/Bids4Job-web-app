<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.ProfessionalUser"%>
<%@ page import="domain.SimpleUser"%>
<%@ page isErrorPage="true"%>

<%
	// Use a boolean to know if a ProfessionalUser or a SimpleUser is logged in
	boolean isSimple = ((SimpleUser) session.getAttribute("simple-user")) != null;
	boolean isPro = ((ProfessionalUser) session.getAttribute("pro-user")) != null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bids4Job Error Page</title>
<!-- Add favicon -->
<link rel="icon" href="favicon.ico">
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


	<!--Navbar start-->

	<%-- Place the appropriate navigation bar --%>
	<%
		if (!isPro && !isSimple) {
	%>
	<%@ include file="navbar_login.jsp"%>
	<%
		} else {
	%>
	<jsp:include page="navbar_logout.jsp">
		<jsp:param name="isPro" value="<%=isPro%>" />
		<jsp:param name="isSimple" value="<%=isSimple%>" />
	</jsp:include>
	<%
		}
	%>
	<!--Navbar end-->





	<div class="container">

		<div class="page-header">
			<h1>Error</h1>
		</div>


		<div class="alert alert-danger" role="alert"><%=exception.getMessage()%></div>


		<!-- Start Footer -->
		<%@ include file="footer.jsp"%>
		<!-- End of Footer -->

	</div>
	<!-- End of .container -->

	<!--Start Login Modal -->
	<%@ include file="login_modal.jsp"%>
	<!--End Login Modal -->


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script>
		window.jQuery
				|| document
						.write('<script src="js/vendor/jquery.min.js"><\/script>')
	</script>
	<!-- Just to make placeholder images work-->
	<script src="js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>