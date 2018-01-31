(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'LoginController',
			[
			 '$scope',
			 '$location',
			 '$exceptionHandler',
			 'LoginService',
			 function($scope,$location,$exceptionHandler,LoginService) {

		$scope.login = function () {
			LoginService.Login($scope).success(function(response, status, headers, config){
				//Get All events list api  than it will redirect to dashboard
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