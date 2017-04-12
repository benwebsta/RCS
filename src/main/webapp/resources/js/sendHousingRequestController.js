app.controller("sendHousingRequestController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#sendHousingRequestModal').modal({ show: false})
		
		$scope.test = function() {
			console.log("test");
		}
		
		
		$scope.send = function() {
			console.log("teststststuuuu");
		    
		    var recipientEmail = $scope.recipientEmail;
		    var header = $scope.header;
		    var body = $scope.body;
		    
		    console.log(recipientEmail);
		    console.log(header);
		    console.log(body);
		    
		    var email = {
		    		recipientEmail : recipientEmail,
		    		header : header, 
		    		body : body
		    }
		    console.log(email);
	
		  }
		
		  $scope.sendHousingRequest = function() {
			  $('#sendHousingRequestModal').modal('show');
		  }
		  
		  
	}]);
