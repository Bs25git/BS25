<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
		<h1>공지사항</h1>
	<table border ="1">
	<tr><th>글번호</th><th>글제목</th>
	<th>글쓴이</th><th>작성일</th><tr>
	<c:forEach items="${nList }" var="notice" varStatus="index">
	 <tr>
	 	<td>${notice.noticeNo }</td>
<!-- 	 	하나의 게시글에 대한 내용을 검색하기 위해서 noticeNo를 서블릿으로 넘겨줌
 -->	 	<td><a href="/notice/select?noticeNo=${notice.noticeNo}">${notice.subject }</a></td>
	 	<td>${notice.userId }</td>
	 	<td>${notice.regDate }</td>
	 
	 </tr>
	 </c:forEach>
	 <tr>
	 	<td colspan="3" align="center">
	 	<!-- 검색어를 Servlet을 보내서
	 	-> DB에서 LIKE 검색한 후에(한글자만 입력해도 검색이 되도록함)
	 	-> 그 결과값을 noticeSearch.jsp로 보내줌 -->
	 	<form action="/notice/search" method="get">
	 		<input type="text" name="search">
	 		<input type="submit" value="검색">
	 	</form>
	 </td>
	 	<td align="right">
	 	<form action="/notice/writeform" method="get">
	 		<input type="submit" value="글쓰기">
	 	</form>
	 	</td>
	 </tr>
	<tr>
	 <td colspan = "4" align="center">
	 	${pageNavi }
	 </tr>
	</table>
</body>
</html>