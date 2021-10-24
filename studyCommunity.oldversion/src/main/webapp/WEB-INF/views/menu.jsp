<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 메뉴 ul  -->
<link type="text/css" rel="stylesheet" href="./css/ui.css">
</head>
<body>

<nav>
<ul>
	<li><a href="*">자유게시판</a></li>
	<li><a href="*">국내여행게시판</a></li>
	<li><a href="*">해외여행게시판</a></li>
	<li><a href="noticelist.do">공지사항게시판</a></li>
</ul>

<ul>
	<c:if test="${ login != null }">
		<li><a href="bbslist.do">logout</a></li>
		<li><a href="*">${ login.nickname } 페이지</a></li>
	</c:if>
	<c:if test="${ login == null }">
		<li><a href="login.do">login</a></li>
		<li><a href="join.do">join</a></li>
	</c:if>
</ul>
</nav>

</body>
</html>