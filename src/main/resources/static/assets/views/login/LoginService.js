(function () {
	'use strict';
	angular.module('reckonApp').factory('LoginService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			Login: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.loginURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json','AUTH-TOKEN': '' ,'userName':$scope.username ,'password':$scope.password} ,
					dataType :'json',
					data : ''
				})
			},
			UpdateUser: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.UpdateserURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.userdetail
				})
			},
			
			GetUserDetails: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetUserDetailsURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
		}
	}]);
}());