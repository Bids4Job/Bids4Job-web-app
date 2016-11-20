<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.ProfessionalUser"%>
<%@ page import="domain.SimpleUser"%>
<%@ page import="javax.sql.rowset.CachedRowSet"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page errorPage="error.jsp"%>

<%
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	DecimalFormat decimalFormat = new DecimalFormat("##.##");
	// Get the Professional User object from session
	ProfessionalUser professionalUser = (ProfessionalUser) session.getAttribute("pro");
	// Use a boolean to know if a ProfessionalUser or a SimpleUser is logged in
	boolean isSimple = ((SimpleUser) session.getAttribute("simple-user")) != null;
	boolean isPro = (professionalUser != null);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bids4Job Search Results</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Custom Style -->
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/profiles.css">
<link href="css/stylesTest.css" rel="stylesheet">
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

	<%-- Place the appropriate navigation bar --%>
	<%
		if (!isPro && !isSimple) {
	%>
	<%@ include file="navbar_login.jsp"%>
	<%
		} else {
	%>
	<%@ include file="navbar_logout.jsp"%>
	<%
		}
	%>

	<%@ include file="login_modal.jsp"%>


	<div class="container-fluid">

		<div class="row">
			<div class="col-lg-12 results-img">
				<img class="img-responsive" src="images/results.jpg">
			</div>
		</div>
		<!-- End of .row-->
	</div>

	<div class="container">
		<div class="row toppad">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h2 class="panel-title">
						<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>&nbspSearch
						Results
					</h2>
				</div>
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">

					<!-- Get the task details from the request -->
					<%
						CachedRowSet crsTasks = (CachedRowSet) request.getAttribute("tasks");
						if (crsTasks.isBeforeFirst()) {
							boolean sameProfession = false;
							int prevTaskID = 0;
							int taskID;
							String prevProfession = "";
							while (crsTasks.next()) {
								sameProfession = (isPro) && professionalUser.getProfession().equals(prevProfession);
								taskID = crsTasks.getInt("task_id");
								if (taskID != prevTaskID) {
									if (prevTaskID != 0) {
					%>
					</tbody>
					</table>
					<%
						if (sameProfession) {
					%>
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
								<button class="btn btn-sm btn-success" type="submit">
									<i class="glyphicon glyphicon-plus"></i>
								</button>
							</div>

						</form>
					</div>
					<!-- End .panel-footer -->
					<%
						}
					%>
				</div>
				<!-- End .panel-body -->
			</div>
			<!-- End .panel-collapse collapse in -->
		</div>
		<!-- End .panel panel-default -->
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
						prevTaskID = taskID;
						prevProfession = crsTasks.getString("work_field");%>"
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
							</tr>
						</thead>
						<tbody>
							<%
								} // End 	if (taskID != prevTaskID)
										int bidID = crsTasks.getInt("bid_id");
										if (bidID != 0) {
							%>
							<tr>
								<td><%=crsTasks.getString("username")%></td>
								<%
									double rating = crsTasks.getDouble("rating");
												if (crsTasks.wasNull()) {
								%>
								<td>-</td>
								<%
									} else {
								%>
								<td><%=decimalFormat.format(rating)%></td>
								<%
									}
								%>
								<td><%=crsTasks.getInt("amount")%></td>
								<%
									Timestamp bid_timestamp = crsTasks.getTimestamp("bid_time");
												if (crsTasks.wasNull()) {
								%>
								<td>-</td>
								<%
									} else {
								%>
								<td><%=simpleDateFormat.format(bid_timestamp)%></td>
								<%
									}
								%>
							</tr>
							<%
								} // End 	if (bidID != 0)
										else {
							%>
							<tr>
								<td colspan="4">-</td>
							</tr>
							<%
								} // End if-else bidID != 0
									} // End 	while(crs.next())
							%>
						</tbody>
					</table>
					<%
					if (sameProfession) {
					%>
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
								<button class="btn btn-sm btn-success" type="submit">
									<i class="glyphicon glyphicon-plus"></i>
								</button>
							</div>

						</form>
					</div>
					<!-- End .panel-footer -->
					<%
						}
					%>
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
	<!-- End .panel-group -->
	</div>
	<!-- End .panel panel-info -->
	</div>
	<!-- End of .row -->

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