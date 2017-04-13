app.controller("loginController", 
	['$scope', '$http',
		function($scope, $http) {
			$scope.login = true;
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
			   $scope.login = false;
			  }, function errorCallback(response) {
			    console.log("error");
			  });
		    $('#loginForm')[0].reset();

		  	}
			
			$scope.logout = function() {
				
				$scope.employee = null;
				$scope.login = true;
				
			}
			
			
		  
		  
	}]);
