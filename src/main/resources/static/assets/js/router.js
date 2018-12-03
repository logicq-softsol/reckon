(function() {

	angular.module('reckonApp').config(
			function($stateProvider, $urlRouterProvider) {
				$urlRouterProvider.otherwise("/activate");
				$stateProvider.state('activate', {
					url : "/activate",
					templateUrl : "assets/views/activation/productActivation.html",
					controller : 'ProdctActivationController'
				}),
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
					controller : 'DashboardController'
				}), $stateProvider.state('profile', {
					url : "/profile",
					templateUrl : "assets/views/profile/profile.html",
					controller : 'LoginController'
				}), $stateProvider.state('event', {
					url : "/event",
					templateUrl : "assets/views/event/event.html",
					controller : 'EventController'
				})
			});
})();