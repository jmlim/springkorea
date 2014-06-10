'use strict';

/**
 * UserController
 * 
 * @constructor
 */

var UserController = function($rootScope, $scope, $http, $location) {
	$scope.fetchUserList = function() {
		$http.get('signup/userlist.json').success(function(userList) {
			$scope.users = userList;
		});
	};

	$scope.fetchUserList();
};