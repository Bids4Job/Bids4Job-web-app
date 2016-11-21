<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="refresh" content="3;url=index" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bids4Job Signed out</title>
<!-- Add favicon -->
<link rel="icon" href="favicon.ico">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Custom Style -->
<link href="css/main.css" rel="stylesheet">
<link href="css/stylesTest.css" rel="stylesheet">

<!-- Login Modal style -->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%-- <% session.invalidate();%> --%>

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



	<!-- Start Login Modal -->

	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div
				class="tabbable full-width-tabs col-lg-8 col-md-6 col-sm-6 col-xs-8 col-lg-offset-2 col-md-offset-3 col-sm-offset-3 col-xs-offset-2">
				<ul class="nav nav-tabs nav-justified login-tab-clr">
					<li class="active"><a data-toggle="tab" href="#Individual">Individual</a></li>
					<li><a data-toggle="tab" href="#Professional">Professional</a></li>
				</ul>

				<div class="tab-content">
					<div id="Individual" class="tab-pane fade in active">
						<form class="form-signin" method="POST" action="login_simple">
							<h2 class="form-signin-heading login-or-signup">Please Log
								in</h2>
							<label for="inputEmail" class="sr-only">Email address</label> <input
								type="email" id="inputEmail" class="form-control"
								placeholder="Email address" name="email" required autofocus>
							<label for="inputPassword" class="sr-only">Password</label> <input
								type="password" id="inputPassword" class="form-control"
								placeholder="Password" name="upass" required>
							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me">
									Remember me
								</label>
							</div>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Log
								in</button>
							<h5 class="login-or-signup">-OR-</h5>
							<a href="signup.jsp" class="btn btn-lg btn-primary btn-block"
								role="button">Sign up</a>
						</form>
					</div>
					<!-- End of #Individual -->
					<div id="Professional" class="tab-pane fade">
						<form class="form-signin" method="POST"
							action="login_professional">
							<h2 class="form-signin-heading login-or-signup">Please Log
								in</h2>
							<label for="inputEmail" class="sr-only">Email address</label> <input
								type="email" id="inputEmail" class="form-control"
								placeholder="Email address" required autofocus name="email">
							<label for="inputPassword" class="sr-only">Password</label> <input
								type="password" id="inputPassword" class="form-control"
								placeholder="Password" required name="password">
							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me">
									Remember me
								</label>
							</div>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Log
								in</button>
							<h5 class="login-or-signup">-OR-</h5>
							<a href="signup.jsp" class="btn btn-lg btn-primary btn-block"
								role="button">Sign up</a>
						</form>
					</div>
					<!-- End of #Professional -->
				</div>
				<!-- End of .tab-content -->
			</div>
		</div>
		<!-- End of .modal-dialog -->
	</div>
	<!-- End Login Modal -->

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 bigimage">
				<img class="img-responsive" src="images/logout.jpg">
			</div>
		</div>

	</div>
	<!-- End of .container-fluid -->


	<script>
		alert('You have signed out, thank you for visiting!')
	</script>




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
	<script src="js/bootstrap.js"></script>
</body>
</html>