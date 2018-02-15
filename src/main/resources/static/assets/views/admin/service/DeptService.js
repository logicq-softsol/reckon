(function () {
	'use strict';
	angular.module('reckonApp').factory('DeptService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetAllDept: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetAllDeptURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			
			SaveDept: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.SaveDeptURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.department
				})
			},
			
			DeleteDept: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.DeleteDeptURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.department
				})
			},
		}
	}]);
}());