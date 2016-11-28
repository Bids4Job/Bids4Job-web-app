<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
						<h2 class="form-signin-heading login-or-signup">Please Log in</h2>
						<label for="inputEmail" class="sr-only">Email address</label> <input
							type="text" id="inputEmail" class="form-control"
							placeholder="Email address" name="emailOrUsername" required autofocus>
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
					<form class="form-signin" method="POST" action="login_professional">
						<h2 class="form-signin-heading login-or-signup">Please Log in</h2>
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
