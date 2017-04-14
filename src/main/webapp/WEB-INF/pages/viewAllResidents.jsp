
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" ng-controller="viewAllResidentsController">
	<h1 class="page-header">View All Residents Page</h1>
	<style>
		table {
	    	width: 100%;
	    	border: 1px solid black;
		}
		
		th {
		    height: 50px;
		    border: 1px solid black;
		}
		td {
			border: 1px solid black;	
		}
		#subButton {
			border-radius: 25px;
    		border: 2px solid #73AD21;
    		width: 100%;
		}
	</style>
	<!-- {{employeesList}} -->
	<br>
	<table ng-cloak>
	  <tr>
	    <th>First Name</th>
	    <th>Last Name</th>
	    <th>Address</th>
	    <th>Gender</th>
	    <th>Email</th>
	    <th>Mark as moved out</th>
	  </tr>
	  <tr ng-repeat="employee in employeesList">
	    <td>{{employee.employee.firstName}}</td>
	    <td>{{employee.employee.lastName}}</td>
	    <td>{{employee.address}}</td>
	    <td>{{employee.gender}}</td>
	    <td>{{employee.employee.email}}</td>
	    <td><button ng-click="confirmMoveButton(employee)">Move out</button></td>
	  </tr>
	</table><hr>
	<div class="alert alert-danger" ng-show="confirmMoveOut == true" ng-cloak>
	  Are you sure you want to move out <strong>{{empl.employee.firstName}} {{empl.employee.lastName}}</strong>?
	</div><br><br>
	<div class="row" ng-show="confirmMoveOut == true" ng-cloak>
		<div class="col-md-2"></div>
		<div class="col-md-4">
	    	<button type="button" class="btn btn-success" ng-click="markAsMovedOut()">Move out {{empl.employee.firstName}} {{empl.employee.lastName}}</button>
		</div>
		<div class="col-md-4">
			<button type="button" class="btn btn-danger" ng-click="cancelMoveOut()">Cancel</button>
		</div>
		<div class="col-md-2"></div>
	</div>
	
	
</div>
