<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="../fragments/headTag.jsp" />
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<div class="signup">
		<c:url value="/user/processSignupSubmit" var="targetUrl" />
		<form action="${targetUrl}" method="post" class="form-signup">
			<label for="user_id">UserId: </label>
			<input name="uid" id="user_id" required="required"
				autofocus="autofocus" class="form-control" placeholder="Your id..." />
			<br />

			<label for="email">Email: </label>
			<input name="email" id="email" required="required"
				autofocus="autofocus" class="form-control"
				placeholder="Your email..." />
			<br />

			<label for="name">Name: </label>
			<input name="name" id="name" required="required"
				class="form-control" placeholder="Your name..." />
			<br />

			<label for="password">Password: </label>
			<input type="password" name="password" id="password" required="required"
				class="form-control" placeholder="Your password..." />
			<br />

			<input type="submit"
				class="btn btn-lg btn-primary btn-block signup-margin-top"
				value="Submit" />
		</form>
	</div>
</body>
</html>