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
					'DashboardService',
					'$sce',
					'$timeout',
					function($scope, $rootScope, $location, $exceptionHandler,$interval,EventService,DashboardService,$sce,$timeout) {
						$scope.adv = {};
						$scope.adv.url = "http://127.0.0.1:8080/assets/video/demo1.mp4";
						$scope.adv.url1 = "http://127.0.0.1:8080/assets/video/videoplayback.mp4";
						$scope.advindex=0;
						$scope.eventList=[];
						$scope.eventMap={};
						$scope.noEvent=true;
						var stompClient = null;
						
						$scope.connect = function ()  {
						if(null==stompClient){
						    var socket = new SockJS('/reckon');
						    stompClient = Stomp.over(socket);
						}  
						    stompClient.connect({}, function (frame) {
						        stompClient.subscribe('/topics/event', function (data) {
						        	$scope.eventData=JSON.parse(data.body);
						        	if(null!=$scope.eventData){
						        		$scope.eventList=[];	
						        	     angular.forEach($scope.eventData, function (value, key) {
						        	    	 $scope.eventList.push(value);
						        	        });
						            }
						        	 if($scope.eventList.length>0){
						        		 $scope.noEvent=false;
						        	 }
						        	 $scope.$emit('eventCount', { count: $scope.eventList.length });
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
					
						$scope.fetchPendingNotification= function ()  {
							EventService.GetAllEvents($scope).success(function(response, status, headers, config){
								$scope.eventData=response;
					        	if(null!=$scope.eventData){
					        		$scope.eventList=[];	
					        	     angular.forEach(response, function (value, key) {
					        	    	 $scope.eventList.push(value);
					        	        });
					            }
					        	 if($scope.eventList.length>0){
					        		 $scope.noEvent=false;
					        	 }
					        	 $scope.$emit('eventClikedCount', { count: $scope.eventList.length });
								}).error(function(response, status) {
									var errormsg='Unable to fetch Event';
									$exceptionHandler(errormsg);
								});
						}
						
						$scope.onLogoClick= function ()  {
							 $location.path('/dashboard');
						}
						
						$scope.currentVideo=0;
						 $scope.API = null;
						 $scope.state = null;
						 $scope.advType={};
						  $scope.videos = [  {sources: [{src: $sce.trustAsResourceUrl($scope.adv.url), type: "video/mp4"}
                          ]
                      },
                      { sources: [
                              {src: $sce.trustAsResourceUrl($scope.adv.url1), type: "video/mp4"}
                          ]
                      }
                  ]; 
						 
						 $scope.allVideoAdv = function ()  {
							 DashboardService.GetAllAdvType($scope).success(function(response, status, headers, config){
								 angular.forEach(response, function (value) {
									 if($scope.videos.length>0){
										 var data={sources: [{src: $sce.trustAsResourceUrl(value.fileURL), type: "video/mp4"}]};
										 $scope.videos.push(data);
									 }
				        	        });
								}).error(function(response, status) {
									var errormsg='Unable to fetch User Details ';
									$exceptionHandler(errormsg);
								});
	
						 };
						

				            $scope.onPlayerReady = function(API) {
				            	$scope.API = API;
				            };  
				            
				            $scope.onCompleteVideo = function() {
				            	$scope.isCompleted = true;
				            	$scope.currentVideo++;
				            	if ($scope.currentVideo >= $scope.videos.length) $scope.currentVideo = 0;
				            	 $scope.setVideo($scope.currentVideo);
				            }
				            
				            $scope.setVideo = function(index) {
				            	$scope.API.stop();
				            	$scope.currentVideo = index;
				            	$scope.config.sources = $scope.videos[index].sources;
				                $timeout($scope.API.play.bind($scope.API), 100);
				            };
				            
				            $scope.config = {
				                    preload: "none",
				                    autoPlay: true,
				                    sources: $scope.videos[0].sources,
				                    theme: {
				                        url: "assets/css/videogular.css"
				                    }
				                };
				            
				    
						 
					} ]);
}());