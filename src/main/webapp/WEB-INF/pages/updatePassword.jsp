<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.min.js"></script>
<script src="resources/js/app.js"></script>
<script src="resources/js/updatePasswordController.js"></script>

<body ng-app="rcs">

	<div ng-controller="updatePasswordController">
		Input new password:
		<input type="text" placeholder="password" ng-model="pass">
		<button ng-click="update()">Update</button> Live Bound: {{pass}}<br>
		Angular bound pass change: {{passwordUpdate}}
		
	</div>
	
</body>
</html>

