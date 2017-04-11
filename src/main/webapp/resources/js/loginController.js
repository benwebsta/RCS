app.controller("loginController", 
	['$scope', '$http',
		function($scope, $http) {
			$scope.result = null;
			$scope.employee = null;
			$scope.update = function() {
		
		    var username = $scope.username;
		    var password = $scope.password;
		    var credentials = [username, password];
		    console.log(credentials);
		    
		    $http({
		    	  method: 'POST',
				  url: 'loginRest',
				  data: credentials
			}).then(function successCallback(response) {
			   $scope.employee = response.data;
			  }, function errorCallback(response) {
			    console.log("error");
			  });

		  	}
		  
		  
	}]);
