<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body>

<c:if test="${ login != null }">
	<h4 align="right">환영합니다 ${ login.nickname } 님 반갑습니다</h4>
</c:if>
<jsp:include page="menu.jsp" flush="false"/>

<main>
<c:if test="${ message != null || message != '' }">
	<p>${ message }</p>
</c:if>
<c:choose>
	<c:when test="${ content == 'login' }">
		<jsp:include page="user/login.jsp" flush="false"/>
	</c:when>
	<c:when test="${ content == 'join' }">
		<jsp:include page="user/join.jsp" flush="false"/>
	</c:when>
	<c:when test="${ content == 'detail' }"></c:when>
	<c:when test="${ content == 'main' }">
		<jsp:include page="main.jsp" flush="false"/>
	</c:when>
</c:choose>
<%-- <jsp:include page="<%=content %>"/> --%>
</main>

</body>
</html>