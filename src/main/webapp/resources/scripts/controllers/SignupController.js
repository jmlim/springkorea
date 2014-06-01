'use strict';

/**
 * SignupController
 * 
 * @constructor
 */
var SignupController = function($scope, $http) {
	$scope.user = {};
	$scope.editMode = false;

    $scope.fetchUserList = function() {
        $http.get('signup/userlist.json').success(function(userList){
            $scope.users = userList;
        });
    };

    $scope.addNewUser = function(user) {
        $http.post('signup/addUser/',user).success(function() {
            $scope.fetchUserList();
        });
    };

    $scope.updateUser = function(user) {
    	 $http.put('signup/updateUser/',user).success(function() {
             $scope.fetchUserList();
             $scope.editMode = false;
             $scope.user = {};
         });
    };
    
    $scope.removeUser = function(uid) {
        $http.delete('signup/removeUser/'+uid).success(function() {
            $scope.fetchUserList();
        });
    };

    $scope.editUser = function(user) {
        $scope.user = user;
        $scope.editMode = true;
    };

    $scope.fetchUserList();
};