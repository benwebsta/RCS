<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
</head>
<body>
	
	<form ng-controller="updatePasswordController">
		Input new password:
		<input type="text" placeholder="password" ng-model="pass">
		<input type="button" value="submit" ng-click="update(pass)">
		{{passwordUpdate}}
	</form>
	
<script src="resources/app.js"></script>
<script src="resources/updatePasswordController.js"></script>

</body>
</html>

