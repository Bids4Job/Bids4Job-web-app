<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.SimpleUser"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.sql.rowset.CachedRowSet"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.sql.Timestamp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bids4Job Simple User Profile</title>
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

	<%
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// Get the SimpleUser object from the session
		SimpleUser simpleUser = (SimpleUser) session.getAttribute("simple-user");
		boolean isSimple = (simpleUser != null);
		// Set up the SimpleDateFormat and DecimalFormat objects
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		request.setAttribute("simple-date-format", simpleDateFormat);
		DecimalFormat decimalFormat = new DecimalFormat("##.##");
	%>

	<!--Navbar start-->
	<jsp:include page="navbar_logout.jsp">
		<jsp:param name="isSimple" value="<%=isSimple%>" />
		<jsp:param name="is-tab-active" value="true" />
	</jsp:include>
	<!--Navbar end-->

	<!-- Start #contracts-modal -->
	<%@ include file="simple_contracts_modal.jsp"%>
	<!-- End #contracts-modal -->

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
								<img alt="User Pic"
									src=<%=request.getContextPath() + "/user_image"%>
									class="img-circle img-responsive">
							</div>

							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Username:</td>
											<td><%=simpleUser.getUsername()%></td>
										</tr>
										<tr>
											<td>Email:</td>
											<td><%=simpleUser.getEmail()%></td>
										</tr>
										<tr>
											<td>Name:</td>
											<td><%=simpleUser.getFirstName()%></td>
										</tr>
										<tr>
											<td>Surname:</td>
											<td><%=simpleUser.getLastName()%></td>
										</tr>
										<tr>
											<td>Location:</td>
											<td><%=simpleUser.getLocation()%></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<a href="#" data-toggle="modal" data-target="#task-modal"
							title="Create new task" type="button" class="btn btn-primary">Create
							new task</a>
					</div>
				</div>
				<!-- End of .panel-->
			</div>
		</div>
		<!-- End of .row-->

		<div class="row">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h2 class="panel-title">My Tasks</h2>
				</div>
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">

					<!-- Get the contact details from the request -->
					<%
						CachedRowSet crsTasks = (CachedRowSet) request.getAttribute("tasks");
						if (crsTasks.isBeforeFirst()) {
							int prevTaskID = 0;
							while (crsTasks.next()) {
								int taskID = crsTasks.getInt("task_id");
								if (taskID != prevTaskID) {
									if (prevTaskID != 0) {
					%>
					<!-- Same snippets: (262 - 271) or (167 - 175) -->
					</tbody>
					</table>
				</div>
				<!-- End .panel-body -->
			</div>
			<!-- End .panel-collapse collapse in -->
		</div>
		<!-- End .panel-collapse collapse in -->


		<%
			} // End  if (prevTaskID != 0)
		%>
		<div class="panel panel-default">
			<a role="button" data-toggle="collapse" data-parent="#accordion"
				href="#collapse<%=taskID%>" aria-expanded="true"
				aria-controls="collapse<%=taskID%>">
				<div class="panel-heading" role="tab" id="heading<%=taskID%>">
					<h4 class="panel-title black">
						<b><%=crsTasks.getString("title")%></b> <span class="by-whom">by
							<%=crsTasks.getString("simple_username")%></span>
					</h4>
			</a>
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
							<th>Accept Bid</th>
						</tr>
					</thead>
					<tbody>
						<%
							} // End 	if (taskID != prevTaskID)
									int bidID = crsTasks.getInt("bid_id");
									if (bidID != 0) {
						%>
						<tr>
							<td><%=crsTasks.getString("pro_username")%></td>
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
							<td><form method="POST" action="sign_contract">
									<input type="hidden" name="taskId" value="<%=taskID%>">
									<input type="hidden" name="bidId" value="<%=bidID%>">
									<button type="submit" class="btn btn-success">
										<i class="glyphicon glyphicon-ok"></i>
									</button>
								</form></td>
						</tr>
						<%
							} // End 	if (bidID != 0)
									else {
						%>
						<tr>
							<td colspan="5">-</td>
						</tr>
						<%
							} // End if-else bidID != 0
								} // End 	while(crs.next())
						%>

						<!-- Same snippets: (262 - 271) or (167 - 175) -->
					</tbody>
				</table>

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

	<!-- Start #task-modal -->
	<div class="modal fade" id="task-modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header modal-header-primary">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">New Task</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" method="POST" action="create_task"
						class="form-signup">

						<div class="form-group">
							<label for="task-title" class="col-sm-2 control-label">Title</label>
							<div class="col-sm-10">
								<input type="text" name="task_title" ng-model="task-title"
									class="form-control" id="task-title" placeholder="Task Title"
									required>
							</div>
						</div>

						<div class="form-group">
							<label for="task-description" class="col-sm-2 control-label">Task
								Description</label>
							<div class="col-sm-10">
								<textarea type="text" rows="4" name="task_description"
									class="form-control" id="task_description"
									placeholder="Task Description..." maxlength="1000" required></textarea>
							</div>
						</div>

						<div class="form-group">
							<label for="deadline" class="col-sm-2 control-label">Deadline</label>
							<div class="col-sm-10">
								<input type="date" name="date" class="form-control"
									id="deadline" placeholder="Task Deadline"
									min="<%=dateFormat.format(date)%>" required>
							</div>
						</div>


						<div class="form-group">
							<label for="location" class="col-sm-2 control-label">Profession</label>
							<div class="col-sm-10">

								<select name="profession" id="professions" required>
									<option value=""></option>
									<option value="Electrician">Electrician</option>
									<option value="Plumber">Plumber</option>
									<option value="Painter">Painter</option>
									<option value="Hair Dresser">Hair Dresser</option>
									<option value="Developer">Developer</option>
									<option value="Designer">Designer</option>
									<option value="Dancer">Dancer</option>
									<option value="Banker">Banker</option>
									<option value="Logistics">Logistics</option>
									<option value="Personal Trainer">Personal Trainer</option>
									<option value="Teacher">Teacher</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">

								<input type="reset" class="btn btn-warning">
								<button type="submit" class="btn btn-success pull-right">Create</button>
							</div>

						</div>

					</form>

				</div>
				<!-- End .modal-body -->

			</div>
			<!-- End .modal-content -->
		</div>
		<!-- End .modal-dialog -->
	</div>
	<!-- End #task-modal -->

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