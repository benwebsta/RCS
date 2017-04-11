app.controller("dashboardController", 
	['$scope', '$http',
		 function($scope, $http) {
		$scope.dashboard = null;

		

		  $scope.showDashboard = function() {
			  if($scope.dashboard == false){
				  $scope.dashboard = true;
			  }
			  else if($scope.dashboard == true){
				  $scope.dashboard = false;
			  }
			  console.log($scope.dashboard); 
		  }
		  
	}]);
