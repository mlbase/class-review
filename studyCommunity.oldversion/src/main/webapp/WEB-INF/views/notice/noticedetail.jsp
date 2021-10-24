
<%@page import="mul.com.tc.dto.CommentDto"%>
<%@page import="java.util.List"%>
<%@page import="mul.com.tc.dto.NoticeDto"%>
<%@page import="mul.com.tc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String arr[] = {"자유게시판", "공부후기게시판", "학습자료실"};
	NoticeDto notice = (NoticeDto)request.getAttribute("notice");
	//System.out.println(notice.toString());
	UserDto mem = (UserDto)session.getAttribute("login");
	List<CommentDto> list = (List<CommentDto>)request.getAttribute("list");
	/*for(int i = 0; i<list.size();i++){
		System.out.println(list.get(i).toString());
	}*/
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
	<td><textarea readonly="readonly"><%=notice.getContent() %></textarea>
	<img src="image_notice/<%=notice.getFilename() %>"></td>
</tr>
</table>
</div>
<button class="btn btn-secondary" type="button" onclick="location.href='noticelist.do'">글목록</button>


<%if(mem.getId()==Integer.parseInt(notice.getUserid())){ %>
	<button class="btn btn-success" type="button" onclick="updatebbs()">수정</button>
	<button class="btn btn-danger" type="button" onclick="deletebbs()">삭제</button>
<%} %>
<br><br>
<button class="btn btn-secondary" type="button" onclick="location.href='commentwrite.do?seq=<%=notice.getSeq() %>'">댓글 작성</button>
<br><br>
<table>
<col width="100"><col width="300">
<%
for(int i=0; i<list.size(); i++){%>
	<tr>
		<th>작성자:<%=list.get(i).getNickname() %></th>
		<td><textarea readonly="readonly"><%=list.get(i).getContent() %></textarea>
		<button type="button" onclick="location.href='commentupdate.do?seq=<%=list.get(i).getSeq() %>'">수정</button>
		<button type="button" onclick="location.href='commentdelete.do?seq=<%=list.get(i).getSeq() %>'">삭제</button></td>
	</tr>
<%	
}

%>
</table>
<script type="text/javascript">
let seq = <%=notice.getSeq() %>;

function updatebbs() {
	location.href="noticeupdate.do?seq=" +seq;
}

function deletebbs() {
	location.href="noticedelete.do?seq=" +seq;
}




</script>
</body>
</html>