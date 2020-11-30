<%@ page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<title>To:geDog - Q&A - 게시글</title>

<style>
div {
	font-family: 맑은고딕;
}

#wrapper {
	width: 1890px;
	margin: 0 auto;
	padding: 0 auto;
}

#contents {
	width: 1200px;
	height: 700px;
	margin: 0 auto;
	position: relative;
	bottom: 35px;
}

#legendtitle {
	text-align: left;
	font-size: 24px;
	font-weight: bold;
}

#textP {
	text-align: left;
	position: relative;
	left: 190px;
	font-weight: 1000;
	font-size: 20px;
}

#textA {
	text-align: left;
	position: relative;
	left: 190px;
	font-size: 12px;
}

#buttonM, #buttonD {
	width: 90px;
	height: 30px;
	background-color: black;
	color: white;
	font-size: 13px;
	font-weight: 1000;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-right-radius: 8px;
	border-bottom-left-radius: 8px;
	float: left;
	margin: 5px;
}

#buttonL {
	width: 130px;
	height: 30px;
	font-size: 13px;
	background-color: darkgray;
	color: black;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-right-radius: 8px;
	border-bottom-left-radius: 8px;
	float: left;
	margin: 5px;
}

#comments {
	text-align: center;
	left: 15%;
	position: relative;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>
		<div id="nav"></div>
		<div id="contents">
	<p style="text-align: right; font-size: 13px;">홈 > Q&A > 게시글</p>
		<div id="div1" style="text-align: center;">
			<legend id="legendtitle">Q & A</legend>
			<br>
			<hr>
			<br>
	
	
	<c:if test="${sessionScope.member.memberId eq 'munji' || content.userId eq sessionScope.member.memberId }">
			<p id="textP">제목 : ${content.subject } </p>
			<p id="textA">글번호 :글번호 : ${content.noticeNo } / 글쓴이 : ${content.userId } / 작성일 : ${content.regDate } / 조회수 : ${content.readcount }<p/>
		<textarea rows="10" cols="72" name="content">${content.contents }</textarea>
			<br>
			
			
			
		<a>작성자 : 관리자 | 답변 내용 :  ${comment.contents } | 작성일 :  ${comment.regDate }</a><br><br>

	</c:if>

	<c:if test="${sessionScope.member.memberId ne 'munji' && content.userId ne sessionScope.member.memberId }">
	
		<script>
		function back(){
			alert("관리자 및 작성자만 볼 수 있습니다.");
			location.href="/notice/list";
		}
	
	</script>
	<body onload = "back()"></body>
	
	</form>
		
	</c:if>
<%-- 	<c:if test="${content.passwd == passwd}">
	<h2>제목 : ${content.subject } </h2>
	<h6>글번호 : ${content.noticeNo } / 글쓴이 : ${content.userId } / 작성일 : ${content.regDate } / 조회수 : ${content.readcount }</h6>
	<h3>${content.contents }</h3>
	</c:if> --%>
	<!-- 수정버튼 누르면 수정페이지로 이동, (DB에 다시 쿼리하여 데이터를 가져옴)
	내가 작성한 내용을 확인한 후에 수정하기 버튼을 누르면 수정이 완료됨 -->
	
	
	<c:if test="${sessionScope.member.memberId eq 'munji' || content.userId eq sessionScope.member.memberId }">
   <form action="/notice/commentinsert" method="post">
   	<textarea rows="200" cols="200" name="contents"></textarea><br>
   	<input type="hidden" name="userId" value="${content.userId }">
    <input type="hidden" name="noticeNo" value="${content.noticeNo }">
	<input type="submit" value="완료" onclick="reload()">

	</form>
	
	<script>
		function reload(){
			var noticeNo = '${content.noticeNo }'
			alert("답글을 등록하시겠습니까?");
		}
	</script>
	<a href="/notice/modifyform?noticeNo=${content.noticeNo }">수정</a>
	<a href="/notice/list">목록</a>
	
	
	<script>
      function question() {
         return confirm("삭제하시겠습니까?");
      }
      
   </script>
   <a href="/notice/delete?noticeNo=${content.noticeNo }" onclick="return question();">삭제</a>
   </c:if>
   
   
   
<br><br>
	<hr>
	<div id="footer"></div>

	<script type="text/javascript">
	/* include */
	$(document).ready(function() {
				$("#header").load("/include/headerWeb.jsp")
				$("#nav").load("/include/navWeb.jsp")
				$("#footer").load("/include/footerWeb.html")
			});
</script>
</div>
</body>
</html>