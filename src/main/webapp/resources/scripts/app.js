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

	$routeProvider.when('/index', {
		templateUrl : 'main/main'
	});

	$routeProvider.otherwise({
		redirectTo : 'index'
	});
} ]).controller('mainController',
		function($scope, $rootScope, $http, $location) {
			// 루트에 항상 세션정보가 담겨 있음.
			$rootScope.userSession = {};

			// 접근한 블로그의 정보.
			$rootScope.accessBlogUser = {};
			
			$rootScope.targetId = null;
			/**
			 * 현재 로그인이 되어 있는 유저를 호출.
			 */
			$rootScope.currentUser = function() {
				$http.get('signup/currentUser').success(function(currentUser) {
					$rootScope.userSession = currentUser;
					$rootScope.accessBlog(currentUser, true);
				});
			};

			/**
			 * 로그아웃 시 실행.
			 */
			$rootScope.processLogout = function(user) {
				$http.get('signin/processLogout/').success(function() {
					$rootScope.userSession = {};
					$location.path("index");
				}).error(function(data, status, headers, config) {

				});
			};

			/**
			 * 접근할 블로그 설정.
			 * */
			$rootScope.accessBlog = function(user, refresh) {
				if(refresh) {
					 $http.get('signup/getAccessBlogUser').success(function(accessBlogUser) {
						$rootScope.accessBlogUser = accessBlogUser;

						if ($rootScope.accessBlogUser) {
							$rootScope.targetId = $rootScope.accessBlogUser.uid;
						}

						if (!$rootScope.targetId) {
							$rootScope.targetId = $rootScope.userSession.uid;
						}

						$location.path("index");
					 });
				} else {
					 $http.post('signup/setAccessBlogUser', user).success(function(accessBlogUser) {
						$rootScope.accessBlogUser = accessBlogUser;

						if ($rootScope.accessBlogUser) {
							$rootScope.targetId = $rootScope.accessBlogUser.uid;
						}

						if (!$rootScope.targetId) {
							$rootScope.targetId = $rootScope.userSession.uid;
						}

						$location.path("index");
					});
				}
				/*$rootScope.accessBlogUser = user;

				if($rootScope.accessBlogUser) {
					$rootScope.targetId = $rootScope.accessBlogUser.uid;
				}

				if(!$rootScope.targetId) {
					$rootScope.targetId = $rootScope.userSession.uid;
				}
				
				$location.path("index");*/
			};

			$rootScope.currentUser();
});