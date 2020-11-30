<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세내용</title>
<style>
	textarea{
		width : 300px;
		height : 100px;
	}
	a{
		color:black;
		
	}

</style>
</head>
<body>
	
	<c:if test="${sessionScope.member.userId eq 'munji' || content.userId eq sessionScope.member.userId }">
		<h2>제목 : ${content.subject } </h2>
		<h6>글번호 : ${content.noticeNo } / 글쓴이 : ${content.userId } / 작성일 : ${content.regDate } / 조회수 : ${content.readcount }</h6>
		<h3>${content.contents }</h3><hr>
		
		<a>작성자 : 관리자 | 답변 내용 :  ${comment.contents } | 작성일 :  ${comment.regDate }</a><br><br>

	</c:if>

	<c:if test="${sessionScope.member.userId ne 'munji' && content.userId ne sessionScope.member.userId }">
	
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
	
	
	<c:if test="${sessionScope.member.userId eq 'munji' || content.userId eq sessionScope.member.userId }">
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
</body>
</html>