app.controller("createNewResidentController", 
	['$scope', '$http',
		 function($scope, $http) {
		$('#createNewResidentModal').modal({ show: false})
		$scope.apartments = [];
		$scope.selectedApartment = {};
		
		$scope.loadOptions = (function() {
			if ($scope.apartments.length == 0) {
			$http({
	    	  method: 'GET',
	    	  url: 'viewApartments'
	    	}).then(function successCallback(response) {
	    		$scope.apartments = response.data;
	    	  }, function errorCallback(response) {
		    	console.log("error");
		    });
			};
		});
		console.log('viewApartments ran successfully');
		
		
		  $scope.update = function() {
			  console.log('in scope.update');

			    var emp = {
			    		employeeId : null,
			    		firstName : $scope.newEmployee.firstName, 
			    		lastName : $scope.newEmployee.lastName,
			    		username : $scope.newEmployee.firstName,
			    		password : $scope.newEmployee.lastName,
			    		apartmentId : $scope.selectedApartment,
			    		genderId : $scope.selectedGender,
			    		fill : 1,
			    		email : $scope.newEmployee.email
			    }
			    console.log(emp);
			    
			    $http({
			    	  method: 'POST',
			    	  url: 'createNewResidentRest',
			    	  data: emp
			    	}).then(function successCallback(response) {
			    	   $scope.result = response.data;
			    	  }, function errorCallback(response) {
			    	    console.log("error");
			    	  });
			    
			  };
		
		  $scope.createNewResident = function() {
			  $('#createNewResidentModal').modal('show');
		  }
		  
		  
	}]);
