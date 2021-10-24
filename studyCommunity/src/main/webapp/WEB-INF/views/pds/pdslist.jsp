<%@page import="java.util.Date"%>
<%@page import="mul.com.sc.dto.PdsDto"%>
<%@page import="mul.com.sc.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String search = (String)request.getAttribute("search");
	if(search == null) search = "";
	String choice = (String)request.getAttribute("choice");
	
	int pdsPage = (Integer)request.getAttribute("pdsPage");
	int pageNumber = (Integer)request.getAttribute("pageNumber"); // 현재 페이지
	
	List<PdsDto> list = (List<PdsDto>)request.getAttribute("pdslist");	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실</title>
</head>
<body>

<h2  class="my-5">학습자료실</h2>


<div align="center" class="mt-3">
	<table class="table table-hover">
		<col width="50px"><col width="680px"><col width="70px"><col width="70px"><col width="70px"><col width="100px">
		<tr align="center">
			<th>번호</th><th>제목</th><th>작성자</th><th>다운수</th><th>조회수</th><th>작성일</th>
		</tr>
		<%
		if(list.size() == 0){
			%>
			<tr>
				<td colspan="6">작성된 자료가 없습니다</td>
			</tr>
			<%
		}
		%>
		<%
		for(int i = 0;i < list.size(); i++){
				PdsDto pds = list.get(i);
		%>											
				<tr align="center">			
					<th><%=i + 1 %></th>
					<td align="left">
						<a href="pdsdetail.do?seq=<%=pds.getSeq() %>" style="text-decoration-line: none;"><%=pds.getTitle() %></a>
					<td><%=pds.getNickname() %></td>
					<td><%=pds.getDowncount() %></td>
					<td><%=pds.getReadcount() %></td>
					<td class="timeData"><%=pds.getRegdate() %></td>
				</tr>
				<%
			}
		%>
	</table>
</div>
<div class="d-flex justify-content-center align-items-center m-5">
	<%
	if(pdsPage <= 1){
		%>
		<span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
			1
		</span>&nbsp;
		<%
	} else {
		if(pageNumber == 0){	
			%>
			<span class="mx-4" style="color: rgba(0,0,0,0.3);"><i class="fas fa-chevron-left"></i> 이전</span>
			<%
		} else {
			%>
			<a class="mx-4" style="text-decoration: none; cursor: pointer; color: gray;" onclick="goPage(<%=pageNumber - 1 %>)"><i class="fas fa-chevron-left"></i> 이전</a>
			<% 
		}
		for(int i = 0;i < pdsPage; i++){
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
		if(pageNumber == pdsPage - 1){	
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
			<button class="btn btn-primary" onclick="searchPds()" type="button">검색</button>
		</div>
	</div>
</div>

<div class="my-5">
	<a href="pdswrite.do" type="button" class="btn btn-primary">자료추가</a>
</div>

<!-- 자료 추가 -->


</script>

<script type="text/javascript">
$(function () {
	$(".titleTd").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".titleTd").mouseout(function() {
		$(this).css("background", "#ffffff");
	});	
});

$(document).ready(function() {
	// 검색어가 있는 경우
	let search = "<%=search %>";
	if(search == "") return;
	
	// select 처리
	let obj = document.getElementById("choice");
	obj.value = "<%=choice %>";
	obj.setAttribute("selected", "selected");	
});

function searchPds() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;

	location.href = "pdslist.do?choice=" + choice + "&search=" + search;
}

function goPage( pageNum ) {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "pdslist.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNum;
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