app.controller("sendHousingRequestController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#sendHousingRequestModal').modal({ show: false})
		
		  $scope.sendHousingRequest = function() {
			  $('#sendHousingRequestModal').modal('show');
		  }
		  
		  
	}]);
