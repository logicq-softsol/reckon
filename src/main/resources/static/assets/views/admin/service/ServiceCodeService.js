(function () {
	'use strict';
	angular.module('reckonApp').factory('ServiceCodeService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetAllServiceCode: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetAllServiceCodeURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			SaveServiceCode: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.SaveServiceCodeURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.servicecode
				})
			},
			
			DeleteServiceCode: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.DeleteServiceCodeURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data :$scope.servicecode
				})
			},
		}
	}]);
}());