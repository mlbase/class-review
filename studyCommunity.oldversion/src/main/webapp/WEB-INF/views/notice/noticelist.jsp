<%@page import="mul.com.tc.dto.NoticeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<NoticeDto> list = (List<NoticeDto>)request.getAttribute("list");
	//System.out.println(list.toString());
	String msg = (String)request.getAttribute("msg");
	//System.out.println(msg);
	
	int bbsPage = (Integer)request.getAttribute("bbspage");

	int pageNumber =(Integer)request.getAttribute("pageNumber");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항게시판</title>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
</head>
<body>
<div float="left" width="60%">
<h2>공지사항</h2>
</div>
<div float="right" width="40%">
<h3 ><a href="login.do">로그인</a></h3>
</div>
<div align="center">
	<table>
	<col width="50"><col width="300"><col width="100"><col width="50"><col width="100">

	<tr>
		<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
	</tr>
		<% if(list.size()==0){ %>
			<tr>
				<td colspan="5" align="center">게시물이 없습니다.</td>	
			</tr>	
		<%} else {
			for(int i =0; i<list.size();i++){
				
			
		%>
			<tr>
				<th><%=i+1%></th>
				<td><a href="noticedetail.do?seq=<%=list.get(i).getSeq() %>"><%=list.get(i).getTitle() %></a></td>
				<td><%=list.get(i).getNickname() %></td>
				<td><%=list.get(i).getReadcount() %></td>
				<td><%=list.get(i).getRegdate() %>	
			</tr>
		<%	
			}
		} %>	
	</table>
	<br>
<%for(int i=0; i < bbsPage; i++){
	if(pageNumber == i){
		%>		
		<span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
			<%=i+1 %>
		</span>	
		<%
	}
	else{
		%>
		<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
			style="font-size: 15pt;color: #000;font-weight: bold;">
			[<%=i + 1 %>]
		</a>&nbsp;
		<%
	}	
}


%>
<footer>
	<a href="noticewrite.do">글쓰기</a>
</footer>
</div>
<script type="text/javascript">
$(document).ready(function() {
	let msg = "<%=msg %>";
	//console.log(msg);
	if(msg != "null"){
		alert(msg);
	}
});
function goPage(pageNum) {
		
	location.href = "noticelist.do?pageNumber=" +pageNum;
	
}
</script>

</body>
</html>