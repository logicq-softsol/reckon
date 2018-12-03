(function() {
	'use strict';
	angular.module('reckonApp').controller(
			'LoginController',
			[
			 '$scope',
			 '$rootScope',
			 '$location',
			 '$exceptionHandler',
			 'LoginService',
			 function($scope,$rootScope,$location,$exceptionHandler,LoginService) {
				 $scope.userdetail={};
				 $scope.companyDetails={};
				 $scope.productDetails={};
				 $scope.userdetail.eventtext="Update profile";
				 $scope.userdetail.profileprop=null;
				 $scope.username='';
				 $scope.password='';
				 
		$scope.login = function () {
			 $scope.userdetail.username= $scope.username;
			 $scope.userdetail.password= $scope.password;
			LoginService.Login($scope).success(function(response, status, headers, config){
				$scope.userdetail=response.userDetails;
				$scope.companyDetails=response.companyDetails;
				$scope.productDetails=response;
				$location.path('/dashboard');
			}).error(function(response, status) {
				$location.path('/login');
				var errormsg='Unable to Login Check setting or Loging Details ';
				$exceptionHandler(errormsg);
				
			});
    };
    
    $scope.displayProfile = function () {
    	LoginService.GetUserDetails($scope).success(function(response, status, headers, config){
			$scope.userdetail=response.userDetails;
			 $scope.companyDetails=response.companyDetails;
			 $scope.productDetails=response;
			 $scope.productDetails.activateDate=new Date(response.activateDate);
			 $scope.userdetail.eventtext="Update profile";
			 $scope.userdetail.profileprop=true;
			
		}).error(function(response, status) {
			var errormsg='Unable to fetch User Details ';
			$exceptionHandler(errormsg);
		});
    }
    
    $scope.performProfileEvent= function () {
		 $scope.userdetail.profileprop=false;
		 if($scope.userdetail.eventtext=="Save Changes"){
			 LoginService.UpdateUser($scope).success(function(response, status, headers, config){
				 $scope.userdetail.eventtext="Update profile";
				 $scope.userdetail.profileprop=true;
				}).error(function(response, status) {
					var errormsg='Unable to update user profile';
					$exceptionHandler(errormsg);
			});
		 }
		 $scope.userdetail.eventtext="Save Changes";
		
	
	 }
		
	 $scope.performProfileEventReset=function () {
		 $scope.userdetail.eventtext="Update profile";
		 $scope.userdetail.profileprop=true;
	
	 }
    
	 $scope.updateCompDetails=function () {
		 
	 }
	 $scope.viewDashboard = function () {
			$location.path('/dashboard');
	 }
	 
	 $scope.saveCompDetails=function () {
		 LoginService.UpdateUser($scope).success(function(response, status, headers, config){
			 $scope.userdetail.eventtext="Update profile";
			 $scope.userdetail.profileprop=true;
			}).error(function(response, status) {
				var errormsg='Unable to update user profile';
				$exceptionHandler(errormsg);
		});
	 }
	 
	 
			 } ]);
}());