<%@ page language="java" contentType="text/html;
charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>

<%@ include file="professional_user_header_results.html" %>

	<div class="container"  align="center" id="results">
        <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-1" >
          	<section>
                <h2>ERROR</h2>
                <% if(request.getAttribute("errormessage") != null) { %>
				<div class="alert alert-danger" role="alert">
					<%=request.getAttribute("errormessage").toString() %>
				</div>
				<% } %>
                
                
          	</section>
        </div>
 	</div>
 	
 <%@ include file="professional_user_footer.html" %>