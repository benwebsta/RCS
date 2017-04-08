app.controller('housingItemController', 
	["$scope",  
 function($scope) {
	  var passwordUpdate = "nothing";
	  $scope.update = function(password) {
		  console.log("test");
	    $scope.passwordUpdate = password;
	  }
}]);