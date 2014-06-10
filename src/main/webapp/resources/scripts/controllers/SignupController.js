'use strict';

/**
 * SignupController
 * 
 * @constructor
 */
var SignupController = function($rootScope, $scope, $http, $location) {
	$scope.user = {};
	$scope.editMode = false;

    $scope.fetchUserList = function() {
        $http.get('signup/userlist.json').success(function(userList){
            $scope.users = userList;
        });
    };

    $scope.currentUser = function() {
    	$scope.user = $rootScope.userSession;
		if($scope.user.uid) {
			$scope.editMode = true;
		}
    };

    $scope.addNewUser = function(user) {
        $http.post('signup/addUser/',user).success(function() {
            // $scope.fetchUserList();
        	 $scope.currentUser();
        	 $location.path("signin");
        });
    };

    $scope.updateUser = function(user) {
    	 $http.put('signup/updateUser/',user).success(function() {
             // $scope.fetchUserList();
    		 $scope.currentUser();
    		 $location.path("articles");
         });
    };
    
    $scope.removeUser = function(uid) {
        $http.delete('signup/removeUser/'+uid).success(function() {
            // $scope.fetchUserList();
        	 $location.path("signin");
        });
    };

    $scope.editUser = function(user) {
        $scope.user = user;
        $scope.editMode = true;
    };

    $scope.currentUser();
};