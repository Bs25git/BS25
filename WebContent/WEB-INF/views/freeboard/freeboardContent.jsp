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
<title>To:geDog - 자유게시판 - 게시글</title>

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
			<p style="text-align: right; font-size: 13px;">홈 > 자유게시판 > 게시글</p>
			<div id="div1" style="text-align: center;">
				<legend id="legendtitle">자유게시판</legend>
				<br>
				<hr>
				<br>

				<p id="textP">제목 : ${content.freeSubject }</p>
				<p id="textA">글번호 : ${content.freeNoticeNo } / 글쓴이 :
					${content.freeUserId }  / 작성일 :
					${content.freeRegDate } / 조회수 : ${content.freeReadCount }</p>
				<textarea rows="20" cols="110" name="content">${content.freeContents }</textarea>
				<br>
				
				
				<div style="position: relative; left: 662px">
				<c:if test="${sessionScope.member.userId eq content.freeUserId }">
					<a
						href="/freeboard/modifyform?freeNoticeNo=${content.freeNoticeNo }"><input
						type="button" value="수정하기" id="buttonM"></a> <a
						href="/freeboard/delete?freeNoticeNo=${content.freeNoticeNo }"
						onclick="return deleteConfirm();"> <input type="submit"
						value="삭제하기" id="buttonD"></a>
						
						</c:if>
						 <a href="/freeboard/list"><input
						type="button" value="목록으로 돌아가기" id="buttonL"
						onclick="javascript:history.back();"></a>
				</div>
			</div>
			<script>
				function deleteConfirm() {
					return confirm("게시글을 정말로 삭제하시겠습니까?");
				}
			</script>
			<br> <br> <br> <br>


			<div id="comments">
				<table>
					<tr>
						<th colspan="2">댓글 목록</th>
					</tr>
				</table>
				<form action="BoardServlet" method="post" name="check">
					<input type="hidden" name="command" value="comment_write">
					<input type="hidden" name="pnum" value="${param.num }">
					<table style="font-size: 10px;">
						<tr>
							<th>댓글</th>
							<br>
							<td><textarea rows="1" cols="100" name="c_content"></textarea></td>

							<td><a href="/freeboard/commentwrite"><input
									type="button" value="댓글달기" id="buttonM"></a></td>
						</tr>
					</table>
				</form>

				<c:forEach var="i" begin="1" end="${totalCount }" step="1">
					<a
						href="BoardServlet?command=board_view&num=${param.num }&page=${i}"></a>
				</c:forEach>

			</div>
		</div>
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