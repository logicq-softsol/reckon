(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'AuthController',
			[
			 '$scope',
			 '$http',
			 '$location',
			 'AuthenticationService',
			 function($scope, $http, $location,AuthenticationService) {
							 $location.path('/login');
			 } ]);
}());
