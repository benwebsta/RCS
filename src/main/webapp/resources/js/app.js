
var app = angular.module('rcs', []);


app.config(function($stateProvider, $urlRouterProvider) {
$stateProvider
.state('updatePassword', {
  url: "/updatePassword",
  templateUrl: "/updatePassword.jsp"
})
  $urlRouterProvider.otherwise("/");
})
