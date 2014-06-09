'use strict';

/**
 * SigninController
 * 
 * @constructor
 */
var SigninController = function($scope, $rootScope, $http, $location) {
	$scope.user = {};
 
	$scope.processSignin = function(user) {
		$http.post('signin/processSignin/', user).success(function(data) {
			$location.path("articles");
			$rootScope.currentUser();
		}).error(function(data, status, headers, config) {

		});
	};
};