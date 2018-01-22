(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'EventController',
			[
			 '$scope',
			 '$location',
			 '$exceptionHandler',
			 'EventService',
			 function($scope,$location,$exceptionHandler,EventService) {
				 $scope.messages = [];
				 EventService.receive().then(null, null, function(message) {
				      $scope.messages.push(message);
				    });
			 } ]);
}());