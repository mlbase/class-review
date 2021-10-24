<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2 class="my-5">내 정보</h2>

<img alt="아바타" src="${ user.avatar == null ? 'images/profile.jpg' : user.avatar }" class="img-circle" style="border-radius: 50%;" width="300" height="300">
<h3 class="mt-5">${ user.nickname }</h3>
<span class="fs-6 text-secondary mb-5">${ user.email }</span>
<div class="d-grid gap-2">
	<a href="updateUser.do" type="button" class="btn btn-primary">회원정보수정</a>
	<a href="deleteUser.do?id=${ user.id }" type="button" class="btn btn-danger">회원탈퇴</a>
</div>





</body>
</html>