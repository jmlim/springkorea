 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../fragments/bodyHeader.jsp" />

 <div class="container">    
	<div id="articlebox" ng-show="writeMode" style="margin-top: 50px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">글쓰기</div>
			</div>
			<div class="panel-body">
				<form id="form-article" action="${targetUrl}" method="post" class="form-horizontal" role="form">
					<div class="form-group">
						<!-- <label for="id" class="col-md-3 control-label">Article Id</label> -->
						<div class="col-md-9">
							<input type="hidden" class="form-control" name="id" ng-model="article.id" 
								ng-readonly="editMode"
								placeholder="Article id">
							<span id="id" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="subject" class="col-md-3 control-label">Subject</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="subject" ng-model="article.subject"
								placeholder="Subject ">
							<span id="subject" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="content" class="col-md-3 control-label">Content</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="content" ng-model="article.content"
								placeholder="First Name">
							<span id="content" class="error-message"></span>
						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
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
	
	<div class="articles-wrapper" ng-hide="writeMode" >
		<table class="table table-bordered table-striped"
			ng-show="articles.length > 0">
			<thead>
				<tr>
					<th style="text-align: center; width: 25px;">Id</th>
					<th style="text-align: center; width: 25px;">Writer</th>
					<th style="text-align: center;">Subject</th>
					<th style="text-align: center;">Content</th>
					<th style="text-align: center;">Edit</th>
					<th style="text-align: center;">Remove</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="article in articles">
					<td style="text-align: center;">{{article.id}}</td>
					<td>{{article.writer.name}}</td>
					<td>{{article.subject}}</td>
					<td>{{article.content}}</td>
					<td style="text-align: center; width: 20px;">
						<button class="btn btn-mini btn-success" 
							ng-click="editArticle(article)">Edit</button>
					</td>
					<td style="width: 100px; text-align: center;">
						<button class="btn btn-mini btn-danger"
							ng-click="removeArticle(article.id)">Remove</button>
					
					</td>
				</tr>
			</tbody>
		</table>
		
		<button class="btn btn-mini" 
			ng-click="writeArticle()">글쓰기</button>
	</div>
</div>