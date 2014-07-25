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
	$scope.currentPageNum = 0;
	$scope.pageCountList = [];

	var ownerId = $routeParams.ownerId;
	var categoryId = $routeParams.categoryId;

	if(ownerId) {
		$rootScope.currentOwnerId = ownerId;
	} else {
		ownerId = UserSession.uid;
		$rootScope.currentOwnerId = ownerId;
	}

	$scope.fetchArticleList = function(pageNum, pageCount) {
		if(!pageNum) {
			 pageNum = 0;
		}

		if(pageNum >= 0 && !pageCount || pageNum >= 0 && pageNum < pageCount) {
	       $http.get('article/'+ownerId+'/'+categoryId+'/'+pageNum+'/articlelist.json').success(function(articleList) {
	    	   	 $scope.currentPageNum = pageNum;
	            $scope.articles = articleList;
	        });
		}
    };

    // pageCount를 받아 ng-repeat 사용시 배열에 넣지 않고 사용할 수 있는 방법 찾아보기.
    $scope.getPageCount = function() {
       $http.get('article/'+ownerId+'/'+categoryId+'/pageCount').success(function(pageCount){
    	    $scope.pageCountList = [];
    	   	 for(var index = 0; index < pageCount; index+=1) {
    	   		$scope.pageCountList.push(index); 
    	   	 }
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
    $scope.getPageCount();
};