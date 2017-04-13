app.controller("loginController", 
	['$scope', '$http',
		function($scope, $http) {

			$scope.login = true;
			$scope.loginHr = true;

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
				   $scope.dashboard = true;
				  }, function errorCallback(response) {
				    console.log("error");
				  });
			    $('#loginForm')[0].reset();
			    $('#loginFormHr')[0].reset();

		  	}
			
			$scope.updateHr = function() {
				
			    var usernameHr = $scope.usernameHr;
			    var passwordHr = $scope.passwordHr;
			    var credentialsHr = [usernameHr, passwordHr];
			    console.log(credentialsHr);
			    
			    $http({
			    	  method: 'POST',
					  url: 'loginRest',
					  data: credentialsHr
				}).then(function successCallback(response) {
				   $scope.employee = response.data;
				   $scope.loginHr = false;
				   $scope.dashboard = true;
				  }, function errorCallback(response) {
				    console.log("error");
				  });
			    $('#loginForm')[0].reset();
			    $('#loginFormHr')[0].reset();

		  	}
			
			$scope.logout = function() {
				console.log("test");
				$scope.employee = null;
				$scope.login = true;
				$scope.loginHr = true;
				$scope.dashboard = false;
				$scope.messages = false;
				$scope.viewAllResidents = false;
			}
			
			
		  
		  
	}]);
