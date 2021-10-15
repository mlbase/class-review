<%@page import="mul.com.tc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserDto mem = (UserDto)session.getAttribute("login");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>공지사항 작성</h2>

<form action="noticewriteAf.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="userid" value="<%=mem.getId() %>">
<input type="hidden" name="readcount" value="0">
<input type="hidden" name="nickname" value="<%=mem.getNickname() %>">
<input type="hidden" name="avatar" value="<%=mem.getAvatar() %>">
<table>
<col width="50"><col width="200">
<tr>	
	<th>작성자</th>
	<td><%=mem.getNickname() %></td>
</tr>

<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" value="제목입력">
	</td>
</tr>
<tr>
	<th>이미지업로드</th>
	<td>
		<input type="file" name="fileload" accept="image/*">
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="82px" name="content"></textarea>
	</td>
</tr>
<tr>
	<th>작성게시판</th>
	<td>
		<select name="Bbsid">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>
		1.은 자유게시판 2.은 해외여행후기게시판 3.은 국내여행게시판
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="글작성">
	</td>
</tr>
</table>


</form>

</body>
</html>