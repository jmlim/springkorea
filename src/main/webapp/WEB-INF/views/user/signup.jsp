<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="../fragments/headTag.jsp" />
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$("#form-signup-submit").click(function() {
				var parameters = $("#form-signup").serialize();
				$.ajax({
					type : "POST",
					data : parameters,
					url : "processSignupSubmit",
					async : false,
					dataType : "json",
					error : function(data) {
					},
					success : function(data) {
						if (data.hasErrors) {
							for ( var prop in data) {
								var errorElem = $("#" + prop + ".error-message");
								errorElem.text("");
								errorElem.text(data[prop]);
							}
							return;
						}
						window.location.href = "signin";
					}
				});
			});
		});
	</script>
	<%-- <div class="signup">
		<c:url value="/user/processSignupSubmit" var="targetUrl" />
		<form id="form-signup" action="${targetUrl}" method="post" class="form-signup">
			<label for="user_id">UserId: </label>
			<input name="uid" id="user_id" required="required"
				autofocus="autofocus" class="form-control" placeholder="Your id..." />
			<span id="uid" class="error-message"></span>
			<br />

			<label for="email">Email: </label>
			<input name="email" id="email" required="required"
				autofocus="autofocus" class="form-control"
				placeholder="Your email..." />
			<span id="email" class="error-message"></span>
			<br />

			<label for="name">Name: </label>
			<input name="name" id="name" required="required"
				class="form-control" placeholder="Your name..." />
			<span id="name" class="error-message"></span>
			<br />

			<label for="password">Password: </label>
			<input type="password" name="password" id="password" required="required"
				class="form-control" placeholder="Your password..." />
			<span id="password" class="error-message"></span>
			<br />

			<input id="form-signup-submit" type="button"
				class="btn btn-lg btn-primary btn-block signup-margin-top"
				value="Submit" />
		</form>
	</div>
 --%>
 <c:url value="/user/processSignupSubmit" var="targetUrl" />

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
							<input type="text" class="form-control" name="uid"
								placeholder="User id">
							<span id="uid" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-3 control-label">Email</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="email"
								placeholder="Email Address">
							<span id="email" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-md-3 control-label">First
							Name</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="name"
								placeholder="First Name">
							<span id="name" class="error-message"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" class="form-control" name="passwd"
								placeholder="Password">
							<span id="password" class="error-message"></span>
						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<button id="form-signup-submit" type="button" class="btn btn-info">
								<i class="icon-hand-right"></i> &nbsp Sign Up
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>