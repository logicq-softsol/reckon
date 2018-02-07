(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'LoginController',
			[
			 '$scope',
			 '$rootScope',
			 '$location',
			 '$exceptionHandler',
			 'LoginService',
			 function($scope,$rootScope,$location,$exceptionHandler,LoginService) {
				 $scope.tableListSR = [];
				 $scope.tableListSRM = [];
				 $scope.tableListSRC = [];
				 $scope.tableListSC = [];
				 $scope.tableListYL = [];
		$scope.login = function () {
			LoginService.Login($scope).success(function(response, status, headers, config){
				$location.path('/dashboard');
				//$rootScope.busyTableDetails=response.tableDetails;
				//$rootScope.$broadcast('loginTableDetails');
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