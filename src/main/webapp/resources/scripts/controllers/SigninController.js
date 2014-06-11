'use strict';

/**
 * SigninController
 * 
 * @constructor
 */
var SigninController = function($rootScope, $scope, $http, $location) {
	$scope.user = {};

	$scope.processSignin = function(user) {
		$http.post('signin/processSignin/', user).success(function(data) {
			$location.path("index");
			$rootScope.currentUser();
		}).error(function(data, status, headers, config) {

		});
	};
};