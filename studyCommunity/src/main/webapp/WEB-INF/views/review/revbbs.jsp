<%@page import="mul.com.sc.util.ScUtil"%>
<%@page import="mul.com.sc.dto.RevBbsDto"%>
<%@page import="java.util.List"%>
<%@page import="mul.com.sc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
UserDto mem = (UserDto)session.getAttribute("login");
%>

<%
String search = (String)request.getAttribute("search");
if(search == null) search = "";
String choice = (String)request.getAttribute("choice");

int bbsPage = (Integer)request.getAttribute("bbsPage");
int pageNumber = (Integer)request.getAttribute("pageNumber"); // 현재 페이지

List<RevBbsDto> list = (List<RevBbsDto>)request.getAttribute("revbbs");

%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 메뉴 ul  -->
<link type="text/css" rel="stylesheet" href="./css/ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	// 검색어가 있는 경우
	let search = "<%=search %>";
	if(search == "") return;
	
	// select 처리
	let obj = document.getElementById("choice");
	obj.value = "<%=choice %>";
	obj.setAttribute("selected", "selected");
});
</script>

</head>
<body>

<h2  class="my-5">스터디후기</h2>


<div align="center" class="mt-3">
	<table class="table table-hover">
		<col width="50px"><col width="700px"><col width="70px"><col width="70px">
		<tr align="center">
			<th>번호</th><th>제목</th><th>조회수</th><th>작성자</th><th>작성일</th>
		</tr>
		<%
		if(list.size() == 0){
			%>
			<tr>
				<td colspan="5">작성된 자료가 없습니다</td>
			</tr>
			<%
		}
		%>
		<%
		for(int i = 0;i < list.size(); i++){
				RevBbsDto rev = list.get(i);
		%>
				<tr align="center">
					<th><%=i + 1 %></th>
					<td align="left">
						<a href="revdetail.do?seq=<%=rev.getSeq() %>" style="text-decoration-line: none;"><%=rev.getTitle() %></a>
					<td><%=rev.getNickname() %></td>
					<td><%=rev.getReadcount() %></td>
					<td class="timeData"><%=rev.getRegdate() %></td>
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
			if(i == 0){
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
<div class="d-flex justify-content-center align-items-center">
	<div class="form-group">
		<select class="form-select" id="choice">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="id">작성자</option>
		</select>
	</div>
	<div class="form-group">
		<div class="input-group">
			<input type="text" id="search" class="form-control" value="<%=search %>">
			<button class="btn btn-primary" onclick="searchBbs()" type="button">검색</button>
		</div>
	</div>
</div>

<div class="mt-5">
	<a href="revwrite.do" type="button" class="btn btn-primary">글쓰기</a>
</div>


<script type="text/javascript">
$(function () {
	$(".titleTd").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".titleTd").mouseout(function() {
		$(this).css("background", "#ffffff");
	});	
});

function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;

	location.href = "revbbs.do?choice=" + choice + "&search=" + search;
}

function goPage( pageNum ) {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "revbbs.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNum;
}
const timeData = document.querySelectorAll(".timeData");
let i = 0;
</script>

<%
for(int i = 0; i < list.size(); i++) {
	%>
	<script type="text/javascript">
		timeData[i].innerText = displayedAt('<%=list.get(i).getRegdate() %>')
		i++;
	</script>
	<%
}
%>

</body>
</html>





