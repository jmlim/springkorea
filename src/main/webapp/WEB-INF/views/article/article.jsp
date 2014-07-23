 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div ng-include src="'fragments/bodyHeader'"></div>
<!-- left -->
<div ng-include src="'category/category'"></div>

<!-- right -->
<!-- write -->
<div id="article-right" class="col-md-10">
	<div id="articlebox" ng-show="writeMode">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">글쓰기</div>
			</div>
			<div class="panel-body">
				<form id="form-article" class="form-horizontal">
					<div class="form-group">
						<div class="col-md-9">
							<input type="hidden" class="form-control" name="id" ng-model="article.id" 
								ng-readonly="editMode"
								placeholder="Article id">
							<span id="id" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="subject" class="col-md-2 control-label">Subject</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="subject" ng-model="article.subject"
								placeholder="제목">
							<span id="subject" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="content" class="col-md-2 control-label">Content</label>
						<div class="col-md-10">
							<textarea class="form-control" 
								ng-model="article.content"
								rows="10" name="content" placeholder="내용"></textarea>
							<span id="content" class="error-message"></span>
						</div>
					</div>
	
					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-2 col-md-10">
							<button id="form-article-submit" type="button" class="btn btn-info" 
								ng-hide="editMode"
								ng-click="addNewArticle(article);">
								<i class="icon-hand-right"></i>등록
							</button>
							<button type="button" class="btn btn-primary" ng-show="editMode"
								ng-click="updateArticle(article)">수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- list -->
	<div class="articles-wrapper" ng-hide="writeMode || contentMode">
		<table class="table table-bordered table-striped"
			ng-show="articles.length > 0">
			<thead>
				<tr>
					<th style="text-align: center; width: 70px;">글번호</th>
					<th style="text-align: center; width: 100px;">작성자</th>
					<th style="text-align: center;">제목</th>
					<!-- <th style="text-align: center;">Content</th> -->
					<th style="text-align: center;" ng-show="userSession.uid != null">수정</th>
					<th style="text-align: center;" ng-show="userSession.uid != null">삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="article in articles">
					<td style="text-align: center;">{{article.id}}</td>
					<td style="text-align: center;  width: 100px;">{{article.writer.name}}</td>
					<td><a style="cursor:pointer" ng-click="contentArticle(article);">{{article.subject}}</a></td>
					<!-- <td>{{article.content}}</td> -->
					<td style="text-align: center; width: 20px;" ng-show="userSession.uid != null">
						<button class="btn btn-mini btn-success" 
							ng-show="article.writer.uid == userSession.uid"
							ng-click="editArticle(article)">Edit</button>
					</td>
					<td style="width: 100px; text-align: center;" ng-show="userSession.uid != null">
						<button class="btn btn-mini btn-danger" 
							ng-show="article.writer.uid == userSession.uid"
							ng-click="removeArticle(article.id)">Remove</button>
					
					</td>
				</tr>
			</tbody>
		</table>
		
		<button class="btn btn-mini" ng-show="userSession.uid != null"
			ng-click="writeArticle()">글쓰기</button>
	</div>
	
	<!-- content -->
	<div id="articlebox" ng-show="contentMode"
		class="mainbox">
		<div class="panel panel-info row">
			<div class="panel-heading">
				<div class="panel-title">{{article.subject}}</div>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<div>
						<span>{{article.content}}</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<button class="btn btn-mini btn-success" ng-click="listArticle();">목록</button>
		</div>
	</div>
</div>
