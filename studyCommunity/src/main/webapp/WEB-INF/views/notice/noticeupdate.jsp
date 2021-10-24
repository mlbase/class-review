<%@page import="mul.com.sc.dto.UserDto"%>
<%@page import="mul.com.sc.dto.NoticeDto"%>
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
</head>
<body>
<h2 class="mt-5">게시글 수정</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class=" form-inline w-50 d-flex flex-column justify-content-center" action="noticeupdateAf.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="seq" value="${notice.seq }">
			<input type="hidden" name="userid" value="${notice.userid }">
			<input type="hidden" name="nickname" value="${notice.nickname }">
			<input type="hidden" name="avatar" value="<%=user.getAvatar() %>">
			<div class="form-group border">
			  <input class="form-control form-control-lg border-bottom" style="border: none" type="text" value="${notice.title}" name="title">
			  <textarea rows="20" cols="82px" name="content" style="border: none" class="w-auto" >${notice.content}</textarea>
			  <div class="form-group">
			      <label for="formFile" class="form-label">수정할 이미지파일을 선택해주세요.</label>
			      <input class="form-control" type="file" name="fileload" accept="image/*">
			      
			  </div>
			  
			</div>
            <div class="mt-5 d-flex flex-column justify-content-center">
                <button class="btn btn-lg btn-primary" type="submit">글수정</button>
            </div>
		</form>
	</div>   
</div> 

<%-- <h1>글수정</h1>
<div align="center">

<form action="noticeupdateAf.do" method="post" enctype="multipart/form-data">
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
		<img src="upload/notice/<%=dto.getFilename() %>">
		<label for="formFile" class="form-label">수정할 이미지파일을 선택해주세요.</label>
		<input class="form-control" type="file" name="fileload" accept="image/*">
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
		<input type="submit" value="글수정">
	</td>
</tr>
</table>

</form>


</div> --%>
</body>
</html>