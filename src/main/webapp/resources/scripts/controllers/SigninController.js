'use strict';

/**
 * SigninController
 * 
 * @constructor
 */
var SigninController = function($scope, $http) {
	$scope.user = {};

    $scope.processSignin = function(user) {
        $http.post('signin/processSignin/',user).success(function() {

        }).error(function(data, status, headers, config) {

        });
    };
};