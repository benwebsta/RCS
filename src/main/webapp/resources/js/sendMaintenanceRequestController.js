app.controller("sendMaintenanceRequestController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#sendMaintenanceRequestModal').modal({ show: false})
		
		  $scope.sendMaintenanceRequest = function() {
			  $('#sendMaintenanceRequestModal').modal('show');
		  }
		  
		  
	}]);
