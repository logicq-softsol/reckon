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
				 $scope.userdetail.eventtext="Update profile";
				 $scope.userdetail.profileprop=null;
				 
		$scope.login = function () {
			LoginService.Login($scope).success(function(response, status, headers, config){
				$scope.userdetail=response;
				$location.path('/dashboard');
				//$rootScope.busyTableDetails=response.tableDetails;
				//$rootScope.$broadcast('loginTableDetails');
			}).error(function(response, status) {
				var errormsg='Unable to Login Check setting or Loging Details ';
				 //$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
				$exceptionHandler(errormsg);
				$location.path('/login');
			});
    };
    
    $scope.displayProfile = function () {
    	LoginService.GetUserDetails($scope).success(function(response, status, headers, config){
			$scope.userdetail=response;
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