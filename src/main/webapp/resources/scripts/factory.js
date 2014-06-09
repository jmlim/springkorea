'use strict';

/* Filters */

var AppFactory = angular.module('SpringKoreaApp.factory', []);

AppFactory.factory('UserSession', function($http) {
	var user = {};
	return {
		currentUser : function() {
	    	 $http.get('signup/currentUser').success(function(currentUser){
	    		 user = currentUser;
	         });
	    	 return user;
		}
	};
});
