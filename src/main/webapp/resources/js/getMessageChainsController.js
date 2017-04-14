/*app.service('messageService', function() {
  var messageObj = {};

  var setMessageObj = function(newObj) {
      messageObj = newObj;
  };

  var getMessageObj = function(){
      return messageObj;
  };

  return {
    setMessageObj: setMessageObj,
    getMessageObj: getMessageObj
  };

});
 */

app.controller("getMessageChainsController", [ '$scope', '$http', '$rootScope',
		function($scope, $http, $rootScope) {
			console.log("controller 1");
			$('#showMessages').modal({
				show : false
			});
			
			$scope.getMessageChains = function() {
				console.log("getting message chains")
				$scope.loadingMessages = true;
				$scope.chains = []
				$scope.error = false;
				$http({
					method : 'GET',
					url : 'messageRest'
				}).then(function successCallback(response) {
					console.log(response.data);
					console.log("Message Chains Loaded");
					$scope.chains = response.data;
					$scope.loadingMessages = false;
				}, function errorCallback(response) {
					console.log("error");
					$scope.loadingMessages = false;
					$scope.error = true;
				});
			};
			$scope.$on("reloadMessageChain", function(event) {
				$scope.getMessageChains();
			});

			$scope.onChainClick = function(chainId) {
				$('#showMessages').modal({
					show : true
				})
				console.log("send update message request")
				$rootScope.$broadcast('updateMessages', chainId);
			};

			$scope.showNewMessageModel = function() {
				console.log("Show New Message Modal");
				$('#newMessageChainModal').modal('show');
				$rootScope.$broadcast('loadUsers', null);
			};
		} ]);

app.controller("getMessages", [ '$scope', '$http', '$rootScope',
		function($scope, $http, $rootScope) {
			console.log("controller 2");
			$scope.msg = [];
			$scope.loadMsgs = function(chainId) {
				console.log('messagesUpdating');
				$scope.loadingMessages = true;
				$scope.msgs = [];
				$http({
					method : 'GET',
					url : 'messageRest/' + chainId
				}).then(function successCallback(response) {
					console.log(response.data);

					// $rootScope.$broadcast('updateMessages', response.data);
					//used to reference itself when adding in new messages
					$scope.currentChain = chainId;
					$scope.newMessageContext = "";
					$scope.msgs = response.data;
					$scope.loadingMessages = false;
				}, function errorCallback(response) {
					console.log("error");
				});
			};

			$scope.$on('updateMessages', function(event, chainId) {
				$scope.loadMsgs(chainId);
			});

			$scope.newMessage = function() {
				var jsonString = JSON.stringify({
					messagechain : $scope.currentChain,
					message : $scope.newMessageContext
				});
				console.log(jsonString);
				$http({
					method : 'POST',
					url : 'messageRest/UpdateMessageChain',
					data : jsonString
				}).then(function successCallback(response) {
					console.log(response.data);
					$scope.result = true
					// updates the message chain
					$scope.loadMsgs($scope.currentChain);
					// $scope.onChainClick($currentChain);
				}, function errorCallback(response) {
					console.log("error");
				});
			};
		} ]);



