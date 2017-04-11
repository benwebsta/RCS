<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- angular scripts-->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>
<script src="resources/js/app.js"></script>
<script src="resources/js/updatePasswordController.js"></script>
<title>New Password</title>
</head>

<body> --%>
<%-- 	<form:form action="login" method="POST" commandName="employee">
	<!-- path=[field of object specified in command name] -->
	Username: <form:input path="username" />
	Password: <form:password path="password" />
	<input type="submit" value="login"/>
	
	</form:form> --%>
	
	
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div ng-controller="loginController">
					<form name="loginForm">
						Username:
						<input type="text"
							name="employeeUsername" 
							placeholder="username" 
							ng-model="username"
							ng-maxlength="25"
							required />
						<div ng-messages="loginForm.employeeUsername.$error" role="alert">
							<div ng-message="required">You did not enter a field</div>
							<div ng-message="maxlength">Your field is too long</div>
						</div>
						Password:
						<input type="text"
							name="employeePassword"
							placeholder="password" 
							ng-model="password"
							ng-maxlength="25"
							required />
						<div ng-messages="loginForm.employeePassword.$error" role="alert">
							<div ng-message="required">You did not enter a field</div>
							<div ng-message="maxlength">Your field is too long</div>
						</div>
						<button ng-click="update()">Submit</button>
					</form>
					${{employee}}
				</div>
			</div>

	
	
	
<!-- </body>
</html> -->