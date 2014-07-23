<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div ng-include src="'fragments/bodyHeader'"></div>
<div class="container">
	<div class="login-container">
		<div id="output"></div>
		<div class="avatar"></div>
		<div class="form-box">
		    <form method="post">
		        <input id="uid" name="uid" placeholder="username" ng-model="user.uid">
		        <input name="password" type="password"  placeholder="password" ng-model="user.password">
		        <button class="btn btn-info btn-block login" ng-click="processSignin(user);">로그인</button>
		    </form>
		</div>
	</div>
</div>