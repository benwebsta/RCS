app.controller("sendHousingRequestController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#sendHousingRequestModal').modal({ show: false})
		$scope.confirmBoolean = true;
		
		$scope.test = function() {
			console.log("test");
		}
		
		
		$scope.send = function() {
			console.log("teststststuuuu");
		    
		    var header = $scope.header;
		    var body = $scope.body;
		    
		    console.log(header);
		    console.log(body);
		    
		    var email = {
		    		recipientEmail : "housing@revature.com",
		    		header : header, 
		    		body : body
		    }
		    $http({
		    	  method: 'POST',
		    	  url: 'sendEmailRest',
		    	  data: email
		    	}).then(function successCallback(response) {
		    	   $scope.result = response.data;
		    	  }, function errorCallback(response) {
		    	    console.log("error");
		    	  });
	
		  }
		
		  $scope.sendHousingRequest = function() {
			  $('#sendHousingRequestModal').modal('show');
		  }
		  $scope.confirm = function() {
			  $scope.confirmBoolean = false;
		  }
		  
	}]);
