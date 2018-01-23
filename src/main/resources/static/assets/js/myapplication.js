/**
 * 
 */

(function () {
    'use strict';
    
   angular.module('reckonApp', ['ui.router','ngWebsocket']).constant('AppConstants', {
      'hostName':'http://127.0.0.1:8080/', 
     //'hostName':'http://getpay.co.in',
	 //'hostName':'http://45.113.136.130:8167',
	//  'hostPort': '8090' ,
	 //  'hostPort': '8167' ,
	//   'applicationName' : '/mlmlogicq' ,
	   'get' : 'GET' ,  
	   'post' : 'POST' , 
	   'loginURL' : '/api/login'
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