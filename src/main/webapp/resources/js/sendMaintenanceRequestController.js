app.controller("sendMaintenanceRequestController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#sendMaintenanceRequestModal').modal({ show: false})
		$scope.confirmBoolean = true;
		var whoItAffects = "Individual";
				
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
		    		recipientEmail : "maintenance@revature.com",
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
		
		
		  $scope.sendMaintenanceRequest = function() {
			  $('#sendMaintenanceRequestModal').modal('show');
		  }
		  $scope.confirm = function() {
			  $scope.confirmBoolean = false;
		  }
		  
		  $("#sendMaintenanceRequestModal").on("hidden.bs.modal", function(){
			  	console.log("TESTUUU");
			  	$("#head").removeData('bs.modal');
			  	$("#body").removeData('bs.modal');
			});
		  
		  
	}]);
