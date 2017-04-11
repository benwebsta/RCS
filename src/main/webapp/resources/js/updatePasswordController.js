app.controller("updatePasswordController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#testModal').modal({ show: false})
		
		 console.log($scope.pass);
		 $scope.passwordUpdate = null;
		 
		  $scope.update = function() {

		    var passwordUpdate = $scope.pass;
		    console.log(passwordUpdate);
		    
		    $scope.passwordUpdate = $scope.pass; 
		    var employee = {
		    		employeeId : 1,
		    		firstName : "Xavier", 
		    		lastName : "Grogan",
		    		username : "xavier",
		    		password : passwordUpdate,
		    		apartmentId : 2,
		    		genderId : 1,
		    		fill : 1
		    }
		    console.log(employee);
		    
		    $http({
		    	  method: 'POST',
		    	  url: 'updatePasswordRest',
		    	  data: employee
		    	}).then(function successCallback(response) {
		    	   $scope.passwordUpdate = response;
		    	  }, function errorCallback(response) {
		    	    console.log("error");
		    	  });
		    
		  }
		  
		  $scope.changePassword = function() {
			  $('#testModal').modal('show');
		  }
		  
	}]);
