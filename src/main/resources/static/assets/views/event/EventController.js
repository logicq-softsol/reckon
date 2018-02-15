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
						
						 
						var stompClient = null;
						$scope.connect = function ()  {
						    var socket = new SockJS('/reckon');
						    stompClient = Stomp.over(socket);
						    stompClient.connect({}, function (frame) {
						        stompClient.subscribe('/topics/event', function (data) {
						        	 $scope.displayData= JSON.parse(data.body);
						        	 $scope.reckonlist = [];
						        	 angular.forEach($scope.displayData, function(value, key){
						        		 var item = {}
						        		 item ["tableno"] = key;
						        		 item ["time"] = value.waitTime;
						        		 item ["srtime"] = value.requestTime;
						        		 if("SRC" == value.status){
						        			 item ["status"] = "md-accent";
						        			 item["tableimg"]="assets/images/gif/src.gif";;
						        			 $scope.reckonlist.push(item);
						        		 } else if("SRM"== value.status){
						        			  item ["status"] = "md-warn";
						        			  item["tableimg"]="assets/images/gif/srm.gif";
						        			  $scope.reckonlist.push(item);
						        		 }else if("SR"== value.status){
						        			 item ["status"] = "md-hue-1";
						        			 item["tableimg"]="assets/images/gif/sr.gif";
							        		  $scope.reckonlist.push(item);
						        		 }
						        		 else if("SC"== value.status){
						        			 item ["status"] = "md-hue-1";
							        		  $scope.reckonlist.push(item);
						        		 }else{
						        			 item ["status"] = "md-hue-1";
							        		  $scope.reckonlist.push(item); 
						        		 }
						        	    
						        	   });
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
					
						 
					
						 
					} ]);
}());