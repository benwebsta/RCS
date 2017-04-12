<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<script
		  src="http://code.jquery.com/jquery-3.1.1.js"
		  integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
		  crossorigin="anonymous"></script>
	
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<!-- Angular JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.min.js"></script>
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script> -->
	
	<!-- Scripts -->
	<script src="resources/js/app.js"></script>
	<script src="resources/js/updatePasswordController.js"></script>
	<script src="resources/js/loginController.js"></script>
	<script src="resources/js/dashboardController.js"></script>
	<script src="resources/js/applyToMoveController.js"></script>
	<script src="resources/js/sendHousingRequestController.js"></script>
	<script src="resources/js/sendMaintenanceRequestController.js"></script>
	<script src="resources/js/createNewResidentController.js"></script>
	
	<!-- CSS for our pages -->
	<script src="resources/css/home.css"></script>
	<script src="resources/css/messages.css"></script>
	
	<!-- CSS for dashboard template -->
	<link href="https://getbootstrap.com/examples/dashboard/dashboard.css" rel="stylesheet">
	<!-- <link rel="stylesheet" href="bower_components/angular-bootstrap-simple-chat/src/css/themes.css"> -->
	<title>Insert title here</title>
</head>
<body ng-app="rcs">

	<jsp:include page="updatePasswordModal.jsp"/>
	<jsp:include page="applyToMoveModal.jsp"/>
	<jsp:include page="sendHousingRequestModal.jsp"/>
	<jsp:include page="sendMaintenanceRequestModal.jsp"/>
	<jsp:include page="createNewResidentModal.jsp"/>
	
	

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Resident Communication System</a>
        </div>
        
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li ng-click="dashboard = !dashboard; login = false; messages = false"><a href="#">Dashboard</a></li>
            
            <li ng-controller="updatePasswordController" ng-click="changePassword()">
            	<a href="#">Change Password</a>
			</li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">current</span></a></li>
            <li ng-click="login = !login; dashboard = false; messages = false; viewAllResidents = false"><a href="#">Login</a></li>
            <li ng-click="dashboard = !dashboard; login = false; messages = false; viewAllResidents = false" ><a href="#">Dashboard show</a></li>
          </ul>
          <h4><b>Residents</b></h4>
          <ul class="nav nav-sidebar">
            <li ng-click="messages = !messages; dashboard = false; login = false; viewAllResidents = false"><a href="">Messages</a></li>
            <li ng-controller="applyToMoveController" ng-click="applyToMove()">
            	<a href="">Apply to move</a>
            </li>
            <li ng-controller="sendHousingRequestController" ng-click="sendHousingRequest()">
            	<a href="">Send Housing Request</a>
            </li>
            <li ng-controller="sendMaintenanceRequestController" ng-click="sendMaintenanceRequest()">
            	<a href="">Send Maintenance Request</a>
            </li>
          </ul>
          <h4><b>HR</b></h4>
          <ul class="nav nav-sidebar">
            <li ng-controller="createNewResidentController" ng-click="createNewResident()">
            	<a href="">Create New Resident</a>
            </li>
            <li ng-click="viewAllResidents = !viewAllResidents; dashboard = false; login = false; messages = false" ><a href="#">View All Residents</a></li>
          </ul>
        </div>
        
        <div ng-show="dashboard" ng-cloak>
        	<jsp:include page="dashboard.jsp"/>
        </div>
        <div ng-show="login" ng-cloak>
        	<jsp:include page="login.jsp"/>
		</div>
		<div ng-show="messages" ng-cloak>
        	<jsp:include page="messages.jsp"/>
		</div>
		<div ng-show="viewAllResidents" ng-cloak>
        	<jsp:include page="viewAllResidents.jsp"/>
		</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
<!--     Placed at the end of the document so the pages load faster
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    Just to make our placeholder images work. Don't actually copy the next line!
    <script src="../../assets/js/vendor/holder.min.js"></script>
    IE10 viewport hack for Surface/desktop Windows 8 bug
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->
  

</body>
</html>