<%@page import="mul.com.sc.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
 	List<BbsDto> list = (List<BbsDto>)request.getAttribute("bbslist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	// 검색어가 있는 경우
	let search = '${ search }';
	
	if(search == "") return;
	
	// select 처리
	let obj = document.getElementById("choice");
	obj.value = '${ choice }';
	obj.setAttribute("selected", "selected");	
});
</script>
</head>
<body>

<h2  class="my-5">자유게시판</h2>


<div align="center" class="mt-3">
	<table class="table table-hover">
		<col width="50px"><col width="720px"><col width="80px"><col width="80px"><col width="100px">
		<tr align="center">
			<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
		</tr>
		<c:choose>
		    <c:when test="${bbslist == null || fn:length(bbslist) == 0}">
		        <tr>
					<td colspan="4">작성된 글이 없습니다.</td>
				</tr>
		    </c:when>
		
		    <c:otherwise>
		        <c:forEach begin="0" var="bbs" items="${ bbslist }" varStatus="i">
		        	<tr align="center">
						<th>${i.index + 1}</th>
						<td align="left">
							<a href="bbsdetail.do?seq=${ bbs.seq }" style="text-decoration-line: none;">${ bbs.title }</a>
						</td>
						<td>${ bbs.nickname }</td>
						<td>${ bbs.readCount }</td>
						<td class="timeData"></td>
					</tr>
				</c:forEach>
		    </c:otherwise>
		</c:choose>
	</table>
</div>
<div class="d-flex justify-content-center align-items-center m-5">
	<c:choose>
		<c:when test="${ bbspage <= 1 }">
			<span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
				${ i.index + 1 }
			</span>&nbsp;
		</c:when>
		<c:otherwise>
			<c:if test="${ pageNumber == 0 }">
				<span class="mx-4" style="color: rgba(0,0,0,0.3);"><i class="fas fa-chevron-left"></i> 이전</span>
			</c:if>
			<c:if test="${ pageNumber != 0 }">
				<a class="mx-4" style="text-decoration: none; cursor: pointer; color: gray;" onclick="goPage(${ pageNumber - 1})"><i class="fas fa-chevron-left"></i> 이전</a>
			</c:if>
			<c:forEach begin="0" end="${ bbsPage - 1 }" varStatus="i">
				<c:if test="${ pageNumber == i.index }">
					<span class="text-primary px-2" style="font-size: 15pt; font-weight: bold; border:1px solid rgba(0,0,0,0.1);">
						${ i.index + 1 }
					</span>
				</c:if>
				<c:if test="${ pageNumber != i.index }">
					<a href="#none" class="px-2" title="${ i.index + 1 }페이지" onclick="goPage(${ i.index })"
						style="font-size: 15pt; color: gray; text-decoration: none;">
						${ i.index + 1 }
					</a>&nbsp;
				</c:if>
			</c:forEach> 
			<c:if test="${ pageNumber == bbsPage - 1 }">
				<span class="mx-4" style="color: rgba(0,0,0,0.3);">다음 <i class="fas fa-chevron-right"></i></span>
			</c:if>
			<c:if test="${ pageNumber != bbsPage - 1 }">
				<a class="mx-4" style="text-decoration: none; cursor: pointer; color: gray;" onclick="goPage(${ pageNumber + 1 })">다음 <i class="fas fa-chevron-right"></i></a>
			</c:if>
			
		</c:otherwise>
	</c:choose>
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
			<input type="text" id="search" class="form-control" value="${ search }">
			<button class="btn btn-primary" onclick="searchBbs()" type="button">검색</button>
		</div>
	</div>
</div>

<div class="mt-5">
	<span class="btn btn-primary" onclick="writeBbs()" style="cursor: pointer;">글쓰기</span>
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
function writeBbs() {
	if('${ login }') {
		location.href = "bbswrite.do";
	} else {
		alert("로그인이 필요합니다.")
		location.href = "login.do";
	}
	
}

function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;

	location.href = "bbslist.do?choice=" + choice + "&search=" + search;
}
function goPage( pageNum ) {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "bbslist.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNum;
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