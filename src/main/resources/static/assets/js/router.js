(function() {

	angular.module('reckonApp').config(
			function($stateProvider, $urlRouterProvider) {
				$urlRouterProvider.otherwise("/login");
				$stateProvider.state('login', {
					url : "/login",
					templateUrl : "assets/views/login/login.html",
					controller : 'LoginController'
				}), $stateProvider.state('logout', {
					url : "/logout",
					templateUrl : "assets/views/login/login.html",
					controller : 'LoginController'
				}), $stateProvider.state('forgetpassword', {
					url : "/forgetpassword",
					templateUrl : "assets/views/login/forgetpassword.html",
					controller : 'LoginController'
				}), $stateProvider.state('dashboard', {
					url : "/dashboard",
					templateUrl : "assets/views/admin/dashboard.html",
					controller : 'LoginController'
				})
			});
})();