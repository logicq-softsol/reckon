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
			 $scope.advlist=[];
			 $scope.adv={};
			 $scope.globalconfigs=[];
			 $scope.dconfig={};
			 $scope.dicTypeList=[{"displayText":"R-NOTIFY"},{"displayText":"SERVICE"},{"displayText":"ADVERTISEMENT"}];
			 
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
				 $scope.tableinv.iconname=rlinked.iconname;
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
			 
			 
			 $scope.getAllAdv = function () {
				 DashboardService.GetAllAdv($scope).success(function(response, status, headers, config){
					 $scope.advlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to get All list of Adv'+' Status Code : '+status;
						 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						//alert(errormsg);
						$exceptionHandler(errormsg);
					});
			 }
			 
			 $scope.eachAdv = function (adv) {
				 $scope.adv={};
				 $scope.adv.filename=adv.filename;
				 $scope.adv.id=adv.id;
				 $scope.adv.sequence=adv.sequence;
			 }
			 
			 $scope.saveAdv = function () {
				 DashboardService.SaveAdv($scope).success(function(response, status, headers, config){
					 $scope.advlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to save Adv'+' Status Code : '+status;
						 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						//alert(errormsg);
						$exceptionHandler(errormsg);
					});
			 }
			 
			 $scope.deleteAdv = function () {
				 DashboardService.DeleteAdv($scope).success(function(response, status, headers, config){
					 $scope.advlist=response;
					}).error(function(response, status) {
						var errormsg='Unable to Delete Adv'+' Status Code : '+status;
						$exceptionHandler(errormsg);
					});
			
			 }
			 $scope.advConfigure = function () {
				 $scope.adv={};
			 } 
			 
			 $scope.viewProfile = function () {
				 $location.path('/profile');
			 }
			 
			 $scope.logOut = function () {
				 $location.path('/logout');
			 }
			 
			
			 
			 $scope.getDirectoryDetails= function () {
				 DashboardService.GetDirectoryDetails($scope).success(function(response, status, headers, config){
					 $scope.globalconfigs=response;
					}).error(function(response, status) {
						var errormsg='Unable to get All list of directories'+' Status Code : '+status;
						 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						//alert(errormsg);
						$exceptionHandler(errormsg);
					});
			 }
			 
			 $scope.saveDirectoryDetails = function () {
				 DashboardService.SaveDirectoryDetails($scope).success(function(response, status, headers, config){
					 $scope.globalconfigs=response;
					}).error(function(response, status) {
						var errormsg='Unable to save updated directories'+' Status Code : '+status;
						$exceptionHandler(errormsg);
					});
			 }
			 
			 $scope.eachDirectoryDetails = function (gconfig) {
				 $scope.dconfig.displayText=gconfig.displayText;
				 $scope.dconfig.filePath=gconfig.filePath;
				 $scope.dconfig.type=gconfig.type;
			 }
			 
			 $scope.onChangeDirectoryType= function (dconfig) {
				 $scope.dconfig.type=dconfig.displayText;
				 $scope.dconfig.displayText=dconfig.displayText;
			 }
				 
			 } ]);
}());