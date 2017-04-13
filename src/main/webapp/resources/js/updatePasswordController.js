app.controller("updatePasswordController", 
	['$scope', '$http', 
		 function($scope, $http) {
		$('#changepasswordModal').modal({ show: false})
		$scope.result = null;
		 $scope.passwordUpdate = null;
		 
		  $scope.update = function() {

		    var passwordUpdate = $scope.pass;
		    console.log(passwordUpdate);
		    
		    $scope.passwordUpdate = $scope.pass;
		    console.log($scope.employee);
		    var emp = {
		    		employeeId : $scope.employee.employeeId,
		    		firstName : $scope.employee.firstName, 
		    		lastName : $scope.employee.lastName,
		    		username : $scope.employee.username,
		    		password : passwordUpdate,
		    		apartmentId : $scope.employee.apartmentId,
		    		genderId : $scope.employee.genderId,
		    		fill : $scope.employee.fill,
		    		email : $scope.employee.email
		    }
		    console.log(emp);
		    
		    $http({
		    	  method: 'POST',
		    	  url: 'updatePasswordRest',
		    	  data: emp
		    	}).then(function successCallback(response) {
		    	   $scope.result = response.data;
		    	  }, function errorCallback(response) {
		    	    console.log("error");
		    	  });
		    
		  }
		  
		  $scope.changePassword = function() {
			  console.log("modal");
			  $('#changepasswordModal').modal('show');
		  }
		  
		  
	}]);
