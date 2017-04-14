app.controller("viewAllResidentsController", 
	['$scope', '$http',
		 function($scope, $http) {
		$scope.employeesList = null;
		$http({
	    	  method: 'GET',
	    	  url: 'viewEmployees'
	    	}).then(function successCallback(response) {
	    		$scope.employeesList = response.data;
	    	  }, function errorCallback(response) {
	    	    console.log("error");
	    });
		
		$scope.markAsMovedOut = function(employee) {
			console.log(employee.employee);
			var emp = {
		    		employeeId : employee.employee.employeeId,
		    		firstName : employee.employee.firstName, 
		    		lastName : employee.employee.lastName,
		    		username : employee.employee.username,
		    		password : employee.employee.password,
		    		apartmentId : employee.employee.apartmentId,
		    		genderId : employee.employee.genderId,
		    		fill : 0,
		    		email : employee.employee.email
		    }
		    console.log(emp);
		    
		    $http({
		    	  method: 'POST',
		    	  url: 'moveEmployeeOut',
		    	  data: emp
		    	}).then(function successCallback(response) {
		    	   $scope.resultLogout = response.data;
		    	  }, function errorCallback(response) {
		    	    console.log("error");
		    	  });
		    
		    $http({
		    	  method: 'GET',
		    	  url: 'viewEmployees'
		    	}).then(function successCallback(response) {
		    		$scope.employeesList = response.data;
		    	  }, function errorCallback(response) {
		    	    console.log("error");
		    });
		
		
		}
		
		  
	}]);
