<%@ page language="java" contentType="text/html;
charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="domain.ProfessionalUser"%>
<%@ page import="service.ProfessionalUserService"%>

<%@ include file="professional_user_header_results.html" %>

	<div class="container"  align="center" id="results">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          	<section>
                <h2>RESULTS</h2>
                <div class="panel-body">
                	<%ProfessionalUser pro =(ProfessionalUser) request.getAttribute("pro"); %>
                	<table class="table table-condensed table-hovaer table-bordered">
		            	<p>Professional User</p>
		          		<tr style="background-color:#7a6aff ">
		 	      			<td>ID</td>
	            			<td>First Name</td>
		               		<td>Second Name</td>
		                	<td>Location</td>
		                	<td>Profession</td>
		                </tr>
		                <tr>
		                	<td><%= pro.getProUserId() %></td>
		                	<td><%= pro.getFirstName() %></td>
		                	<td><%= pro.getLastName() %></td>
		                	<td><%= pro.getLocation() %></td>
		                	<td><%= pro.getProfession() %></td>
		                </tr>		
		       		</table>
                </div>
                
          	</section>
        </div>
 	</div>
 	<%@ include file="professional_user_footer.html" %>