var app = angular.module('RCS');

app.config(function($stateProvider, $urlRouterProvider) {
$stateProvider
.state('updatePassword', {
  url: "/updatePassword",
  abstract: true,
  templateUrl: "pages/updatePassword.jsp"
})
  $urlRouterProvider.otherwise("/");
})
