
<%@page import="mul.com.tc.dto.NoticeDto"%>
<%@page import="mul.com.tc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String arr[] = {"자유게시판", "공부후기게시판", "학습자료실"};
	NoticeDto notice = (NoticeDto)request.getAttribute("notice");
	//System.out.println(notice.toString());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body>
<div class="container">
<table>
<col width="50"><col width="70%">
<tr>
	<th>제목</th>
	<td><%=notice.getTitle() %></td>
</tr>
<tr>
	<th>작성자</th>
	<td><%=notice.getNickname() %></td>
</tr>
<tr>
	<th>조회수</th>
	<td><%=notice.getReadcount() %></td>
</tr>
<tr>
	<th>연결게시판</th>
	<td><%=arr[notice.getBbsid()-1] %></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea readonly="readonly"><%=notice.getContent() %></textarea></td>
</tr>
<tr>
	<th>이미지</th>
	<td><img src="image_notice/<%=notice.getFilename() %>"></td>
</tr>
</table>
</div>
</body>
</html>