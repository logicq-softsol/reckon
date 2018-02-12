(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'EventController',
			[
					'$scope',
					'$rootScope',
					'$location',
					'$exceptionHandler',
					'$interval',
					'EventService',
					function($scope, $rootScope, $location, $exceptionHandler,$interval,EventService) {
						$scope.adv = {};
						$scope.adv.url = "http://127.0.0.1:8080/assets/video/demo1.mp4";
						$scope.adv.url1 = "http://127.0.0.1:8080/assets/video/videoplayback.mp4";
						$scope.advindex=0;
						
						 
						 
					
						 
					} ]);
}());