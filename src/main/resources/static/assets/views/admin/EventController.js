(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'EventController',
			[
			 '$scope',
			 '$location',
			 '$exceptionHandler',
			 '$websocket'
			 'EventService',
			 function($scope,$location,$exceptionHandler,$websocket,EventService) {
				 $scope.messages = [];
				 var ws = $websocket.$new('ws://localhost:8080/reckon/websocket');
				 ws.onmessage = function(message) {
				        listener(JSON.parse(message.data));
				    };
				 
				    function listener(data) {
				        var messageObj = data;
				        console.log("Received data from websocket: ", messageObj);
				      }
				    
			 } ]);
}());