(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'EventController',
			[
			 '$scope',
			 '$location',
			 '$exceptionHandler',
			 function($scope,$location,$exceptionHandler) {
					var stompClient = null;
					$scope.connect = function ()  {
					    var socket = new SockJS('/reckon');
					    stompClient = Stomp.over(socket);
					    stompClient.connect({}, function (frame) {
					        stompClient.subscribe('/topics/event', function (data) {
					        	 console.log('Connected: ' + data);
					        });
					    });
					}
					
					$scope.disconnect = function ()  {
					    if (stompClient !== null) {
					        stompClient.disconnect();
					    }
					    setConnected(false);
					    console.log("Disconnected");
					}
					
						$scope.connect();
					
			 } ]);
}());