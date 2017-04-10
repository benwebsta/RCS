app.controller("updatePasswordController", 
	['$scope', '$http',
		 function($scope, $http) {
		
		 console.log($scope.pass);
		 $scope.passwordUpdate = null;
		 
		  $scope.update = function() {

		    var passwordUpdate = $scope.pass;
		    console.log(passwordUpdate);
		    
		    $scope.passwordUpdate = $scope.pass; 
		    var employee = {
		    		password : passwordUpdate
		    }
		    console.log(employee);
		    
		    $http({
		    	  method: 'PUT',
		    	  url: 'updatePasswordRest',
		    	  data: employee
		    	}).then(function successCallback(response) {
		    	    console.log("success");
		    	  }, function errorCallback(response) {
		    	    console.log("error");
		    	  });
			
			// Making the fields empty
			//
			$scope.password ='';
		    
		  }
		  
	}]);
