<%@page import="mul.com.sc.dto.NoticeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%
	String content = (String)request.getAttribute("content");
	List<NoticeDto> list = (List<NoticeDto>)request.getAttribute("list");
	//System.out.println(list.toString());
	String msg = (String)request.getAttribute("msg");
	//System.out.println(msg);
	
	int pageNumber = (Integer)request.getAttribute("pageNumber");
	int bbsPage = (Integer)request.getAttribute("bbspage");
	
	System.out.println(pageNumber);
	System.out.println(bbsPage);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
</head>
<body>

<h2  class="my-5">공지사항</h2>


<div align="center" class="mt-3 w-75">
	<table class="table table-hover">
		<col width="50px"><col width="700px"><col width="70px"><col width="100px"><col width="70px">
		<tr align="center">
			<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
		</tr>
		<%
		if(list.size() == 0){
			%>
			<tr>
				<td colspan="5">공지사항이 없습니다</td>
			</tr>
			<%
		}
		%>
		<%
		for(int i = 0;i < list.size(); i++){
			NoticeDto notice = list.get(i);
		%>
				<tr align="center">
					<th><%=i + 1 %></th>
					<td align="left">
						<a href="noticedetail.do?seq=<%=notice.getSeq() %>" style="text-decoration-line: none;"><%=notice.getTitle() %></a>
					<td><%=notice.getNickname() %></td>
					<td class="timeData"><%=notice.getRegDate() %></td>
					<td><%=notice.getReadcount() %></td>
				</tr>
				<%
			}
		%> 
		
	</table>
</div>
<div class="d-flex justify-content-center align-items-center m-5">
	<%
	if(bbsPage <= 1){
		%>
		<span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
			1
		</span>&nbsp;
		<%
	} else {
		if(pageNumber == 0){	
			%>
			<span class="mx-4" style="color: rgba(0,0,0,0.3); "><i class="fas fa-chevron-left"></i> 이전</span>
			<%
		} else {
			%>
			<a class="mx-4" style="text-decoration: none; cursor: pointer; color: gray;" onclick="goPage(<%=pageNumber - 1 %>)"><i class="fas fa-chevron-left"></i> 이전</a>
			<% 
		}
		for(int i = 0;i < bbsPage; i++){
			if(pageNumber == i){
				%>
				<span class="text-primary px-2" style="font-size: 15pt; font-weight: bold; border:1px solid rgba(0,0,0,0.1);">
					<%=i + 1 %>
				</span>
				<%
			}
		else{
				%>
				<a href="#none" title="<%=i + 1 %>페이지" onclick="goPage(<%=i %>)"
					style="font-size: 15pt;color: #000; font-weight: bold; text-decoration: none;">
					<%=i + 1 %>
				</a>&nbsp;
				<%
			}
		}
		if(pageNumber == bbsPage - 1){	
			%>
			<span class="mx-4" style="color: rgba(0,0,0,0.3);">다음 <i class="fas fa-chevron-right"></i></span>
			<%
		} else {
			%>
			<a class="mx-4" style="text-decoration: none; cursor: pointer; color: gray;" onclick="goPage(<%=pageNumber + 1 %>)">다음 <i class="fas fa-chevron-right"></i></a>
			<% 
		}
	}
	%>
</div>


<div class="mt-5">
	<a href="noticewrite.do" type="button" class="btn btn-primary">글쓰기</a>
</div>






<script type="text/javascript">
$(document).ready(function() {
	let msg = "<%=msg %>";
	//console.log(msg);
	if(msg != "null"){
		alert(msg);
	}
});

function goPage( pageNum ) {
	
	
	location.href = "noticelist.do?pageNumber=" + pageNum;
}


console.log(displayedAt('${ notice.regDate }'))

 
function goPage( pageNum ) {
	location.href = "noticelist.do?pageNumber=" + pageNum;
}

const timeData = document.querySelectorAll(".timeData");
let i = 0;
</script>

<%
for(int i = 0; i < list.size(); i++) {
	%>
	<script type="text/javascript">
		timeData[i].innerText = displayedAt('<%=list.get(i).getRegDate() %>')
		i++;
	</script>
	<%
}
%>


</body>
</html>