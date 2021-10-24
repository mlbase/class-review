<%@page import="java.util.Date"%>
<%@page import="mul.com.tc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


UserDto user = new UserDto( 11, "123@naver.com", "234", "test", 0, "2021-10-15", "avatar", 3);

session.setAttribute("login", user);

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="noticelist.do">공지사항보기</a>
</body>
</html>