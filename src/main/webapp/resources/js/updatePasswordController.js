app.controller("updatePasswordController", 
	['$scope', '$http',
		 function($scope, $http) {
		 console.log($scope.pass);
		 $scope.passwordUpdate = null;
		  $scope.update = function() {
			  console.log($scope.employee);
		    $scope.passwordUpdate = $scope.pass; 
		    var employee = {
		    		password : $scope.passwordUpdate
		    }
		    console.log(employee);
		    
		    $http({
		    	  method: 'POST',
		    	  url: 'updatePassword_json',
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
