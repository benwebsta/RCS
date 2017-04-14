app.controller("viewAllResidentsController", 
	['$scope', '$http',
		 function($scope, $http) {
		$scope.employeesList = null;
		$scope.confirmMoveOut = false;
		$scope.empl = false;
		
		$http({
	    	  method: 'GET',
	    	  url: 'viewEmployees'
	    	}).then(function successCallback(response) {
	    		$scope.employeesList = response.data;
	    	  }, function errorCallback(response) {
	    	    console.log("error");
	    });
		
		$scope.markAsMovedOut = function() {
			var emp = {
		    		employeeId : $scope.empl.employee.employeeId,
		    		firstName : $scope.empl.employee.firstName, 
		    		lastName : $scope.empl.employee.lastName,
		    		username : $scope.empl.employee.username,
		    		password : $scope.empl.employee.password,
		    		apartmentId : 4,
		    		genderId : $scope.empl.employee.genderId,
		    		fill : 0,
		    		email : $scope.empl.employee.email
		    }
		    
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
		    $scope.confirmMoveOut = false;
		}
		
		$scope.confirmMoveButton = function(employee){
			$scope.empl = employee;
			$scope.confirmMoveOut = true;
		}
		
		$scope.cancelMoveOut = function() {
			$scope.confirmMoveOut = false;
		}
		
		  
	}]);
