<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.ProfessionalUser"%>
<%@ page import="javax.sql.rowset.CachedRowSet"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bids4Job Professional User Profile</title>
<!-- Add favicon -->
<link rel="icon" href="favicon.ico">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Custom Style -->
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/profiles.css">
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

				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="profile_professional"><span
							class="glyphicon glyphicon-user"></span>My Profile</a></li>
					<li><a href="logout_user"><span
							class="glyphicon glyphicon-log-out"></span>Logout</a></li>
				</ul>
			</div>
			<!-- end un-collapsed navbar-->
		</div>
	</nav>
	<!--Navbar end-->


	<div class="container">

		<div class="row">
			<div
				class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">User Profile</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-3 " align="center">
								<img alt="User Pic" src="images/user_avatar.png"
									class="img-circle img-responsive">
							</div>
							<!-- Getting Attrin=bute from session -->
							<%
								ProfessionalUser pro = (ProfessionalUser) session.getAttribute("pro");
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								DecimalFormat decimalFormat = new DecimalFormat("##.##");
								String rating = (String) request.getAttribute("rating");
							%>
							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Username:</td>
											<td><%=pro.getUsername()%></td>
										</tr>
										<tr>
											<td>Rating:</td>
											<td>
												<%
													if (rating.equals("-")) {
														out.println(rating);
													} else {
														out.println(decimalFormat.format(Double.parseDouble(rating)));
													}
												%>
											</td>
										</tr>
										<tr>
											<td>Email:</td>
											<td><%=pro.getEmail()%></td>
										</tr>
										<tr>
											<td>Name:</td>
											<td><%=pro.getFirstName()%></td>
										</tr>
										<tr>
											<td>Surname:</td>
											<td><%=pro.getLastName()%></td>
										</tr>
										<tr>
											<td>Location:</td>
											<td><%=pro.getLocation()%></td>
										</tr>
										<tr>
											<td>Profession:</td>
											<td><%=pro.getProfession()%></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- End of .panel-->
			</div>
		</div>
		<!-- End of .row-->

		<div class="row">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h2 class="panel-title">My Bids</h2>
				</div>
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">

					<!-- Get the task details from the request -->
					<%
						CachedRowSet crsTasks = (CachedRowSet) request.getAttribute("tasks");
						if (crsTasks.isBeforeFirst()) {
							int prevTaskID = 0;
							while (crsTasks.next()) {
								int taskID = crsTasks.getInt("task_id");
								if (taskID != prevTaskID) {
									if (prevTaskID != 0) {
					%>
					<!-- Same snippets: (244 - 274) or (157 - 188) -->
					</tbody>
					</table>
					<div class="panel-footer">
						<h4>Place a new bid</h4>
						<form class="form-inline" method="POST" action="create_bid">

							<div class="form-group">
								<label for="task-title" class="control-label">Amount
									&euro;</label> <input type="text" name="amount" ng-model="bid-amount"
									class="form-control" id="bid-amount" placeholder="Bid Amount"
									required>
							</div>

							<input type="hidden" name="taskId" value="<%=prevTaskID%>">
							<!-- Receive taskId to connect with new bid -->

							<div class="form-group">
								<button class="btn btn-sm btn-success" type="submit"
									name="submit" value="profile">
									<i class="glyphicon glyphicon-plus"></i>
								</button>
							</div>

						</form>
					</div>
					<!-- End .panel-footer -->
				</div>
				<!-- End .panel-body -->
			</div>
			<!-- End .panel-collapse collapse in -->
		</div>
		<!--  End .panel - info -->


		<%
			} // End	 if (prevTaskID != 0)
		%>
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="heading<%=taskID%>">
				<h4 class="panel-title">
					<a role="button" data-toggle="collapse" data-parent="#accordion"
						href="#collapse<%=taskID%>" aria-expanded="true"
						aria-controls="collapse<%=taskID%>"> Task #<%=taskID%> - <%=crsTasks.getString("title")%>
					</a>
				</h4>
			</div>
			<div id="collapse<%=taskID%>"
				class="panel-collapse collapse <%if (prevTaskID == 0) {%> in
            			<%}
						prevTaskID = taskID;%>"
				role="tabpanel" aria-labelledby="heading<%=taskID%>">
				<div class="panel-body">
					<table class="table">
						<tbody>
							<tr class="active">
								<th>Task Description</th>
								<th>Field of Work</th>
								<th>Task Location</th>
								<th>Deadline</th>
							</tr>
							<tr>
								<td><%=crsTasks.getString("description")%></td>
								<td><%=crsTasks.getString("work_field")%></td>
								<td><%=crsTasks.getString("location")%></td>
								<td><%=simpleDateFormat.format(crsTasks.getTimestamp("deadline"))%></td>
							</tr>
						</tbody>
					</table>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Bidder</th>
								<th>Rating</th>
								<th>Amount &euro;</th>
								<th>Bid Date</th>
								<th>Cancel Bid</th>
							</tr>
						</thead>
						<tbody>
							<%
								} // End 	if (taskID != prevTaskID)
							%>

							<tr>
								<td><%=crsTasks.getString("username")%></td>
								<%
									double bidder_rating = crsTasks.getDouble("rating");
											if (crsTasks.wasNull()) {
								%>
								<td>-</td>
								<%
									} else {
								%>
								<td><%=decimalFormat.format(bidder_rating)%></td>
								<%
									}
								%>
								<td><%=crsTasks.getInt("amount")%></td>
								<td><%=simpleDateFormat.format(crsTasks.getTimestamp("bid_time"))%></td>
								<td>
									<%
										if (crsTasks.getString("username").equals(pro.getUsername())) {
									%>
									<form class="form-inline" method="POST" action="cancel_bid">
										<input type="hidden" name="bidId"
											value="<%=crsTasks.getInt("bid_id")%>">
										<button type="submit" class="btn btn-danger">
											<i class="glyphicon glyphicon-remove"></i>
										</button>
									</form> <%
 	}
 %>
								</td>
							</tr>
							<%
								} // End 	while(crs.next())
							%>

							<!-- Same snippets: (244 - 274) or (157 - 188) -->
						</tbody>
					</table>
					<div class="panel-footer">
						<h4>Place a new bid</h4>
						<form class="form-inline" method="POST" action="create_bid">

							<div class="form-group">
								<label for="task-title" class="control-label">Amount
									&euro;</label> <input type="text" name="amount" ng-model="bid-amount"
									class="form-control" id="bid-amount" placeholder="Bid Amount"
									required>
							</div>

							<input type="hidden" name="taskId" value="<%=prevTaskID%>">
							<!-- Receive taskId to connect with new bid -->

							<div class="form-group">
								<button class="btn btn-sm btn-success" type="submit"
									name="submit" value="profile">
									<i class="glyphicon glyphicon-plus"></i>
								</button>
							</div>

						</form>
					</div>
					<!-- End .panel-footer -->
				</div>
				<!-- End .panel-body -->
			</div>
			<!-- End .panel-collapse collapse in -->
		</div>
		<!-- End .panel panel-default -->
		<%
			}
		%>
	</div>
	<!-- End of .panel-group -->
	</div>
	<!-- End of .panel panel-info -->
	</div>
	<!-- End of .row-->

	<hr>
	<footer>
		<p>
			&copy; 2016 Bids4Job S.A. &middot; <a href="#">Privacy</a> &middot; <a
				href="#">Terms</a>
		</p>
	</footer>
	<!-- End of Footer -->


	</div>
	<!-- End of .container-->





	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>