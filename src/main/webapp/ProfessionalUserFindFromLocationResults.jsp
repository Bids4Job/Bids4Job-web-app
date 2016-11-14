<%@ page language="java" contentType="text/html;
charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="domain.ProfessionalUser"%>
<%@ page import="service.ProfessionalUserService"%>
<%@ page import="java.util.List" %>

<%@ include file="ProfessionalUserHeaderResult.html" %>

	<div class="container"  align="center" id="results">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          	<section>
                <h2>RESULTS</h2>
                <div class="panel-body">
                	<%String location = request.getParameter("location");
                	List<ProfessionalUser> users = (List<ProfessionalUser>) request.getAttribute("users");%>
					<table class="table table-condensed table-hovaer table-bordered">
		            	<p>Professional Users From location: <%= location  %></p>
		               	<tr style="background-color:#7a6aff ">
		                	<td>ID</td>
		                	<td>First Name</td>
		               		<td>Second Name</td>
		                	<td>Location</td>
		                	<td>Profession</td>
		                </tr>
		                <% for (ProfessionalUser p: users) { %>
		                <tr>
		                	<td><%= p.getProUserId() %></td>
		                	<td><%= p.getFisrtName() %></td>
		                	<td><%= p.getLastName() %></td>
		                	<td><%= p.getLocation() %></td>
		                	<td><%= p.getProfession() %></td>
	                		<% } %>
                		</tr>
                	</table>
                </div>
          	</section>
        </div>
 	</div>
 	<%@ include file="ProfessionalUserFooter.html" %>