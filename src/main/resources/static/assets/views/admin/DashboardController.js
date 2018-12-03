(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'DashboardController',
			[
			 '$scope',
			 '$rootScope',
			 '$location',
			 '$interval',
			 '$exceptionHandler',
			 'DashboardService',
			 'LoginService',
			 'LinkRNotifyService',
			 'ThresholdService',
			 'ServiceConfig',
			 function($scope,$rootScope,$location,$interval,$exceptionHandler,DashboardService,LoginService,LinkRNotifyService,ThresholdService,ServiceConfig) {
			 $scope.reckonlinkedlist = [];	
			 $scope.servicelist = [];
			 $scope.serviceconfg={};
			 $scope.serviceconfg.servcodedisable=true;
			 $scope.advlist=[];
			 $scope.adv={};
			 $scope.eventCount=0;
			 $scope.serviceList=[];
			 $scope.notLinkedRIds=[];
			 
			   $scope.displayUserProfile = function () {
			    	LoginService.GetUserDetails($scope).success(function(response, status, headers, config){
						$scope.userdetail=response.userDetails;
					}).error(function(response, status) {
						var errormsg='Unable to fetch User Details ';
						$exceptionHandler(errormsg);
					});
			    }
			 
			   $scope.goToProfile = function () {
					$location.path('/profile');
			   }
			   
			   
			   $scope.thresholdlist=[];
			   $scope.threshold={};
			   $scope.getThresholds = function () {
				   ThresholdService.GetAllThreshold($scope).success(function(response, status, headers, config){
						$scope.thresholdlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to fetch User Details ';
						$exceptionHandler(errormsg);
					});
			   }
			   
				 $scope.eachThresholdDetails = function (selectedThresh) {
					 $scope.threshold={};
					 $scope.threshold.services=[];
					 $scope.threshold.id=selectedThresh.id;
					 $scope.threshold.name=selectedThresh.name;
					 $scope.threshold.interval=selectedThresh.interval;
					 $scope.threshold.colorCode=selectedThresh.colorCode;
				 }
				 
				 $scope.updateThresholdDetails = function () {
					 ThresholdService.SaveThreshold($scope).success(function(response, status, headers, config){
						 $scope.thresholdlist=response;
						}).error(function(response, status) {
							var errormsg='Unable to Update '+' Status Code : '+status;
							$exceptionHandler(errormsg);
						});
				 }
				 $scope.deleteThresh = function () {
					 ThresholdService.DeleteThreshold($scope).success(function(response, status, headers, config){
						 $scope.thresholdlist=response;
						}).error(function(response, status) {
							var errormsg='Unable to Delete'+' Status Code : '+status;
							$exceptionHandler(errormsg);
						});
				 }
			   
				 $scope.thresholdConfigure = function () {
					 $scope.threshold={};
					 $scope.thresholdDefaultList=[{"name":"NORMAL"},{"name":"REQUEST"},{"name":"MAJOR"},{"name":"CRITICAL"}];
				 }
				 
				 $scope.thresholdChange= function (name) {
					 if(name=='NORMAL'){
						$scope.threshold.colorCode='#008000';
					}
					 if(name=='REQUEST'){
						$scope.threshold.colorCode='#009ce8';
					 }
					 if(name=='MAJOR'){
						 $scope.threshold.colorCode='#e10000';	
					 }
					 if(name=='CRITICAL'){
						 $scope.threshold.colorCode='#ff8000';
					 }
				 }
				 
				 $scope.serviceConfigList=[];
				 $scope.serviceConfig={};
				 $scope.serviceDefaultList=[];
				 
				 $scope.getServiceConfigs= function () {
					 ServiceConfig.GetServiceConfigs($scope).success(function(response, status, headers, config){
							$scope.serviceConfigList=response;
						}).error(function(response, status) {
							var errormsg='Unable to fetch User Details ';
							$exceptionHandler(errormsg);
						});
				
				 }
				 
				
				 $scope.serviceConfigure=function(){
					 $scope.serviceDefaultList= [{"serviceName":"WAITER","iconURL":"assets/img/hotel/waiter/default.png"},{"serviceName":"BILL","iconURL":"assets/img/hotel/bill/default.png"},{"serviceName":"WATER","iconURL":"assets/img/hotel/water/default.png"},{"serviceName":"EMPTY_TABLE","iconURL":"assets/img/hotel/table/default.png"}];
				 }
				 
				 $scope.editServiceConfig= function (sc) {
					 $scope.serviceConfig.serviceName=sc.serviceName;
					 $scope.serviceConfig.iconURL=sc.iconURL;
				 }
				 
				 
				 $scope.saveServiceConfig= function (service) {
					 $scope.serviceConfig.serviceName=service.serviceName;
					 $scope.serviceConfig.iconURL=service.iconURL;
						 ServiceConfig.SaveServiceConfig($scope).success(function(response, status, headers, config){
								$scope.serviceConfigList=response;
							}).error(function(response, status) {
								var errormsg='Unable to fetch User Details ';
								$exceptionHandler(errormsg);
							});
				 }
				 
				 $scope.deleteServiceConfig= function (service) {
					 $scope.serviceConfig.serviceName=service.serviceName;
					 $scope.serviceConfig.iconURL=service.iconURL;
					 ServiceConfig.DeleteServiceConfig($scope).success(function(response, status, headers, config){
							$scope.serviceConfigList=response;
						}).error(function(response, status) {
							var errormsg='Unable to fetch User Details ';
							$exceptionHandler(errormsg);
						});
				 }
				 
				 $scope.linkServices=function () {
					 $scope.service={};
					 ServiceConfig.GetServiceConfigs($scope).success(function(response, status, headers, config){
							$scope.serviceConfigList=response;
						}).error(function(response, status) {
							var errormsg='Unable to fetch User Details ';
							$exceptionHandler(errormsg);
						});
				 }
				 
			
				 $scope.linkedServiceList=[];
			     $scope.service={};
		
			 $scope.getAllLinkedServices= function () {
					 ServiceConfig.GetLinkedServices($scope).success(function(response, status, headers, config){
							$scope.linkedServiceList=response;
						}).error(function(response, status) {
							var errormsg='Unable to fetch User Details ';
							$exceptionHandler(errormsg);
						});
					
				 }
				
			 $scope.editLinkedService= function (lservice) {
					 $scope.service.serviceName=lservice.serviceName;
					 $scope.service.serviceCode=lservice.serviceCode;
					 $scope.service.reckonID=lservice.reckonID;
				 }
				 
			 $scope.saveLinkService= function () {
					 ServiceConfig.SaveLinkedService($scope).success(function(response, status, headers, config){
							$scope.linkedServiceList=response;
						}).error(function(response, status) {
							var errormsg='Unable to fetch User Details ';
							$exceptionHandler(errormsg);
						});
				 }
				 
			 $scope.deleteLinkService= function () {
					 ServiceConfig.DeleteLinkedService($scope).success(function(response, status, headers, config){
						 $scope.linkedServiceList=response;
						}).error(function(response, status) {
							var errormsg='Unable to fetch Services Details ';
							$exceptionHandler(errormsg);
						});
				 }
				 
				 
		 $scope.linkedRNotifyList=[];
		 $scope.linkedRNotify={};
		 $scope.getLinkedRNotifyList= function () {
			 LinkRNotifyService.GetAllLinkNotifiers($scope).success(function(response, status, headers, config){
						$scope.linkedRNotifyList=response;
					}).error(function(response, status) {
						var errormsg='Unable to fetch User Details ';
						$exceptionHandler(errormsg);
					});
				
			 }
			
		 $scope.editLinkedRNotify= function (linkedRNotify) {
			 if($scope.notLinkedRIds.length==0){
				 ServiceConfig.GetLinkedServices($scope).success(function(response, status, headers, config){
					 angular.forEach(response, function (value) {
						 if($scope.notLinkedRIds.indexOf(value.reckonID) == -1) {
							 $scope.notLinkedRIds.push(value.reckonID);
						}
						
	        	        });
					}).error(function(response, status) {
						var errormsg='Unable to fetch User Details ';
						$exceptionHandler(errormsg);
					});
			 }
			
				 $scope.linkedRNotify.linkedId=linkedRNotify.linkedId;
				 $scope.linkedRNotify.linkedType=linkedRNotify.linkedType;
				 $scope.linkedRNotify.iconURL=linkedRNotify.iconURL;
				 $scope.linkedRNotify.linkedName=linkedRNotify.linkedName;
				 $scope.linkedRNotify.status=linkedRNotify.status;
				 if(linkedRNotify.notifiers){
				   $scope.linkedRNotify.notifiers=linkedRNotify.notifiers; 
				 }
				
			 }
			 
		 $scope.saveLinkedRNotify= function () {
			 //According to link Type it will select
			 $scope.linkedRNotify.iconURL='assets/img/hotel/table/table-default.png';
			 LinkRNotifyService.LinkedRNotify($scope).success(function(response, status, headers, config){
						$scope.linkedRNotifyList=response;
					}).error(function(response, status) {
						var errormsg='Unable to fetch User Details ';
						$exceptionHandler(errormsg);
					});
			 }
			 
		 $scope.deleteLinkedRNotify= function () {
			 LinkRNotifyService.DeleteLinkedRNotify($scope).success(function(response, status, headers, config){
					 $scope.linkedRNotifyList=response;
					}).error(function(response, status) {
						var errormsg='Unable to fetch Services Details ';
						$exceptionHandler(errormsg);
					});
			 }
		 
		 $scope.linkRNotiy= function () {
			 $scope.linkedRNotify={};
			 ServiceConfig.GetLinkedServices($scope).success(function(response, status, headers, config){
				 angular.forEach(response, function (value) {
					 if($scope.notLinkedRIds.indexOf(value.reckonID) == -1) {
						 $scope.notLinkedRIds.push(value.reckonID);
					}
					
        	        });
				}).error(function(response, status) {
					var errormsg='Unable to fetch User Details ';
					$exceptionHandler(errormsg);
				});
		 }
		 
		 $scope.data=null;
		 $scope.advEdit=false;
		 $scope.saveAdv = function (type) {
			 if( $scope.advEdit=='true'){
				 $scope.advEdit='false';
				 DashboardService.SaveAdv($scope).success(function(response, status, headers, config){
					 $scope.advlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to save Adv'+' Status Code : '+status;
						 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						//alert(errormsg);
						$exceptionHandler(errormsg);
					});
			
			 }else{
				 var form = $('#fileUploadForm')[0];
				 $scope.data = new FormData(form);
				 DashboardService.UploadFile($scope).success(function(response, status, headers, config){
					 $scope.adv.filepath=response.filePath;
					 $scope.adv.filename=response.filename;
					 $scope.adv.fileType=response.fileType;
					 $scope.adv.sequence= $scope.adv.sequence;
					 $scope.adv.isActive=true;
					 $scope.adv.advType='VIDEO';
					 DashboardService.SaveAdv($scope).success(function(response, status, headers, config){
						 $scope.advlist=response;
						}).error(function(response, status) {
							var errormsg='Unable to save Adv'+' Status Code : '+status;
							 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
							//alert(errormsg);
							$exceptionHandler(errormsg);
						});
					 
					}).error(function(response, status) {
						var errormsg='Unable to save updated directories'+' Status Code : '+status;
						$exceptionHandler(errormsg);
					}); 
			 }


		 }
		 
		 
		 $scope.eachAdv = function (adv) {
			 $scope.advEdit='true';
			 $scope.adv={};
			 $scope.adv.id=adv.id;
			 $scope.adv.filepath=adv.filePath;
			 $scope.adv.filename=adv.filename;
			 $scope.adv.fileType=adv.fileType;
			 $scope.adv.sequence= adv.sequence;
			 $scope.adv.isActive=adv.isActive;
			 $scope.adv.advType=adv.advType;
		 }
		 
		 $scope.deleteAdv = function () {
			 DashboardService.DeleteAdv($scope).success(function(response, status, headers, config){
				 $scope.advlist=response;
				}).error(function(response, status) {
					var errormsg='Unable to Delete Adv'+' Status Code : '+status;
					$exceptionHandler(errormsg);
				});
		
		 }
		 
		 $scope.saveAdv = function (type) {
			 if( $scope.advEdit=='true'){
				 $scope.advEdit='false';
				 DashboardService.SaveTextAdv($scope).success(function(response, status, headers, config){
					 $scope.advTextlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to save Adv'+' Status Code : '+status;
						 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						//alert(errormsg);
						$exceptionHandler(errormsg);
					});
			
			 }
		 }
		 
		 
		 
		 $scope.advConfigure = function () {
			 $scope.adv={};
			 $scope.advText={};
		 } 
		 
		 
		 $scope.eachAdvForText= function (adv) {
			 $scope.advEdit='true';
			 $scope.adv={};
			 $scope.adv.id=adv.id;
			 $scope.adv.advType='TEXT';
			 $scope.adv.fileType=adv.advText;
			 $scope.adv.sequence= adv.sequence;
			 $scope.adv.isActive=adv.isActive;
			 
		 }
		 
		 
		 $scope.deleteTextAdv = function () {
			 DashboardService.DeleteTextAdv($scope).success(function(response, status, headers, config){
				 $scope.advTextlist=response;
				}).error(function(response, status) {
					var errormsg='Unable to Delete Adv'+' Status Code : '+status;
					$exceptionHandler(errormsg);
				});
		
		 }
		 
		 
		 
		 
		 $scope.entityList=[];
		 $scope.entity={};
		 $scope.entityDefaultList=[{"name":"RESTAURANT"},{"name":"HOSPITAL"}];
		 $scope.entityAttributeDefaultList=[{"name":"TABLE"}];
		 $scope.entityConfig = function () {
			 $scope.entity={};
			 $scope.entityDefaultList=[{"name":"RESTAURANT"},{"name":"HOSPITAL"}];
		 } 
		 
		 $scope.entityChange= function (name) {
			 if("RESTAURANT"==name){
				 $scope.entityAttributeDefaultList=[{"name":"TABLE"}];
			 }
			 if("HOSPITAL"==name){
				 $scope.entityAttributeDefaultList=[{"name":"ICU"},{"name":"EMERGENCY"},{"name":"NORMAL BED"}];
			 }
		 }
		 
		 $scope.getEntity = function () {
			 DashboardService.GetAllEntity($scope).success(function(response, status, headers, config){
				 $scope.entityList=response;
				}).error(function(response, status) {
					var errormsg='Unable to Delete Adv'+' Status Code : '+status;
					$exceptionHandler(errormsg);
				});
		
		 }
		 
		 $scope.eachEntityDetails= function (attr) {
			 $scope.entity={};
			 $scope.entity.name=attr.name;
			 $scope.entity.attrName=attr.attrName;
		 }
		 
		 
		 $scope.saveEntityDetails= function () {
			 DashboardService.SaveEntity($scope).success(function(response, status, headers, config){
				   $scope.entityList=response;
					}).error(function(response, status) {
						var errormsg='Unable to fetch User Details ';
						$exceptionHandler(errormsg);
					});
			 }
		 
		 
		 $scope.deleteEntityDetails= function () {
			 DashboardService.DeleteEntity($scope).success(function(response, status, headers, config){
				   $scope.entityList=response;
					}).error(function(response, status) {
						var errormsg='Unable to fetch User Details ';
						$exceptionHandler(errormsg);
					});
			 }
		 
		 
			 $scope.viewProfile = function () {
				 $location.path('/profile');
			 }
			 
			 $scope.logOut = function () {
				 $location.path('/logout');
			 }
			 $scope.viewEvent = function () {
				 $location.path('/event');
			 }
			 $scope.$on('eventClikedCount', function (event, args) {
				 $scope.eventCount = args.count;
				 }); 
				 
			 } ]);
}());