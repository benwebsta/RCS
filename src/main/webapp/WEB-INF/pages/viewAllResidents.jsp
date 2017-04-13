
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
	<table>
	  <tr>
	    <th>First Name</th>
	    <th>Last Name</th>
	    <th>Address</th>
	    <th>Gender</th>
	    <th>Email</th>
	  </tr>
	  <tr ng-repeat="employee in employeesList">
	    <td>{{employee.employee.firstName}}</td>
	    <td>{{employee.employee.lastName}}</td>
	    <td>{{employee.address}}</td>
	    <td>{{employee.gender}}</td>
	    <td>{{employee.employee.email}}</td>
	  </tr>
	</table>
	
	
</div>
