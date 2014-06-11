<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html ng-app="SpringKoreaApp">
<head>
<jsp:include page="fragments/headTag.jsp" />
</head>
<body ng-controller="MainController">
	<%-- <jsp:include page="fragments/bodyHeader.jsp" /> --%>
	<%-- <div class="index">
		<c:choose>
			<c:when test="${not empty sessionScope.userSession}">
				<h2>로그인 성공</h2>
      			  이름 : <c:out value="${sessionScope.userSession.uid}" />
  				  이메일 : <c:out value="${sessionScope.userSession.email}" />
			</c:when>
			<c:otherwise>
				<h2>로그인 해주세요</h2>
			</c:otherwise>
		</c:choose>
	</div> --%>
	<ng-view></ng-view>
</body>
</html>