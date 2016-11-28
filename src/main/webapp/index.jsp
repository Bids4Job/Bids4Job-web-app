<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.ProfessionalUser"%>
<%@ page import="domain.SimpleUser"%>
<%@ page import="javax.sql.rowset.CachedRowSet"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page errorPage="error.jsp"%>

<%
	// Define formatters
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
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bids4Job</title>
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
<link href="css/carousel.css" rel="stylesheet">
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

	<!--Start Carousel-->

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide mod-img" src="images/1.jpg"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Get a quote for your need!</h1>
						<p>Sign-Up and start getting quotes for any task you need from
							our network of affiliated professionals!</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#howitworks"
								role="button">See how it works</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide mod-img" src="images/2.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Ask us about your need!</h1>
						<p>Have questions about a specific problem and would like to
							get an answer?</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#contact" role="button">Contact
								Us</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide mod-img" src="images/3.jpg"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Are you a professional?</h1>
						<p>Are you a professional interested in boosting your
							business? Let us show you how we can help you!</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#learnmore" role="button">Learn
								more</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<!--Start search field-->
		<form method="GET" action="search">
			<div id="searchForm">
				<div
					class="col-lg-4 col-md-6 col-sm-6 col-xs-8 col-lg-offset-4 col-md-offset-3 col-sm-offset-3 col-xs-offset-2">
					<div class="input-group">
						<select class="form-control" id="professions" name="profession"
							required>
							<option value="" selected disabled>Search for...</option>
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
						</select> <span class="input-group-btn">
							<button type="submit" class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbspSearch
							</button>
						</span>
					</div>
				</div>
			</div>
		</form>
		<!--End search field-->

		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!--End Carousel-->

	<%@ include file="login_modal.jsp"%>


	<div class="container marketing">

		<!-- Start of .featurette -->
		<div class="row featurette">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h2 class="panel-title">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>10
						Latest Deadlines
					</h2>
				</div>
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">

					<!-- Get the task details from the request -->
					<%
						CachedRowSet crsTasks = (CachedRowSet) request.getAttribute("tenTasks");
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
								<button class="btn btn-sm btn-success" type="submit"
									name="submit" value="index">
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
						prevTaskID = taskID;
						prevProfession = crsTasks.getString("work_field");
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
			<div id="collapse<%=taskID%>" class="panel-collapse collapse"
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
								<td><%=crsTasks.getString("pro_username")%></td>
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
								<button class="btn btn-sm btn-success" type="submit"
									name="submit" value="index">
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


	<hr class="featurette-divider">

	<div class="row featurette" id="howitworks">
		<div class="col-md-7 col-md-push-5">
			<h2 class="featurette-heading">
				Need a job done? <span class="text-muted">We'll find you the
					right professional!</span>
			</h2>
			<p class="lead">Sign up today and use our platform completely
				free, and let the bidding begin! Once you sign up, you can create a
				task and start receiving bids from our affiliated professionals, to
				make sure that you not only find the best person, but also the best
				price for your need!</p>
		</div>
		<div class="col-md-5 col-md-pull-7">
			<img class="featurette-image img-responsive center-block"
				src="images/pic1.jpg" alt="Generic placeholder image">
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette" id="learnmore">
		<div class="col-md-7">
			<h2 class="featurette-heading">
				Are you a professional? <span class="text-muted">Let us help
					you grow your business.</span>
			</h2>
			<p class="lead">Sign up today for free and start bidding on jobs
				you'd be interested in, and start building your rating with our
				service, in order to make sure your good reputation follows you
				everywhere! Contact us to discuss our competitive pricing plans for
				booking a job on our platform.</p>
		</div>
		<div class="col-md-5">
			<img class="featurette-image img-responsive center-block"
				src="images/pic2.jpg" alt="Generic placeholder image">
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette" id="contact">
		<div class="col-md-5 col-md-push-7">
			<h2 class="featurette-heading">
				Contact Us:</span>
			</h2>
			<p class="lead">
				<span class="glyphicon glyphicon-map-marker"></span>Korai 3, Athens,
				Greece
			</p>
			<p class="lead">
				<span class="glyphicon glyphicon-phone"></span> +30 6945000000
			</p>
			<p class="lead">
				<span class="glyphicon glyphicon-envelope"></span>&nbsp;<a
					href="mailto:bid4job@outlook.com" target="_top">bid4job@outlook.com</a>
			</p>
		</div>
		<div class="col-md-7 col-md-pull-5">
			<div id="googleMap" style="height: 500px; width: 500px;"></div>

			<!-- Add Google Maps -->
			<script src="https://maps.googleapis.com/maps/api/js"></script>
			<script>
				var myCenter = new google.maps.LatLng(37.980105, 23.732287);

				function initialize() {
					var mapProp = {
						center : myCenter,
						zoom : 12,
						scrollwheel : false,
						draggable : false,
						mapTypeId : google.maps.MapTypeId.ROADMAP
					};

					var map = new google.maps.Map(document
							.getElementById("googleMap"), mapProp);

					var marker = new google.maps.Marker({
						position : myCenter,
					});

					marker.setMap(map);
				}

				google.maps.event.addDomListener(window, 'load', initialize);
			</script>

		</div>
	</div>

	<hr class="featurette-divider">


	<!-- Start Footer -->

	<footer>
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>
		<p>
			&copy; 2016 Bids4Job S.A. &middot; <a href="#">Privacy</a> &middot; <a
				href="#">Terms</a>
		</p>
	</footer>
	<!-- End of Footer -->

	</div>
	<!-- End of .container marketing -->


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
