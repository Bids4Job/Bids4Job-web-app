<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.sql.rowset.CachedRowSet"%>

<!-- Get the contact details from the request -->
<%
	CachedRowSet crs = (CachedRowSet) request.getAttribute("contracts");
%>
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
									<th>Individual</th>
									<th>Rating</th>
									<th>Amount &euro;</th>
									<th>Contract Date</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><%=crs.getString("simple_username")%></td>
									<td>
										<%
											double rating = crs.getDouble("rating");
													if (crs.wasNull()) {
														out.println("-");
													} else {
														out.println(rating);
													}
										%>
									</td>
									<!-- End td for rating -->
									<td><%=crs.getInt("amount")%></td>
									<td><%=((SimpleDateFormat) request.getAttribute("simple-date-format"))
							.format(crs.getTimestamp("contract_time"))%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- End .panel -->
				<%
					}
				%>
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
