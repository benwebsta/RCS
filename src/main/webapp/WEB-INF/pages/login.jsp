<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing</title>
</head>
<body>
	<p>Hi</p>
	<form:form action="login" method="POST" commandName="emp">
	<!-- path=[field of object specified in command name] -->
	Username: <form:input path="username" />
		<form:errors path="username" cssClass="alert alert-danger" element="div" />
	Password: <form:password path="password" />
		<form:errors path="password" cssClass="alert alert-danger" element="div" />
	<input type="submit" value="login"/>
	
	</form:form>
</body>
</html>