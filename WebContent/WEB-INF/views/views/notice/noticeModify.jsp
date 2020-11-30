<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>
	<h1>공지사항 수정</h1>
	<!-- UPDATE NOTICE SET SUBJECT = 'test' AND CONTENTS = 'test' WHERE NOTICENO = ? -->
	<form action="/notice/modify" method="post">
		<input type="text" size="100" name="subject" value="${notice.subject }"><br><br>
		<textarea rows="30" cols="100" name="content">${notice.contents }</textarea><br><br>
		<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
		<input type="submit" value="수정하기">
		<input type="button" onclick="javascript:history.back();" value="취소">
	
	</form>
</body>
</html>