(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'ProfileController',
			[
			 '$scope',
			 '$rootScope',
			 '$location',
			 '$interval',
			 '$exceptionHandler',
			 'ProfileService',
			 function($scope,$rootScope,$location,$interval,$exceptionHandler,ProfileService) {
			
				 
				 
				 $scope.loadUserDetails()= function () {
					 ProfileService.GetUserDetails($scope).success(function(response, status, headers, config){
						 $scope.userdetail=response;
						}).error(function(response, status) {
							var errormsg='Unable to Get user profile';
							$exceptionHandler(errormsg);
					});
				 }
				
				 
				
			 } ]);
}());