app.controller("applyToMoveController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#applyToMoveModal').modal({ show: false})
		
		$scope.test = function() {
			console.log("test");
		}
		
		$scope.send = function() {
			console.log("eh ku su");
			
			var moveHeader = "Request To Move";
			var moveBody = $scope.reasonToMove;

			var email = {
					moveHeader : moveHeader,
					moveBody : moveBody
			}
			
			$http({
				method: 'POST',
				url: 'applyToMoveRest',
				data: email
			}).then(function successCallback(response){
				$scope.resultToMove = response.data;
			}, function errorCallback(response) {
				console.log("error");
			});

		}
		
		  $scope.applyToMove = function() {
			  $('#applyToMoveModal').modal('show');
		  }
		  
		  
	}]);
