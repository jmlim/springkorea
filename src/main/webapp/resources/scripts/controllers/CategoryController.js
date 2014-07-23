'use strict';

/**
 * CategoryController
 * 
 * @constructor
 */
var CategoryController = function($rootScope, $scope, $http, $routeParams, $route) {
	$scope.category = {};
	$scope.editMode = false;
	$scope.writeMode = false;
	$scope.contentMode = false;

	var ownerId = $routeParams.ownerId;
	/*var categoryId = $routeParams.categoryId;*/

	if(!ownerId) {
		ownerId = $rootScope.userSession.uid;
		$rootScope.currentOwnerId = ownerId;
	}

    $scope.fetchCategoryList = function() {
        $http.get('category/'+ownerId+'/categorylist.json').success(function(categoryList){
            $scope.categories = categoryList;
        });
    };

    $scope.addNewCategory = function(category) {
        $http.post('category/'+ownerId+'/addCategory/',category).success(function() {
            $scope.fetchCategoryList();
            $scope.writeMode = false;
            $scope.category = {};
        });
    };

    $scope.updateCategory = function(category) {
    	 $http.put('category/'+ownerId+'/updateCategory/',category).success(function() {
             $scope.fetchCategoryList();
             $scope.editMode = false;
             $scope.writeMode = false;
             $scope.category = {};
         });
    };
    
    $scope.removeCategory = function(id) {
        $http.delete('category/'+ownerId+'/removeCategory/'+id).success(function() {
            $scope.fetchCategoryList();
            $route.reload();
        });
    };

    $scope.writeCategory = function() {
    	$scope.writeMode = true;
    	$scope.category = {};
    };

    $scope.editCategory = function(category) {
        $scope.category = category;
        $scope.writeMode = true;
        $scope.editMode = true;
    };

    $scope.contentCategory = function(category) {
    	$scope.category = category;
    	$scope.contentMode = true;
    };
    
    $scope.listCategory = function() {
    	$scope.category = {};
    	$scope.contentMode = false;
    };

    $scope.fetchCategoryList();
};