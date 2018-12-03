(function () {
	'use strict';
	angular.module('reckonApp').factory('LinkRNotifyService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetAllLinkNotifiers: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.OperLinkedRNotifyURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			LinkedRNotify: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.OperLinkedRNotifyURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.linkedRNotify
				})
			},
			
			UpdateLinkedRNotify: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.OperLinkedRNotifyURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.linkedRNotify
				})
			},
			DeleteLinkedRNotify: function ($scope) {

				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.OperLinkedRNotifyURL+'/'+$scope.linkedRNotify.linkedId,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
		}
	}]);
}());