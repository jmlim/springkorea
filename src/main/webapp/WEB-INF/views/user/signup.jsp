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
	<div class="signup">
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
</body>
</html>