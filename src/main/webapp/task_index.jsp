<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Tasks</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/index.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>

	<div class="container">

		<!-- The justified navigation menu is meant for single line per list item.
    Multiple lines will require custom code not provided by Bootstrap. -->
		<div class="masthead">
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="list">Show All Tasks</a></li>
					<li><a href="task_find_one.jsp">Find Specific Task</a></li>
					<li><a href="create">Create Your Task</a></li>
					<li><a href="update">Update A Task</a></li>
					<li><a href="delete">Delete A Task</a></li>
					<!--<li><a href="#">Contact</a></li>-->
				</ul>
			</nav>
		</div>

		<!-- Jumbotron -->
		<div class="jumbotron">
			<h1>
				<span>Everything Around Tasks!</span>
			</h1>
			<p class="lead">
				<span>If you are looking for the right person in the right
					time, guess what??</span><br /> <span>You are in the right place!</span>
			</p>
			<p>
				<a class="btn btn-lg btn-success"
					href="create" role="button">Create
					Your Task!</a>
			</p>
		</div>
	</div>
	<!-- /container -->
	<!-- Site footer -->
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy 2016 Θεοδωρόπουλος Λάμπρος-Δημήτριος</p>
		</div>
	</footer>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>
