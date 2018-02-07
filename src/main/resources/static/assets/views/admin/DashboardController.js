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
			 function($scope,$rootScope,$location,$interval,$exceptionHandler,DashboardService) {
			 $scope.reckonlinkedlist = [];	
			 $scope.tableinv={};
			 $scope.tableinv.disabletableno=true;
			 $scope.servicelist = [];
			 $scope.serviceconfg={};
			 $scope.serviceconfg.servcodedisable=true;
			 
			 
			
			 $scope.getAllTables = function () {
				 DashboardService.GetAllTableDetails($scope).success(function(response, status, headers, config){
					 $scope.reckonlinkedlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to get Reckon linked Table Details '+' Status Code : '+status;
						 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						//alert(errormsg);
						$exceptionHandler(errormsg);
					});
			 }
			 
			 $scope.reckonLinkConfigure = function () {
				 $scope.tableinv={};
				 $scope.tableinv.disabletableno=false;
			 }
			 
	
			 
			 $scope.eachReckonLinkDetails = function (rlinked) {
				 $scope.tableinv={};
				 $scope.tableinv.disabletableno=true;
				 $scope.tableinv.tableid=rlinked.tableid;
				 $scope.tableinv.tablename=rlinked.tablename;
				 $scope.tableinv.reckonid=rlinked.reckonid;
				 $scope.tableinv.status=rlinked.status;
			 }
			 
			 $scope.updateReckonLinkDetails = function () {
				 DashboardService.UpdateReckonLinkd($scope).success(function(response, status, headers, config){
					 $scope.reckonlinkedlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to Update Reckon Linked '+' Status Code : '+status;
						$exceptionHandler(errormsg);
					});
			
			 }
			 
			 $scope.deleteReckonLinkDetails = function () {
				 DashboardService.DeleteReckonLinkd($scope).success(function(response, status, headers, config){
					 $scope.reckonlinkedlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to Delete Reckon Linked '+' Status Code : '+status;
						$exceptionHandler(errormsg);
					});
			
			 }
			 
			 
			 $scope.getAllServiceDetails = function () {
				 DashboardService.GetAllServiceDetails($scope).success(function(response, status, headers, config){
					 $scope.servicelist=response;
					}).error(function(response, status) {
						var errormsg='Unable to get Reckon linked Table Details '+' Status Code : '+status;
						 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						//alert(errormsg);
						$exceptionHandler(errormsg);
					});
			 }
			 
			 $scope.eachServiceDetails = function (service) {
				 $scope.serviceconfg={};
				 $scope.serviceconfg.servcodedisable=true;
				 $scope.serviceconfg.id=service.id;
				 $scope.serviceconfg.servicename=service.servicename;
				 $scope.serviceconfg.servicecode=service.servicecode;
				 $scope.serviceconfg.threshold=service.threshold;
				 $scope.serviceconfg.iconName=service.iconName;
			 }
			
			 $scope.serviceConfigure = function () {
				 $scope.serviceconfg={};
				 $scope.serviceconfg.servcodedisable=false;
			 }
			 
			 $scope.saveServiceDetails = function () {
				 DashboardService.SaveServiceDetails($scope).success(function(response, status, headers, config){
					 $scope.servicelist=response;
					}).error(function(response, status) {
						var errormsg='Unable to get Reckon linked Table Details '+' Status Code : '+status;
						 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						//alert(errormsg);
						$exceptionHandler(errormsg);
					});
			 }
			 
			
			 
			 $scope.deleteServiceDetails = function () {
				 DashboardService.DeleteServiceDetails($scope).success(function(response, status, headers, config){
					 $scope.servicelist=response;
					}).error(function(response, status) {
						var errormsg='Unable to Delete Reckon Linked '+' Status Code : '+status;
						$exceptionHandler(errormsg);
					});
			
			 }
			 
			 } ]);
}());