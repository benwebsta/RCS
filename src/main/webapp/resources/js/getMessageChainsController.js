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
			console.log("test appearence");
			$('#showMessages').modal({
				show : false
			});

			$scope.getMessageChains = function() {
				$http({
					method : 'GET',
					url : 'messageRest'
				}).then(function successCallback(response) {
					console.log(response.data);
					$scope.chains = response.data;
				}, function errorCallback(response) {
					console.log("error");
				});
			};
			$scope.onChainClick = function(chainId) {
				$('#showMessages').modal({
					show : true
				})
				console.log("send update message request")
				$rootScope.$broadcast('updateMessages', chainId);
			};
		} ]);

app.controller("getMessages", [ '$scope', '$http', '$rootScope',
		function($scope, $http, $rootScope) {
			$scope.loadMsgs = function(chainId) {
				console.log('messagesUpdating');
				$http({
					method : 'GET',
					url : 'messageRest/' + chainId
				}).then(function successCallback(response) {
					console.log(response.data);

					// $rootScope.$broadcast('updateMessages', response.data);
					$scope.currentChain = chainId;
					$scope.newMessageContext = "";
					$scope.msgs = response.data;

				}, function errorCallback(response) {
					console.log("error");
				});
			};

			$scope.$on('updateMessages', function(event, chainId) {
				loadMsgs(chainId);
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

					// $scope.onChainClick($currentChain);
				}, function errorCallback(response) {
					console.log("error");
				});
			};
		} ]);
