<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- Start Email Modal -->
<div class="modal fade" id="email-modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header modal-header-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Contact Form</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" method="POST" action="send_email">

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="text" name="name" ng-model="name"
								class="form-control" id="name" placeholder="Your Name" required>
						</div>
					</div>
					
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="email" name="email" ng-model="email"
								class="form-control" id="email" placeholder="Your Email" required>
						</div>
					</div>

					<div class="form-group">
						<label for="message" class="col-sm-2 control-label">Message</label>
						<div class="col-sm-10">
							<textarea type="text" rows="4" name="message"
								class="form-control" id="message"
								placeholder="Your Message..." maxlength="1000" required></textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">

							<input type="reset" class="btn btn-warning">
							<button type="submit" class="btn btn-success pull-right">Send It</button>
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
<!-- End Email Modal  -->
