app.controller("applyToMoveController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#applyToMoveModal').modal({ show: false})
		
		  $scope.applyToMove = function() {
			  $('#applyToMoveModal').modal('show');
		  }
		  
		  
	}]);
