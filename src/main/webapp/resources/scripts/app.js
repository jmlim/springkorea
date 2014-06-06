'use strict';

var SpringKoreaApp = {};

var App = angular.module('SpringKoreaApp', ['ngRoute']);

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
} ]);
