'use strict';

var SpringKoreaApp = {};

var App = angular.module('SpringKoreaApp', [ 'ngRoute',
		'SpringKoreaApp.factory' ]);

// Declare app level module which depends on filters, and services
App.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/signup', {
		templateUrl : 'signup/signup',
		controller : SignupController
	});

	$routeProvider.when('/signin', {
		templateUrl : 'signin/signin',
		controller : SigninController
	});

	$routeProvider.when('/articles', {
		templateUrl : 'article/list',
		controller : ArticleController
	});

	$routeProvider.otherwise({
		redirectTo : 'articles'
	});
} ]).controller('mainController', function($scope, $rootScope, $http, $location) {
	$rootScope.userSession = {};

	/**
	 * 현재 유저를 호출.
	 * */
	$rootScope.currentUser = function() {
		$http.get('signup/currentUser').success(function(currentUser) {
			$rootScope.userSession = currentUser;
		});
	};
	
	/**
	 * 로그아웃 시 실행.
	 * */
	$rootScope.processLogout = function(user) {
		$http.get('signin/processLogout/').success(function() {
			$location.path("articles");
			$rootScope.userSession = {};
			$location.path("signin");
		}).error(function(data, status, headers, config) {

		});
	};
	$rootScope.currentUser();
});
