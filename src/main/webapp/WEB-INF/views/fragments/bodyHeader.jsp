<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- header nav bar -->
<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="#">{{targetId}} 의 블로그입니다.</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#/articles">게시판</a></li>
				<!--
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Dropdown <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li> -->
			</ul>
			<ul class="nav navbar-nav navbar-right" ng-hide="userSession.uid != null">
				<li><a href="#/signin">로그인</a></li>
				<li><a href="#/signup">등록</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right"  ng-show="userSession.uid != null">
				<li><a href="#">{{userSession.name}}님 환영합니다.</a></li>
				<li><a href="#" ng-click="processLogout()">로그아웃</a></li>
				<li><a href="#/signup">정보수정</a></li>
				<li><a href="#/users">다른 유저 블로그 들어가기</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>