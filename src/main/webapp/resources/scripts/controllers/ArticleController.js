'use strict';

/**
 * ArticleController
 * 
 * @constructor
 */
var ArticleController = function($rootScope, $scope, $http, $routeParams, UserSession) {
	$scope.article = {};
	$scope.editMode = false;
	$scope.writeMode = false;
	$scope.contentMode = false;

	var ownerId = $routeParams.ownerId;
	var categoryId = $routeParams.categoryId;

	if(ownerId) {
		$rootScope.currentOwnerId = ownerId;
	} else {
		ownerId = UserSession.uid;
		$rootScope.currentOwnerId = ownerId;
	}

	$scope.fetchArticleList = function() {
        $http.get('article/'+ownerId+'/'+categoryId+'/articlelist.json').success(function(articleList){
            $scope.articles = articleList;
        });
    };

    $scope.addNewArticle = function(article) {
        $http.post('article/'+ownerId+'/'+categoryId+'/addArticle/',article).success(function() {
            $scope.fetchArticleList();
            $scope.writeMode = false;
            $scope.article = {};
        });
    };

    $scope.updateArticle = function(article) {
    	 $http.put('article/'+ownerId+'/'+categoryId+'/updateArticle/',article).success(function() {
             $scope.fetchArticleList();
             $scope.editMode = false;
             $scope.writeMode = false;
             $scope.article = {};
         });
    };
    
    $scope.removeArticle = function(id) {
        $http.delete('article/'+ownerId+'/'+categoryId+'/removeArticle/'+id).success(function() {
            $scope.fetchArticleList();
        });
    };

    $scope.writeArticle = function() {
    	$scope.writeMode = true;
    	$scope.article = {};
    };

    $scope.editArticle = function(article) {
        $scope.article = article;
        $scope.writeMode = true;
        $scope.editMode = true;
    };

    $scope.contentArticle = function(article) {
    	$scope.article = article;
    	$scope.contentMode = true;
    };
    
    $scope.listArticle = function() {
    	$scope.article = {};
    	$scope.contentMode = false;
    };

    $scope.fetchArticleList();
};