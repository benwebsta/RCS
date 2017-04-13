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
			var tester = "hello";
			console.log(tester);
			
			$http({
				method: 'POST',
				url: 'applyToMoveRest',
				data: tester
			}).then(function successCallback(response){
				$scope.result = response.data;
			}, function errorCallback(response) {
				console.log("error");
			});
		}
		
		  $scope.applyToMove = function() {
			  $('#applyToMoveModal').modal('show');
		  }
		  
		  
	}]);
