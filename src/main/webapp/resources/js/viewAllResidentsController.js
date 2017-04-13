app.controller("viewAllResidentsController", 
	['$scope', '$http',
		 function($scope, $http) {
		
		$http({
	    	  method: 'GET',
	    	  url: 'viewEmployees'
	    	}).then(function successCallback(response) {
	    		$scope.employeesList = response.data;
	    	  }, function errorCallback(response) {
	    	    console.log("error");
	    });
		
		
		  
	}]);
