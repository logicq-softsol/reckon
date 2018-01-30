(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'EventController',
			[
			 '$scope',
			 '$rootScope',
			 '$location',
			 '$interval',
			 '$exceptionHandler',
			 function($scope,$rootScope,$location,$interval,$exceptionHandler) {
				 $scope.grid = [];
				 $scope.sr = {};
				 
					var stompClient = null;
					$scope.connect = function ()  {
					    var socket = new SockJS('/reckon');
					    stompClient = Stomp.over(socket);
					    stompClient.connect({}, function (frame) {
					        stompClient.subscribe('/topics/event', function (data) {
					        	 $scope.grid.push(data.body);
					        	 $rootScope.$apply(); 
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
					
					$scope.updateStatus= function($interval) {
					      var self = this;
					      self.srValue = 10;

					      // Iterate every 100ms, non-stop and increment
					      // the Determinate loader.
					      $interval(function() {
					    	 var self = this;
					        self.srValue += 1;
					        if (self.srValue > 60) {
					          self.srValue = 10;
					        }

					      }, 60);
					    }
					
				
					
			 } ]);
}());