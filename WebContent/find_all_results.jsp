<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.SimpleUser"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>All SimpleUsers</title>

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
<link rel="stylesheet" href="css/simple_user_main.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body>
	<div class="container">
		<h2>All Existing SimpleUsers</h2>
		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Fisrt Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Username</th>
						<th>Password</th>
						<th>Location</th>
					</tr>
				</thead>
				<%
					List<SimpleUser> simpleUsers = (List<SimpleUser>) request.getAttribute("simpleUsers");
					if (!simpleUsers.isEmpty()) {
				%>
				<tbody>
					<%
						for (SimpleUser simpleUser : simpleUsers) {
					%>
					<tr>
						<td><%=simpleUser.getSimpleUserID()%></td>
						<td><%=simpleUser.getFirstName()%></td>
						<td><%=simpleUser.getLastName()%></td>
						<td><%="notSupported"%></td>
						<td><%="notSupported"%></td>
						<td><%="notSupported"%></td>
						<td><%=simpleUser.getLocation()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>