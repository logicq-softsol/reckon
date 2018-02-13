(function () {
	'use strict';
	angular.module('reckonApp').factory('ThresholdService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetAllThreshold: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetAllThresholdURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			SaveThreshold: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.SaveThresholdURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.threshold
				})
			},
			
			DeleteThreshold: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.DeleteThresholdURL+"/"+threshold.thresholdId,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
		}
	}]);
}());