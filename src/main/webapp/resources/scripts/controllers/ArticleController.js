'use strict';

/**
 * ArticleController
 * 
 * @constructor
 */
var ArticleController = function($scope, $http) {
	$scope.article = {};
	$scope.editMode = false;
	$scope.writeMode = false;

    $scope.fetchArticleList = function() {
        $http.get('article/jmlim/articlelist.json').success(function(articleList){
            $scope.articles = articleList;
        });
    };

    $scope.addNewArticle = function(article) {
        $http.post('article/jmlim/addArticle/',article).success(function() {
            $scope.fetchArticleList();
            $scope.writeMode = false;
            $scope.article = {};
        });
    };

    $scope.updateArticle = function(article) {
    	 $http.put('article/jmlim/updateArticle/',article).success(function() {
             $scope.fetchArticleList();
             $scope.editMode = false;
             $scope.writeMode = false;
             $scope.article = {};
         });
    };
    
    $scope.removeArticle = function(id) {
        $http.delete('article/jmlim/removeArticle/'+id).success(function() {
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

    $scope.fetchArticleList();
};