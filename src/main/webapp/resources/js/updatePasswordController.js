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
		    
		    
		    $http.post('/updatePassword', employee )
		    		.then(
		    		function (response) {
		                console.log(response.data);
		            },
		            function(errResponse){
		                console.error('Error while updating User');
		            });
			
			// Making the fields empty
			//
			$scope.password ='';
		    
		  }
		  
	}]);
