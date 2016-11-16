<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.ProfessionalUser"%>
<%@ page import="service.ProfessionalUserService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container"  align="center" id="results">
		<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
			<section>
				<h2>RESULTS</h2>
					<div class="panel-body">
				 		<%ProfessionalUser pro =(ProfessionalUser) session.getAttribute("pro"); %>
                		<table class="table table-condensed table-hovaer table-bordered">
		                		<p>Created Professional User</p>
		                		<tr style="background-color:#7a6aff ">
		                			<td>ID</td>
		                			<td>First Name</td>
		               				<td>Second Name</td>
		                			<td>Location</td>
		                			<td>Profession</td>
		                			<td>Username</td>
		                			<td>Password</td>
		                			<td>Email</td>
		                		</tr>
		                		<tr>
		                			<td><%= pro.getProUserId() %></td>
		                			<td><%= pro.getFisrtName() %></td>
		                			<td><%= pro.getLastName() %></td>
		                			<td><%= pro.getLocation() %></td>
		                			<td><%= pro.getProfession() %></td>
		                			<td><%= pro.getUsername() %></td>
		                			<td><%= pro.getPassword() %></td>
		                			<td><%= pro.getEmail() %></td>
		                		</tr>		
		                	</table>
				 	</div>
			
			</section>
		</div>
	</div>
	<form action="">
	<input type="submit" class="btn btn-primary btn-md" value="logout" id="SubmitButton" name="submit">
	</form>
</body>
</html>