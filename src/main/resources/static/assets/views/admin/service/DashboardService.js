(function () {
	'use strict';
	angular.module('reckonApp').factory('DashboardService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			GetReckonLinkDetails: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetReckonLinkdURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			UpdateReckonLinkd: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.UpdateReckonLinkURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.tableinv
				})
			},
			
			DeleteReckonLinkd: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.DeleteReckonLinkdURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.tableinv
				})
			},
			
			GetAllServiceDetails: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetAllServiceDetailsURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},	
			GetServiceDetailsForName: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetServiceDetailsForNameURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			
			GetServiceDetailsForCode: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.GetserviceDetailsForCodeURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			
			SaveServiceDetails: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.SaveServiceDetailsURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.serviceconfg
				})
			},		
			DeleteServiceDetails: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.DeleteServiceDetailsURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.serviceconfg
				})
			},			
			GetAllAdv: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.AdvURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			GetAllAdvType: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.AdvURL+"/"+ $scope.advType,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			SaveAdv: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.AdvURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.adv
				})
			},	
				
			DeleteAdv: function ($scope) {
				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.AdvURL+"/"+$scope.adv.advId,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},		
			
			
			SaveTextAdv: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.AdvURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.advText
				})
			},	
				
			DeleteTextAdv: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.AdvURL+"/"+$scope.advText.advId,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},			
			
			UploadFile: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+"api/upload",
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': undefined} ,
					data : $scope.data
				})
			},	
			
			GetAllEntity: function ($scope) {

				return  $http({
					method: 'GET',
					url:AppConstants.hostName+AppConstants.EntityURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},
			SaveEntity: function ($scope) {
				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.EntityURL,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : $scope.entity
				})
			},	
				
			DeleteEntity: function ($scope) {
				return  $http({
					method: 'DELETE',
					url:AppConstants.hostName+AppConstants.EntityURL+"/"+$scope.entity.attrName,
					//url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json'} ,
					dataType :'json',
					data : ''
				})
			},		
			
			
		}
	}]);
}());