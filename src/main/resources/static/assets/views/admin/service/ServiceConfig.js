(function () {
	'use strict';
	angular.module('reckonApp').factory('ServiceConfig', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetServiceConfigs: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetServiceConfigsURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			SaveServiceConfig: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.OperServiceConfigURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.serviceConfig
				})
			},
			UpdateServiceConfig: function ($scope) {

				return  $http({
					method: 'PUT',
					url:AppConstants.hostName+AppConstants.OperServiceConfigURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.serviceConfig
				})
			},
			
			DeleteServiceConfig: function ($scope) {

				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.OperServiceConfigURL+"/"+$scope.serviceName,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data :''
				})
			},
			
			UploadIcon: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+"api/uploadServiceIcon",
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': undefined} ,
					data : $scope.data
				})
			},		
			GetLinkedServices: function ($scope) {
				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetLiknedServiceURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			SaveLinkedService: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.OperLinkedServiceURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.service
				})
			},
			UpdateLinkedService: function ($scope) {

				return  $http({
					method: 'PUT',
					url:AppConstants.hostName+AppConstants.OperLinkedServiceURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.service
				})
			},
			
			DeleteLinkedService: function ($scope) {

				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.OperLinkedServiceURL+"/"+$scope.service.serviceCode,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data :''
				})
			},
			
		}
	}]);
}());