/**
 * 
 */

(function () {
    'use strict';
    
   angular.module('reckonApp', ['ui.router','ngMaterial','ngMessages','ngSanitize','com.2fdevs.videogular',
                                'com.2fdevs.videogular.plugins.controls']).constant('AppConstants', {
      'hostName':'http://127.0.0.1:8080/', 
	   'get' : 'GET' ,  
	   'post' : 'POST' , 
	   'loginURL' : 'api/login',
	   'UpdateserURL' : 'api/updateUserDetails',
	   'GetUserDetailsURL' : 'api/userDetails',
	   'SaveThresholdURL':'api/reckon/threshold',
	   'GetAllThresholdURL':'api/reckon/thresolds',
	   'GetServiceConfigsURL':'api/reckon/service/configs',
	   'OperServiceConfigURL':'api/reckon/service/config',
	   'GetLiknedServiceURL':'api/reckon/service/links',
	   'OperLinkedServiceURL':'api/reckon/service/link',
	   'OperLinkedRNotifyURL':'api/rnotify/link',
	   'EventsURL':'/api/rnotify/clicked',
	   'AdvURL':'api/adv',
	   'EntityURL':'api/entity',
	   'ValidateProductURL':'api/reckon/product/validateProduct',
	   'ActivateProductURL':'api/reckon/product/activate'
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
