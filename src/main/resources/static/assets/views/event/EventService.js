(function () {
	'use strict';
	angular.module('reckonApp').factory('EventService', ['$http','AppConstants',function ($http,AppConstants ){

		return {


			GetCurrentAdv: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetCurrentAdvURL+'/'+$scope.advindex,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},		
			GetAllEvents: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.EventsURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},		
		}
		
	}]);
}());