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

	$routeProvider.when('/users', {
		templateUrl : 'signup/users',
		controller : UserController
	});

	$routeProvider.when('/articles', {
		templateUrl : 'article/list',
		controller : ArticleController
	});

	$routeProvider.when('/articles/:ownerId', {
		templateUrl : 'article/list',
		controller : ArticleController
	});

	$routeProvider.when('/articles/:ownerId/:categoryId', {
		templateUrl : 'article/list',
		controller : ArticleController
	});

	$routeProvider.when('/index/:ownerId', {
		templateUrl : 'main/main',
		controller: 'MainController'
	});

	$routeProvider.when('/index', {
		templateUrl : 'main/main',
		controller: 'MainController'
	});

	$routeProvider.otherwise({
		redirectTo : 'index'
	});
} ]).controller('MainController',
		function($scope, $rootScope, $http, $location, $routeParams) {
			// 루트에 항상 세션정보가 담겨 있음.
			$rootScope.userSession = {};

			/**
			 * 현재 로그인이 되어 있는 유저를 호출.
			 */
			$rootScope.currentUser = function() {
				$http.get('signup/currentUser').success(function(currentUser) {
					$rootScope.userSession = currentUser;
					var ownerId = $routeParams.ownerId;
					if(ownerId) {
						$rootScope.currentOwnerId = ownerId;
					} else {
						ownerId = $rootScope.userSession.uid;
						$rootScope.currentOwnerId = ownerId;
					}
				});
			};

			/**
			 * 로그아웃 시 실행.
			 */
			$rootScope.processLogout = function(user) {
				$http.get('signin/processLogout/').success(function() {
					$rootScope.userSession = {};
					$rootScope.currentOwnerId = null;
					$location.path("index");
				}).error(function(data, status, headers, config) {

				});
			};

			$rootScope.currentUser();
			
});