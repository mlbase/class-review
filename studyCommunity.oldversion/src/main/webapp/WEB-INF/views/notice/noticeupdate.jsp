<%@page import="mul.com.tc.dto.UserDto"%>
<%@page import="mul.com.tc.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int seq = (Integer)request.getAttribute("seq");
	NoticeDto dto = (NoticeDto)request.getAttribute("notice"); 
	UserDto user = (UserDto)session.getAttribute("login");

%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body>
<h1>글수정</h1>
<div align="center">

<form action="noticeupdateAf.do" method="post">
<input type="hidden" name="seq" value="<%=seq %>">
<table border="1">

<tr>
	<th>작성자</th>
	<td>
		<p><%=dto.getNickname() %></p>
	</td>>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="50px" value="<%=dto.getTitle() %>">
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="50px" name="content" ><%=dto.getContent() %></textarea>
		<img src="image_notice/<%=dto.getFilename() %>">
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
		<input type="submit" value="글수정">
	</td>
</tr>
</table>

</form>


</div>
</body>
</html>