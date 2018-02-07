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
			 '$mdSidenav',
			 function($scope,$rootScope,$location,$interval,$exceptionHandler,$mdSidenav) {
				 $scope.tableListSR = [];
				 $scope.tableListSRM = [];
				 $scope.tableListSRC = [];
				 $scope.tableListSC = [];
				 $scope.tableListYL = [];
				 $scope.displayData={};
				 $scope.tableImg='assets/images/table-icon.png';
				 
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
					        		 item ["tableno"] = key;
					        		 item ["time"] = value.waitTime;
					        		 item ["srtime"] = value.requestTime;
					        		 if("SRC" == value.status){
					        			 item ["status"] = "md-accent";
					        			 item["tableimg"]="assets/images/gif/src.gif";;
					        			 $scope.tableListSRC.push(item);
					        		 } else if("SRM"== value.status){
					        			  item ["status"] = "md-warn";
					        			  item["tableimg"]="assets/images/gif/srm.gif";
					        			  $scope.tableListSRC.push(item);
					        		 }else if("SR"== value.status){
					        			 item ["status"] = "md-hue-1";
					        			 item["tableimg"]="assets/images/gif/sr.gif";
						        		  $scope.tableListSRC.push(item);
					        		 }
					        		 else if("SC"== value.status){
					        			 item ["status"] = "md-hue-1";
						        		  $scope.tableListSRC.push(item);
					        		 }else{
					        			 item ["status"] = "md-hue-1";
						        		  $scope.tableListSRC.push(item); 
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
				
					
					/*$rootScope.$on('loginTableDetails', function(event, data) {
					
			        	 angular.forEach($rootScope.busyTableDetails, function(value, key){
			        		 var item = {}
			        		 item ["value"] = key;
			        		 if("SRC" == value){
			        			 item ["status"] = "md-accent";
				        		 $scope.tableListSRC.push(item);
			        		 } else if("SRM"== value){
			        			  item ["status"] = "md-warn";
				        		  $scope.tableListSRC.push(item);
			        		 }else if("SR"== value){
			        			 item ["status"] = "md-hue-1";
				        		  $scope.tableListSRC.push(item);
			        		 }
			        		 else if("SC"== value){
			        			 item ["status"] = "md-hue-1";
				        		  $scope.tableListSRC.push(item);
			        		 }else{
			        			 item ["status"] = "md-hue-1";
				        		  $scope.tableListSRC.push(item); 
			        		 }
			        	    
			        	   });
					  });*/
					
			 } ]);
}());