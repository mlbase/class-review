<%@page import="mul.com.sc.dto.RevBbsDto"%>
<%@page import="mul.com.sc.dto.PdsDto"%>
<%@page import="mul.com.sc.dto.BbsDto"%>
<%@page import="mul.com.sc.dto.NoticeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	List<BbsDto> bbsList = (List<BbsDto>)request.getAttribute("bbslist");
	List<RevBbsDto> revList = (List<RevBbsDto>)request.getAttribute("revlist");
	List<PdsDto> pdsList = (List<PdsDto>)request.getAttribute("pdslist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
    <div class="row">
    	<div class="col-xs-1 col-md-12 mt-2">
        	<img src="images/banner.jpg" width="1250">
        </div>
        <div class="col-md-4 my-5 d-flex flex-column justify-content-between align-items-center">
        	<img class="mb-5" src="images/study.png" width="70" height="70">
        	<span class="mb-3 fs-4">당신이 원하는 스터디 후기찾기</span>
        	<span class="fs-6 px-4">나와같은 관심사의 스터디를 하는 구성원들의 후기를 찾을수 있어요</span>
        </div>
        <div class="col-md-4 my-5 d-flex flex-column justify-content-between align-items-center">
        	<img class="mb-5" src="images/computer.png" width="70" height="70">
        	<span class="mb-3 fs-4">같은 공부를 하는 사람들과의 소통</span>
        	<span class="fs-6 px-4">같은 목적을 가지고 공부를 하는사람들과 함께 공감하며 목표를 이루어 나갈 수 있어요</span>
        </div>
        <div class="col-md-4 my-5 d-flex flex-column justify-content-between align-items-center">
        	<img class="mb-5" src="images/book.png" width="70" height="70">
        	<span class="mb-3 fs-4">어떻게 시작해야 할지 막막할 때</span>
        	<span class="fs-6 px-4">원하는 공부법을 찾지 못하셨나요? 여러 사람들과 방법을 공유하여 계획을 세워보세요</span>
        </div>
        <div class="col-xs-12 bg-light d-flex justify-content-between px-4 py-2 my-5">
        	<c:if test="${ notice == null }">
        	
        	</c:if>
        	<c:if test="${ notice != null }">
        		<span class="badge rounded-pill bg-dark">공지</span>
	        	<a class="text-dark" href="noticedetail.do?seq=${ notice.seq }" style="text-decoration: none;"><span>${ notice.title }</span></a>
	        	<span id="notice_time"></span>
        	</c:if>
        </div>
        <div class="col-xs-12 d-flex justify-content-center mb-3">
        	<h4>이런 게시글은 어때요</h4>
        </div>
        <div class="col-md-4 p-4 d-flex flex-column justify-content-between" style="height: 350px;">
        	<span class="fs-5 mb-3">자유게시판</span>
        	<div class="mb-2 d-flex flex-column justify-content-start" style="height: 150px;">
				<c:choose>
				    <c:when test="${bbslist == null || fn:length(bbslist) == 0}">
			        	<span class="fs-6">작성된 글이 없습니다.</span>
				    </c:when>
				    <c:otherwise>
				        <c:forEach begin="0" var="bbs" items="${ bbslist }" varStatus="i">
					        <div class="d-flex justify-content-between">
					        	<a class="fs-6 mb-2 text-dark" style="text-decoration: none;" href="bbsdetail.do?seq=${ bbs.seq }"><span>${ bbs.title }</span></a>
			        			<span class="bbs_time" style="font-size: 13px; color: gray;">1일 전</span>
					        </div>
						</c:forEach>
				    </c:otherwise>
				</c:choose>
			</div>
			<a href="bbslist.do" class="btn btn-primary mt-3" type="button">게시판 바로가기</a>
        </div>
        <div class="col-md-4 p-4 d-flex flex-column justify-content-between" style="height: 350px;">
        	<span class="fs-5 mb-3">후기게시판</span>
        	<div class="mb-2 d-flex flex-column justify-content-start" style="height: 150px;">
				<c:choose>
				    <c:when test="${revlist == null || fn:length(revlist) == 0}">
			        	<span class="fs-6">작성된 글이 없습니다.</span>
				    </c:when>
				    <c:otherwise>
				        <c:forEach begin="0" var="rev" items="${ revlist }" varStatus="i">
				        	<div class="d-flex justify-content-between">
				        		<a class="fs-6 mb-2 text-dark" style="text-decoration: none;" href="revdetail.do?seq=${ rev.seq }"><span>${ rev.title }</span></a>
			        			<span class="rev_time" style="font-size: 13px; color: gray;">20시간 전</span>
				        	</div>
						</c:forEach>
				    </c:otherwise>
				</c:choose>
			</div>
			<a href="revbbs.do" class="btn btn-primary mt-3" type="button">게시판 바로가기</a>
        </div>
        <div class="col-md-4 p-4 d-flex flex-column justify-content-between" style="height: 350px;">
        	<span class="fs-5 mb-3">공부자료실</span>
        	<div class="mb-2 d-flex flex-column justify-content-start" style="height: 150px;">
				<c:choose>
				    <c:when test="${ fn:length(pdslist) == 0}">
				    	<div class="d-flex justify-content-center align-items-center">
				    		<span class="fs-5">작성된 글이 없습니다.</span>
				    	</div>
				    </c:when>
				    <c:otherwise>
				        <c:forEach begin="0" var="pds" items="${ pdslist }" varStatus="i">
				        	<div class="d-flex justify-content-between">
				        		<a style="text-decoration: none;" class="fs-6 mb-2 text-dark" href="pdsdetail.do?seq=${ pds.seq }"><span>${ pds.title }</span></a>
				        		<span class="pds_time" style="font-size: 13px; color: gray;">1일 전</span>
			        		</div>
						</c:forEach>
				    </c:otherwise>
				</c:choose>
			</div>
			<a href="pdslist.do" class="btn btn-primary mt-3" type="button">게시판 바로가기</a>
        </div>
    </div>
</div>

<script type="text/javascript">
const bbsTime = document.querySelectorAll(".bbs_time");
const revTime = document.querySelectorAll(".rev_time");
const pdsTime = document.querySelectorAll(".pds_time");

$('#notice_time').html(displayedAt('${ notice.regDate }'))
let i = 0;
let j = 0;
let k = 0;
</script>
<%
for(int i = 0; i < bbsList.size(); i++) {
	%>
	<script type="text/javascript">
		bbsTime[i].innerText = displayedAt('<%=bbsList.get(i).getRegdate() %>')
		i++;
	</script>
	<%
}
%>
<%
for(int i = 0; i < revList.size(); i++) {
	%>
	<script type="text/javascript">
		revTime[j].innerText = displayedAt('<%=revList.get(i).getRegdate() %>')
		j++;
	</script>
	<%
}
%>
<%
for(int i = 0; i < pdsList.size(); i++) {
	%>
	<script type="text/javascript">
		pdsTime[k].innerText = displayedAt('<%=pdsList.get(i).getRegdate() %>')
		k++;
	</script>
	<%
}
%>




</body>
</html>