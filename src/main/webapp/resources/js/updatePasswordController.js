app.controller("updatePasswordController", 
	['$scope',
		 function($scope) {
		 console.log($scope.pass);
		 $scope.passwordUpdate = null;
		  $scope.update = function() {
		    $scope.passwordUpdate = $scope.pass; 
		    console.log($scope.passwordUpdate);
		  }
		  
	}]);
