<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>SimpleUser Services</title>

<!-- Bootstrap -->
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
<!-- Custom themes -->
<link rel="stylesheet" href="css/simple_user_main.css">
<link rel="stylesheet" href="css/nav_bar.css">
<link rel="stylesheet" href="css/footer.css">
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body>
	<section id="top"></section>

	<!-- Navigation Bar - fixed to top -->
	<%@include file="nav_bar.jsp"%>

	<!-- Jumbotron -->
	<div class="jumbotron">
		<div class="container">
			<div class="page-header col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<h1 id="main-header">
					SimpleUser <small>services</small>
				</h1>
				<p>An administration panel for <mark>creating</mark>, <mark>updating</mark>, <mark>deleting</mark> and
					<mark>finding</mark> Simple Users in Bids4Job web platform.</p>
			</div>
			<div class="row page-header-details">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 align-left">
					<p>
						<!-- <a class="btn btn-info btn-lg" href="simple_user_index.html"
							role="button">Refresh Image <span
							class="glyphicon glyphicon-refresh"></span></a> -->
						<a class="btn btn-success btn-lg" href="#create" role="button">Getting
							Started <span class="glyphicon glyphicon-console"></span>
						</a>
					</p>
				</div>
			</div>
		</div>
	</div>


	<!-- Create -->
	<section id="create" class="well well-lg well-dark">
		<div class="container">
			<div
				class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
				<h2>Create</h2>
				<form action="CreateSimpleUser" method="POST">
					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
							class="form-control" id="name" name="firstName" required>
					</div>
					<div class="form-group">
						<label for="surname">Surname:</label> <input type="text"
							class="form-control" id="surname" name="lastName" required>
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" name="email">
					</div>
					<div class="form-group">
						<label for="username">Username:</label> <input type="text"
							class="form-control" id="username" name="username">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>
					<div class="form-group">
						<label for="location">Location:</label> <input type="text"
							class="form-control" id="location" name="location" required>
					</div>
					<div class="form-button">
						<button type="submit" class="btn btn-lg btn-success"
							value="create">
							Create&nbsp;&nbsp;<span class="glyphicon glyphicon-plus-sign"></span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- Update -->
	<section id="update" class="well well-lg well-light">
		<div class="container">
			<div
				class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
				<h2>Update</h2>
				<form class="form-horizontal" action="UpdateSimpleUser"
					method="POST">
					<div class="form-group has-success">
						<label class="control-label col-sm-2" for="simple_user_id">ID:</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="simple_user_id"
								placeholder="Enter existing ID" name="simpleUserID" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">Name:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name"
								placeholder="Enter new Name" name="firstName">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="surname">Surname:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="surname"
								placeholder="Enter new Surname" name="lastName">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Email:</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email"
								placeholder="Enter new email" name="email">
						</div>
					</div>
					<div class="form-group has-warning">
						<label class="control-label col-sm-2" for="email">Username:</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email"
								placeholder="username cannot change" disabled>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="password">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								placeholder="Enter new password" name="password">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="location">Location:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="location"
								placeholder="Enter new Location" name="location">
						</div>
					</div>
					<div class="form-group">
						<div class="form-button">
							<button type="submit" class="btn btn-lg btn-warning"
								value="update">
								Update&nbsp;&nbsp;<span class="glyphicon glyphicon-wrench"></span>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- Delete -->
	<section id="delete" class="well well-lg well-dark">
		<div class="container">
			<div
				class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
				<h2>Delete</h2>
				<form method="POST" action="DeleteSimpleUser">
					<div class="form-group has-danger">
						<label for="simple_user_id">ID:</label> <input type="number"
							class="form-control" id="simple_user_id" name="simpleUserID"
							required>
					</div>
					<div class="form-group has-danger">
						<label for="username">Username:</label> <input type="text"
							class="form-control" id="username" name="username">
					</div>
					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
							class="form-control" id="name" name="firstName">
					</div>
					<div class="form-group">
						<label for="surname">Surname:</label> <input type="text"
							class="form-control" id="surname" name="lastName">
					</div>
					<div class="form-button">
						<button type="submit" class="btn btn-lg btn-danger" value="delete">
							Delete&nbsp;&nbsp;<span class="glyphicon glyphicon-minus-sign"></span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- Find One -->
	<section id="findOne" class="well well-lg well-light">
		<div class="container">
			<div
				class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
				<h2>Find One</h2>
				<form method="GET" action="FindOneSimpleUser">
					<div class="form-group has-sucess">
						<label for="simple_user_id">ID:</label> <input type="number"
							class="form-control" id="simple_user_id" name="simpleUserID"
							required>
					</div>
					<div class="form-button">
						<button type="submit" class="btn btn-lg btn-info" value="findOne">
							Find One&nbsp;&nbsp;<span class="glyphicon glyphicon-screenshot"></span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- Find All -->
	<section id="findAll" class="well well-lg well-dark">
		<div class="container">
			<div
				class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
				<h2>Find All</h2>
				<form action="FindAllSimpleUsers" method="GET">
					<div class="form-group has-success">
						<label for="disabledInput">All IDs:</label> <input type="number"
							class="form-control" id="disabledInput" data-toggle="tooltip"
							title="Just click the Find All button!" disabled>
					</div>
					<div class="form-button">
						<button type="submit" class="btn btn-lg btn-info" value="findAll">
							Find All&nbsp;&nbsp;<span class="glyphicon glyphicon-list-alt"></span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- Find Simple User by Location -->
	<section id="findByLocation" class="well well-lg well-light">
		<div class="container">
			<div
				class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
				<h2>Find by Location</h2>
				<form method="GET" action="FindSimpleUsersByLocation">
					<div class="form-group">
						<label for="location">Location:</label> <input type="text"
							class="form-control" id="location" name="location" required>
					</div>
					<div class="form-button">
						<button type="submit" class="btn btn-lg btn-info"
							value="findByLocation">
							Find By Location&nbsp;&nbsp;<span
								class="glyphicon glyphicon-map-marker"></span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- Find with unsigned Task -->
	<section id="findWithUnsignedTask" class="well well-lg well-dark">
		<div class="container">
			<div
				class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
				<h2>Find with Unsigned Task</h2>
				<form method="GET" action="FindWithUnsignedTask">
					<div class="form-button">
						<button type="submit" class="btn btn-lg btn-info"
							value="findWithUnsignedTask">
							Find With Unsigned Task&nbsp;&nbsp;<span
								class="glyphicon glyphicon-filter"></span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- footer -->
	<%@include file="footer.jsp"%>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script src="js/smooth_transition.js"></script>
</body>

</html>