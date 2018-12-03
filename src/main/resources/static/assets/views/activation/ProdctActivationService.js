(function () {
	'use strict';
	angular.module('reckonApp').factory('ProdctActivationService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			CreateUserInfo: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.loginURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json','AUTH-TOKEN': '' ,'userName':$scope.username ,'password':$scope.password} ,
					dataType :'json',
					data : ''
				})
			},
			CreateCopmanyInfo: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.UpdateserURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.userdetail
				})
			},
			
			ActivateProduct: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.ActivateProductURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.activationDetails
				})
			},
			
			ValidateProduct: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.ValidateProductURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
		}
	}]);
}());