<%@page import="mul.com.tc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserDto mem = (UserDto)session.getAttribute("login");
	int seq = (Integer)request.getAttribute("seq");
	//System.out.println(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="commentwriteAf.do" method="post">
<input type="hidden" name="noticeseq" value="<%=seq %>">
<input type="hidden" name="userid" value="<%=mem.getId() %>">
<input type="hidden" name="bbschoice" value="4">
<input type="hidden" name="avatar" value="<%=mem.getAvatar() %>">
<table>
<col width="50"><col width="200">
<tr>	
	<th>작성자</th>
	<td><%=mem.getNickname() %></td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="82px" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="submit" value="댓글작성">
	</td>
</tr>
</table>
</form>
</body>
</html>