/**
 * 
 */

(function() {
	'use strict';
	angular.module('reckonApp').config(
			[
					'$httpProvider',
					'$provide',
					function($httpProvider, $provide) {
						$provide.decorator("$exceptionHandler", function(
								$delegate, $injector) {
							return function(exception, cause) {
								var rootScope = $injector.get("$rootScope");
								//$('#preloader').hide();
								//$('#displaydata').show();
								$delegate(exception, cause);
								// Not requird as added error message
								// alert(cause+'\n'+exception);
							};
						});

					} ]);

}());