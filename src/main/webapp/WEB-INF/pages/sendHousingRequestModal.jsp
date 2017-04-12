<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Housing Email</title>
</head>

<body ng-app="rcs">


	
	<div id="sendHousingRequestModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Send Housing Request</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div ng-controller="sendHousingRequestController">
		      <div class="modal-body">
		      
				<h3><b>To:</b> housing@revature.com</h3><br>
		        <h4><b>Email Header</b></h4>
				<input type="text" placeholder="header" ng-model="header">
		        <h5>Email body</h5>
				<input type="text" placeholder="email body" ng-model="body">
		     
		      </div>
		      <div class="modal-footer">
		      		<div class="row">
		      			<div class="col-md-6">
		      				<div class="alert alert-success" ng-show="result == true">
							  <strong>Success!</strong> Email sent!
							</div>
							<div class="alert alert-danger" ng-show="result == false">
							  <strong>Alert!</strong> Email Failed to Send!
							</div>
		      			</div>
		      			<div class="col-md-3">
		      		    	<button type="button" class="btn btn-primary" ng-click="send()">Send Email</button>
		      			</div>
		      			<div class="col-md-3">
		      				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
		      			</div>
			        </div>
		        </div>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>

