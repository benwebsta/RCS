<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

<body>
	<form:form action="login" method="POST" commandName="employee">
	<!-- path=[field of object specified in command name] -->
	Username: <form:input path="username" />
	Password: <form:password path="password" />
	<input type="submit" value="login"/>
	
	</form:form>
	<div ng-app="rcs">
		<div ng-controller="loginController">
			Username:
			<input type="text" placeholder="username" ng-model="username">
			Password:
			<input type="text" placeholder="password" ng-model="password">
			<button ng-click="update()">Submit</button>
		</div>
	</div>
</body>
</html>