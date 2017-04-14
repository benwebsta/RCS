<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
</head>

<body>

	<div id="loginModal" class="modal fade in">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Login Page</h3>
	          <span aria-hidden="true">&times;</span>
	      </div>
	      
	      <div>
	      <form name="loginForm">
			<div class="modal-body" ng-controller="loginController">
					<!-- USERNAME -->
			        <div class="form-group">
			            <label>Username</label>
			            <input type="text" 
			            	name="username" 
			            	class="form-control"
			            	ng-model="username" 
			            	ng-maxlength="25"
			            	ng-pattern="/^[a-zA-Z0-9]+$/">
			            <p ng-show="loginForm.username.$error.maxlength" class="help-block">Username is too long.</p>
			        </div>
			        <!-- PASSWORD -->
			        <div class="form-group">
			        	<label>Password</label>
			        	<input type="text" 
			        		name="password" 
			        		class="form-control"
			        		ng-model="password" 
			        		ng-maxlength="25"
			        		ng-pattern="/^[a-zA-Z0-9]+$/">
			            <p ng-show="loginForm.password.$error.maxlength" class="help-block">Password is too long.</p>
			        </div>
			        </div>
	      <div class="modal-footer">
    		    	<button type="submit" class="btn btn-primary" data-dismiss="modal">Submit</button>
    		    	<p ng-show="loginForm.$invalid">FUCK YOU</p>
	        </div>
	        </form>
	        
	      </div>
	    </div>
	  </div>
	</div>
	<script>
	$('document').ready(function()
			{
			    $('#loginModal').modal('show');

			});

	</script>
	
</body>
</html>

