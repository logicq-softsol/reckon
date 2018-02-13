/**
 * 
 */

(function () {
    'use strict';
    
   angular.module('reckonApp', ['ui.router','ngMaterial','ngMessages']).constant('AppConstants', {
      'hostName':'http://127.0.0.1:8080/', 
     //'hostName':'http://getpay.co.in',
	 //'hostName':'http://45.113.136.130:8167',
	//  'hostPort': '8090' ,
	 //  'hostPort': '8167' ,
	//   'applicationName' : '/mlmlogicq' ,
	   'get' : 'GET' ,  
	   'post' : 'POST' , 
	   'loginURL' : 'api/login',
	   'UpdateserURL' : 'api/updateUserDetails',
	   'GetUserDetailsURL' : 'api/userDetails',
	   'GetAllTablesURL' : 'api/alltables',
	   'GetReckonLinkdURL' : 'api/linkedDevices',
	   'UpdateReckonLinkURL' : 'api/linkdTableAndDevice',
	   'DeleteReckonLinkdURL' : 'api/deleteLinkedTableandDevice',
	   'GetAllServiceDetailsURL':'api/allserviceDetails',
	   'SaveServiceDetailsURL':'api/saveServiceDetails',
	   'GetServiceDetailsForNameURL':'api/serviceDetailsForName',
	   'GetserviceDetailsForCodeURL':'api/serviceDetailsForCode',
	   'DeleteServiceDetailsURL':'api/deleteServiceDetails',
	   'GetAllAdvURL':'api/allAdv',
	   'SaveAdvURL':'api/AdvConfig',
	   'DeleteAdvURL':'api/deleteAdvConfig',
	   'GetDirectoryDetailsURL':'api/directories',
	   'SaveDirectoryDetailsURL':'api/saveDirectories',
	   'GetCurrentAdvURL':'api/advPlay',
	   'GetAllThresholdURL':'/api/threshold/allThresolds',
	   'SaveThresholdURL':'/api/threshold/threshold',
	   'DeleteThresholdURL':'/api/threshold/removeThreshold',
	   'GetAllDeptURL':'/api/dept/allDept',
	   'SaveDeptURL':'/api/dept/dept',
	   'DeleteDeptURL':'/api/dept/removeDept',
	   'GetAllServiceCodeURL':'/api/service/allServiceCode',
	   'SaveServiceCodeURL':'/api/service/serviceCode',
	   'DeleteServiceCodeURL':'/api/service/removeServiceCode'
	   
	}).directive('ngConfirmClick', [
	                                   function(){
	                                       return {
	                                           link: function (scope, element, attr) {
	                                               var msg = attr.ngConfirmClick || "Are you sure?";
	                                               var clickAction = attr.confirmedClick;
	                                               element.bind('click',function (event) {
	                                                   if ( window.confirm(msg) ) {
	                                                       scope.$eval(clickAction)
	                                                   }
	                                                   else{
	                                                	   
	                                                   }
	                                               });
	                                           }
	                                       };
	                               }]);
}());
