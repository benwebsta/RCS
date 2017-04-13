app.controller("applyToMoveController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#applyToMoveModal').modal({ show: false})
		
		$scope.test = function() {
			console.log("test");
		}
		
		$scope.send = function() {
			console.log("eh ku su");
			
			var header = $scope.header;
			var body = $scope.body;
			
			console.log(header);
			console.log(body);
		}
		
		  $scope.applyToMove = function() {
			  $('#applyToMoveModal').modal('show');
		  }
		  
		  
	}]);
