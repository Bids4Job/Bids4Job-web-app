<%@page import="domain.Task"%>
<%@page import="service.TaskService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Find A Task</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/showfind.css">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%
		Task task = new Task();
		TaskService mService = new TaskService();
		String taskID = request.getParameter("taskId");
		int id = Integer.parseInt(taskID);
		task = mService.findOne(id);
		if (task == null) {
	%>
	<jsp:forward page="find.jsp">
		<jsp:param name="msg"
			value="The requested Task does not exist. Please try again!" />
	</jsp:forward>
	<%
		}
	%>
	<%
		if (task != null) {
	%>
	<div class="container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading nicelooking">THE REQUESTED TASK</div>
			<%
				int taskId = task.getTaskId();
					int simpleUserId = task.getSimpleUserId();
					String workField = task.getWorkField();
					String deadline = task.getDeadline().toString();
			%>
			<!-- Table -->
			<table class="table">
				<tr>
					<td><span class="tableheading">TASK NUMBER</span></td>
					<td><span class="tableheading">SIMPLE USER ID</span></td>
					<td><span class="tableheading">FIELD OF WORK</span></td>
					<td><span class="tableheading">DEADLINE</span></td>
				</tr>
				<tr>
					<td><%=taskId%></td>
					<td><%=simpleUserId%></td>
					<td><%=workField%></td>
					<td><%=deadline%></td>
				</tr>
			</table>
		</div>
	</div>
	<%
		}
	%>
	<div style="position: fixed; bottom: 5%; right: 0;">
		<a href="Index.jsp"><button type="button"
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
