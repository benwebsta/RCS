app.controller("sendHousingRequestController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#sendHousingRequestModal').modal({ show: false})
		$scope.confirmBoolean = true;
		var whoItAffects = "individual";
		
		$scope.send = function() {
			console.log("teststststuuuu");
		    
		    var header = $scope.header;
		    var body = $scope.body;
		    
		    console.log(header);
		    console.log(body);
		    if($scope.whoItAffects != undefined){
		    	whoItAffects = $scope.whoItAffects;
		    }
		    console.log(whoItAffects);
		    
		    var email = {
		    		recipientEmail : "housing@revature.com",
		    		header : header, 
		    		body : body, 
		    		whoItAffects : whoItAffects
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
