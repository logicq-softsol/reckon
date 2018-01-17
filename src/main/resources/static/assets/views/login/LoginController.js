(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'LoginController',
			[
			 '$scope',
			 '$rootScope',
			 '$http',
			 '$location',
			 '$localStorage',
			 '$exceptionHandler',
			 'AuthenticationService',
			 function($scope,$rootScope,$http,$location,$localStorage,$exceptionHandler,AuthenticationService) {

		$scope.password={};
		$scope.request={};
		$scope.login = function () {
			AuthenticationService.Login($scope).success(function(response, status, headers, config){
				$location.path('/dashboard');
			}).error(function(response, status) {
				var errormsg='Unable to Login Check setting or Loging Details '+' Status Code : '+status;
				 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
				alert(errormsg);
				$exceptionHandler(errormsg);
				$location.path('/login');
			});
    };
			 } ]);
}());