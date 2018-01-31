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
				 $scope.tableListSR = [];
				 $scope.tableListSRM = [];
				 $scope.tableListSRC = [];
				 $scope.tableListSC = [];
				 $scope.tableListYL = [];
				 $scope.displayData={};
				 
					var stompClient = null;
					$scope.connect = function ()  {
					    var socket = new SockJS('/reckon');
					    stompClient = Stomp.over(socket);
					    stompClient.connect({}, function (frame) {
					        stompClient.subscribe('/topics/event', function (data) {
					        	 $scope.displayData= JSON.parse(data.body);
					        	 $scope.tableListSR = [];
								 $scope.tableListSRM = [];
								 $scope.tableListSRC = [];
					        	 angular.forEach($scope.displayData, function(value, key){
					        		 var item = {}
					        		 item ["value"] = key;
					        		 if("SRC" == value){
					        			 item ["status"] = "md-accent";
						        		 $scope.tableListSRC.push(item);
					        		 } else if("SRM"== value){
					        			  item ["status"] = "md-warn";
						        		  $scope.tableListSRM.push(item);
					        		 }else if("SR"== value){
					        			 item ["status"] = "md-hue-1";
						        		  $scope.tableListSR.push(item);
					        		 }
					        		 else if("SC"== value){
					        			 item ["status"] = "md-hue-1";
						        		  $scope.tableListSC.push(item);
					        		 }else{
					        			 item ["status"] = "md-hue-1";
						        		  $scope.tableListYL.push(item); 
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