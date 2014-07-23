 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- left -->
<div id="article-left" class="mainbox col-md-2" ng-controller="CategoryController">
	<ul class="list-group" ng-show="categories.length > 0">
	  <li class="list-group-item" ng-repeat="category in categories">
	  	<a href="#/articles/{{category.owner.uid}}/{{category.id}}">{{category.title}}</a>
	  	<a style="cursor: pointer;" class="glyphicon glyphicon-pencil"></a>
	  	<a style="cursor: pointer;" class="glyphicon glyphicon-remove" ng-click="removeCategory(category.id);"></a>
	  </li>
	</ul>
	<form>
		<div class="input-group" ng-show="userSession.uid != null">
			<input type="text" class="form-control" ng-model="category.title">
			<span class="input-group-addon">
				<a style="cursor: pointer;"
					ng-click="addNewCategory(category)">등록</a>
			</span>
		</div>
	</form>
</div>

