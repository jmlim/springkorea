 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <div class="container">    
	<div id="signupbox" style="margin-top: 50px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign Up</div>
			</div>
			<div class="panel-body">
				<form id="form-signup" action="${targetUrl}" method="post" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="uid" class="col-md-3 control-label">User Id</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="uid" ng-model="user.uid" 
								ng-readonly="editMode"
								placeholder="User id">
							<span id="uid" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-3 control-label">Email</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="email" ng-model="user.email"
								placeholder="Email Address">
							<span id="email" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-md-3 control-label">First
							Name</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="name" ng-model="user.name"
								placeholder="First Name">
							<span id="name" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" class="form-control" name="password" ng-model="user.password"
								placeholder="Password">
							<span id="password" class="error-message"></span>
						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<button id="form-signup-submit" type="button" class="btn btn-info" 
								ng-hide="editMode"
								ng-click="addNewUser(user);">
								<i class="icon-hand-right"></i> &nbsp Sign Up
							</button>
							<button type="button" class="btn btn-primary" ng-show="editMode"
								ng-click="updateUser(user)">Update</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
	<table class="table table-bordered table-striped"
		ng-show="users.length > 0">
		<thead>
			<tr>
				<th style="text-align: center; width: 25px;">Id</th>
				<th style="text-align: center;">Name</th>
				<th style="text-align: center;">Email</th>
				<th style="text-align: center;">Edit</th>
				<th style="text-align: center;">Remove</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="user in users | orderBy:predicate">
				<td style="text-align: center;">{{user.uid}}</td>
				<td>{{user.name}}</td>
				<td>{{user.email}}</td>
				<td style="text-align: center; width: 20px;">
					<button class="btn btn-mini btn-success" 
						ng-click="editUser(user)">Edit</button>
				</td>
				<td style="width: 100px; text-align: center;">
					<button class="btn btn-mini btn-danger"
						ng-click="removeUser(user.uid)">Remove</button>
				
				</td>
			</tr>
		</tbody>
	</table>
</div>