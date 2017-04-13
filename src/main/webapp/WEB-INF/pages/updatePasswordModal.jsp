<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
</head>

<body>


	
	<div id="changepasswordModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Change Password</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div ng-controller="updatePasswordController">
	      <div class="modal-body">
	        <h5>Input new password:</h5>
				<input type="text" placeholder="password" ng-model="pass" ng-pattern="/^[a-zA-Z0-9]+$/" required>
	      </div>
	      <div class="modal-footer">
	      		<div class="row">
	      			<div class="col-md-6">
	      				<div class="alert alert-success" ng-show="result == true">
						  <strong>Success!</strong> Password saved!
						</div>
						<div class="alert alert-danger" ng-show="result == false">
						  <strong>Alert!</strong> Password save failed!
						</div>
	      			</div>
	      			<div class="col-md-3">
	      		    	<button type="button" class="btn btn-primary" ng-click="update()">Save New Password</button>
	      			</div>
	      			<div class="col-md-3">
	      				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      			</div>
		        </div>
	        </div>
	        
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>

