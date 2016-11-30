<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.sql.rowset.CachedRowSet"%>

<div class="modal fade" id="contracts-modal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header modal-header-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">My Contracts</h4>
			</div>
			<div class="modal-body">

				<!-- Get the contact details from the request -->
				<%
					CachedRowSet crs = (CachedRowSet) request.getAttribute("contracts");
				%>

				<%
					if (crs.isBeforeFirst()) {
						while (crs.next()) {
				%>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							Contract #<%=crs.getInt("contract_id")%></h4>
					</div>

					<div class="panel-body">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Professional</th>
									<th>Rating</th>
									<th>Amount &euro;</th>
									<th>Contract Date</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><%=crs.getString("pro_username")%></td>
									<td>
										<%
											double rating = crs.getDouble("rating");
													if (crs.wasNull()) {
										%> <!-- Start td for rating -->
										<form class="form-inline" method="POST"
											action="rate_professional" class="form-signup">
											<div class="form-group">
												<select name="rating" id="rating" required>
													<option value=""></option>
													<option value="0">0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select>
											</div>

											<div class="form-group">
												<input type="hidden" name="contract_id"
													value=<%=crs.getInt("contract_id")%>>
												<button type="submit" class="btn btn-success">Rate</button>
											</div>
										</form> <%
 	} else {
 				out.println(rating);
 			}
 %>
									</td>
									<!-- End td for rating -->
									<td><%=crs.getInt("amount")%></td>
									<td><%=simpleDateFormat.format(crs.getTimestamp("contract_time"))%></td>
								</tr>
							</tbody>
						</table>
					</div>
					<%
						}
					%>
				</div>
				<!-- End .panel -->
				<%
					}
				%>

			</div>
			<!-- End .modal-body -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>

			</div>
		</div>
		<!-- End .modal-content -->
	</div>
	<!-- End .modal-dialog -->
</div>
