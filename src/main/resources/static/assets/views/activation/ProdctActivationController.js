(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'ProdctActivationController',
			[
					'$scope',
					'$rootScope',
					'$location',
					'$exceptionHandler',
					'ProdctActivationService',
					function($scope, $rootScope, $location, $exceptionHandler,ProdctActivationService) {
						$scope.activationDetails={};
						$scope.activationDetails.userDetails={};
						$scope.activationDetails.companyDetails={};
						 $scope.validateProduct = function () {
							 ProdctActivationService.ValidateProduct($scope).success(function(response, status, headers, config){
								 if(response.isActive){
									 $location.path('/login');
								 }else{
									 $location.path('/activate');
								 }
								}).error(function(response, status) {
									 $location.path('/activate');
									var errormsg='Check Product validation '+' Status Code : '+status;
									$exceptionHandler(errormsg);
									
								});
						 }
						 
						 $scope.activateProduct = function () {
							 ProdctActivationService.ActivateProduct($scope).success(function(response, status, headers, config){
									 $location.path('/login');
								}).error(function(response, status) {
									 $location.path('/activate');
									var errormsg='Check Product validation '+' Status Code : '+status;
									$exceptionHandler(errormsg);
									
								});
						 }

					} ]);
}());