app.controller("sendMaintenanceRequestController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#sendMaintenanceRequestModal').modal({ show: false})
		$scope.confirmBoolean = true;
		
		$scope.send = function() {
			console.log("teststststuuuu");
		    
		    var header = $scope.header;
		    var body = $scope.body;
		    
		    console.log(header);
		    console.log(body);
		    
		    var email = {
		    		recipientEmail : "maintenance@revature.com",
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
		
		
		  $scope.sendMaintenanceRequest = function() {
			  $('#sendMaintenanceRequestModal').modal('show');
		  }
		  $scope.confirm = function() {
			  $scope.confirmBoolean = false;
		  }
		  
		  
	}]);
