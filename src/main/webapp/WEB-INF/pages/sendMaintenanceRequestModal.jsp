<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maintenance Email</title>
<style> 
	textarea {
	    width: 100%;
	    height: 150px;
	    padding: 12px 20px;
	    box-sizing: border-box;
	    border: 2px solid #ccc;
	    border-radius: 4px;
	    background-color: #f8f8f8;
	    font-size: 16px;
	    resize: none;
	}
</style>
</head>

<body ng-app="rcs">


	
	<div id="sendMaintenanceRequestModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Send Housing Request</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div ng-controller="sendMaintenanceRequestController">
		      <div class="modal-body">
		      
				<h3><b>To:</b> maintenance@revature.com</h3><br>
				<input type="text" placeholder="Subject line" ng-model="header">
				<form><br>
					<textarea placeholder="Email body" ng-model="body"></textarea>
		     	</form>
		      </div>
		      <div class="modal-footer">
		      		<div class="row" ng-show="confirmBoolean">
		      			<div class="col-md-6">
		      				<div class="alert alert-success" ng-show="result == true">
							  <strong>Success!</strong> Email sent!
							</div>
							<div class="alert alert-danger" ng-show="result == false">
							  <strong>Alert!</strong> Email Failed to Send!
							</div>
		      			</div>
		      			<div class="col-md-3">
		      		    	<button type="button" class="btn btn-primary" ng-click="confirm()">Send Email</button>
		      			</div>
		      			<div class="col-md-3">
		      				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
		      			</div>
			        </div>
			        <div class="row" ng-show="!confirmBoolean">
		      			<div class="col-md-6">
		      				<div class="alert alert-success" ng-show="result == true">
							  <strong>Success!</strong> Email sent!
							</div>
							<div class="alert alert-danger" ng-show="result == false">
							  <strong>Alert!</strong> Email Failed to Send!
							</div>
		      			</div>
		      			<div class="col-md-3">
		      		    	<button type="button" class="btn btn-success" ng-click="send()">Send email to Maintenance</button>
		      			</div>
		      			<div class="col-md-3">
		      				<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		      			</div>
			        </div>
		        </div>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>

