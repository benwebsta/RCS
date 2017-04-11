<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
</head><!-- 
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.min.js"></script>
<script src="resources/js/app.js"></script>
<script src="resources/js/updatePasswordController.js"></script> -->

<body ng-app="rcs">


	
	<div id="testModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Change Password</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div ng-controller="updatePasswordController">
	      <div class="modal-body">
	        <p>Input new password:</p>
				<input type="text" placeholder="password" ng-model="pass">
	      </div>
	      <div class="modal-footer"	>
	        <button type="button" class="btn btn-primary" ng-click="update()">Save New Password</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        </div>
	        
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>

