app.controller("createNewResidentController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#createNewResidentModal').modal({ show: false})
		
		  $scope.createNewResident = function() {
			  $('#createNewResidentModal').modal('show');
		  }
		  
		  
	}]);
