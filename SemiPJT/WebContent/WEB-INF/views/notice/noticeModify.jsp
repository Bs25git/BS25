<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<title>To:geDog - Q&A - 수정</title>
</head>

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
	height: 650px;
	text-align: center;
	margin: 0 auto;
	position: relative;
	bottom: 35px;
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

#legendtitle {
	text-align: left;
	font-size: 24px;
	font-weight: bold;
}

#boardTitle, #boardContent {
	text-align: left;
	position: relative;
	left: 158px;
	font-weight: bold;
	font-size: 20px;
}

#btnModify {
	width: 140px;
	height: 40px;
	background-color: black;
	color: white;
	font-size: 15px;
	font-weight: 1000;
	border-top-left-radius: 15px;
	border-top-right-radius: 15px;
	border-bottom-right-radius: 15px;
	border-bottom-left-radius: 15px;
	border: none;
	margin-right: 30px;
}

#btnList {
	width: 140px;
	height: 40px;
	background-color: darkgray;
	color: black;
	border-top-left-radius: 15px;
	border-top-right-radius: 15px;
	border-bottom-right-radius: 15px;
	border-bottom-left-radius: 15px;
	border: none;
	margin-left: 30px;
}
</style>



<body>
	<div id="wrapper">
		<div id="header"></div>
		<div id="nav"></div>
		<div id="contents">
			<p style="text-align: right; font-size: 13px;">홈 > 정보공유 게시판 > 게시글
				수정</p>
			<form action="/notice/modify" method="post">
				<legend id="legendtitle">게시글 수정</legend>
				<hr>
				<br>
				<p id="textP">제목</p>
				<input type="text" size="108" name="subject"
					value="${notice.subject }" style="border: 1px solid black;"><br>
				<br>
				<p id="textP">내용</p>
				<textarea rows="20" cols="110" name="content">${notice.contents }</textarea>
				<br> <br> <input type="hidden" name="noticeNo"
					value="${notice.noticeNo }"> <input type="submit"
					onclick="return modify();" value="수정하기" id="btnModify"> <input
					type="reset" value="취소" id="btnList"
					onclick="javascript:history.back();">
			</form>
		</div>

		<%-- <h1>공지사항 수정</h1>
	<!-- UPDATE NOTICE SET SUBJECT = 'test' AND CONTENTS = 'test' WHERE NOTICENO = ? -->
	<form action="/notice/modify" method="post">
		<input type="text" size="100" name="subject" value="${notice.subject }"><br><br>
		<textarea rows="30" cols="100" name="content">${notice.contents }</textarea><br><br>
		<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
		<input type="submit" value="수정하기">
		<input type="button" onclick="javascript:history.back();" value="취소">
	
	</form> --%>
		<br> <br>
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
		<script>
			function modify() {
				var result = confirm("게시글을 수정 하시겠습니까?");
				if (result) {
					return true;
				} else {
					return false;
				}
			}
		</script>
	</div>
</body>
</html>