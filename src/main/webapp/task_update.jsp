<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Update A Task</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/task_update.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<div class="container">
		<%
			if (request.getAttribute("msg") != null) {
		%>
		<div
			class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-4 col-xs-offset-4">
			<ul class="list-group">
				<li class="list-group-item list-group-item-danger"><%=request.getAttribute("msg").toString()%></li>
			</ul>
		</div>

		<%
			}
		%>

		<div
			class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-4 col-xs-offset-4"
			id="center">
			<form class="navbar-form navbar-left" role="search" action="update"
				method="post">
				<div class="form-group">
					<input name="taskId" type="number" class="form-control"
						placeholder="Enter the Task's ID" required><br /> <input
						name="workField" type="text" class="form-control"
						placeholder="Enter the field of work" required><br /> <span
						style="color: yellow;">Deadline:</span><br /> <input type="date"
						name="date" class="form-control" required
						min="<%=dateFormat.format(date)%>"><br />
				</div>
				<br /> <br />
				<div class="col-lg-4 col-lg-offset-2">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</form>
		</div>
	</div>
	<div style="position: fixed; bottom: 5%; right: 0;">
		<a href="task_index.jsp"><button type="button"
				class="btn btn-default btn-lg">
				<span class="glyphicon glyphicon-home" aria-hidden="true"></span>Return
				to Home!
			</button></a>
	</div>

	<!-- Site footer -->
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy 2016 Θεοδωρόπουλος Λάμπρος-Δημήτριος</p>
		</div>
	</footer>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>