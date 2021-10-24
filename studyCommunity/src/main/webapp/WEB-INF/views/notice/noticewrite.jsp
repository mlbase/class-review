<%@page import="mul.com.sc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserDto mem = (UserDto)session.getAttribute("login");
	System.out.println(mem.getId());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<h2 class="mt-5">공지사항 작성</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class=" form-inline w-50 d-flex flex-column justify-content-center" action="noticewriteAf.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="userid" value="<%=mem.getId() %>">
			<input type="hidden" name="readcount" value="0">
			<input type="hidden" name="nickname" value="<%=mem.getNickname() %>">
			<input type="hidden" name="avatar" value="<%=mem.getAvatar() %>">
			<input type="hidden" name="Bbsid" value="1">
			<div class="form-group border">
			  <input class="form-control form-control-lg border-bottom" style="border: none" type="text" placeholder="여기에 제목을 작성해주세요" name="title">
			  <textarea rows="20" cols="82px" name="content" style="border: none" class="w-auto"></textarea>
			  <div class="form-group">
			      <label for="formFile" class="form-label">업로드할 이미지파일을 선택해주세요.</label>
			      <input class="form-control" type="file" name="fileload" accept="image/*">
			  </div>
			  
			</div>
            <div class="mt-5 d-flex flex-column justify-content-center">
                <button class="btn btn-lg btn-primary" type="submit">글작성</button>
            </div>
		</form>
	</div>   
</div> 

<%-- <h2>공지사항 작성</h2>

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
		<input type="text" name="title" placeholder="제목입력">
	</td>
</tr>
<tr>
	<th>이미지업로드</th>
	<td>
		<input type="file" multiple="multiple" name="fileload" accept="image/*">
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
		<input type="submit" value="글작성" class="mb-5">
	</td>
</tr>
</table>


</form> --%>

</body>
</html>