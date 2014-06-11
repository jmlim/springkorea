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
			$location.path("index/" + user.uid);
			$rootScope.currentOwnerId = user.uid;
			$rootScope.currentUser();
		}).error(function(data, status, headers, config) {

		});
	};
};