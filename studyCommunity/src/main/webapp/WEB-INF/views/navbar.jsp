<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/ui.css">
</head>
<body>

<nav class="navbar d-fix navbar-expand-md navbar-dark bg-dark sticky-top">
  <div class="container">
    <a class="navbar-brand text-primary mx-4" href="main.do">StudyCommunity</a>
    <div class="collapse navbar-collapse d-flex justify-content-between" id="navbar-content">
      <ul class="navbar-nav mr-auto">
      	<li class="nav-item">
       		<a class="nav-link" href="noticelist.do">공지사항</a>
       	</li>
        <li class="nav-item">
          <a class="nav-link" href="bbslist.do">자유게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="revbbs.do">공부후기게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="pdslist.do">공부자료실</a>
        </li>
        <c:if test="${ login.auth == 1 }">
        	<li class="nav-item">
	       		<a class="nav-link" href="noticelist.do">관리자페이지</a>
	       	</li>
        </c:if>
      </ul>
      <ul class="navbar-nav d-flex align-items-center">
      	<c:choose>
	      	<c:when test="${ login.nickname != '' && login.nickname != null }">
	      		<li class="nav-item">
		          <a class="nav-link" href="logout.do">logout</a>
		        </li>
		        <li class="nav-item mx-3">
		          <a class="nav-link" href="userDetail.do?userId=${ login.id }"><i class="text-primary fas fa-user-circle fa-2x"></i></a>
		        </li>
	      	</c:when>
	      	<c:otherwise>
	      		<li class="nav-item">
		          <a class="nav-link" href="login.do">login</a>
		        </li>
		        <li class="nav-item mx-3">
		          <a class="nav-link" href="join.do">join</a>
		        </li>
	      	</c:otherwise>
      	</c:choose>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>