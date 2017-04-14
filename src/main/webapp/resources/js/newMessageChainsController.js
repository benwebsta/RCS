console.log("newMessageController");

app.controller("newMessageChain", [ '$scope', '$http', '$rootScope', function($scope, $http, $rootScope) {
	//console.log("controller 4");
	$scope.loadUsers = function() {
		console.log("loading users");
		$http({
			method : 'GET',
			url : 'messageRest/getMessagebleUsers'
		}).then(function successCallback(response) {
			console.log(response.data);
			$scope.employeesList = response.data.employees
		}, function errorCallback(response) {
			console.log("error");
		});
	};
	
	$scope.$on('loadUsers', function(event){
		console.log("starting to load Users");
		$scope.loadUsers();
	});
	

	$scope.newMessageChain = function() {
		console.log("sending new message chain");
		$scope.error = false;
		var jsonString = JSON.stringify({
			otherEmployee : $scope.employeeSelected,
			isFromApartment : $scope.fromApartment || false,
			isToApartment : $scope.toApartment || false,
			message : $scope.newMessageContext
		});
		console.log(jsonString);
		$http({
			method : 'POST',
			url : 'messageRest/newChain',
			data : jsonString
		}).then(function successCallback(response) {
			console.log(response.data);
			$('#newMessageChainModal').modal('hide');
			$rootScope.$broadcast("reloadMessageChain", null);
			$scope.error = false;
		}, function errorCallback(response) {
			console.log("error");
			$scope.error = true;
		});
	};
} ]);