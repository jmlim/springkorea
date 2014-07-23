<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div ng-include src="'fragments/bodyHeader'"></div>
<div class="container">
	<table class="table table-bordered table-striped"
		ng-show="users.length > 0">
		<thead>
			<tr>
				<th style="text-align: center; width: 25px;">아이디</th>
				<th style="text-align: center;">이름</th>
				<th style="text-align: center;">이메일</th>
				<th style="text-align: center;">링크</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="user in users | orderBy:predicate">
				<td style="text-align: center;">{{user.uid}}</td>
				<td>{{user.name}}</td>
				<td>{{user.email}}</td>
				<td style="text-align: center; width: 20px;">
					<a class="btn btn-mini btn-success" href="#/index/{{user.uid}}">블로그 가기</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>