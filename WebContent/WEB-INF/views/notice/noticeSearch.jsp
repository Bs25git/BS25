<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>To:geDog - Q&A - 검색결과</title>
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

#legendtitle {
	text-align: left;
	font-size: 24px;
	font-weight: bold;
}

.ulTable, .liTable {
	line-height: 2em;
	font-family: "맑은 고딕";
	list-style: none;
	text-align: center;
	padding: 0;
	margin: 0;
}

#ulTable {
	margin-top: 10px;
	width: 1000px;
	margin: auto;
}

#ulTable>li:first-child>ul>li {
	background-color: white;
	font-weight: bold;
	text-align: center;
	color: black;
	font-size: 16px;
}

#ulTable>li>ul {
	clear: both;
	padding: 0px auto;
	position: relative;
	min-width: 40px;
}

#ulTable>li>ul>li {
	float: left;
	font-size: 10pt;
	border-bottom: 1px solid silver;
	vertical-align: baseline;
}

#ulTable>li>ul>li:first-child {
	width: 5%;
} /*No 열 크기*/
#ulTable>li>ul>li:first-child+li {
	width: 70%;
} /*제목 열 크기*/
#ulTable>li>ul>li:first-child+li+li {
	width: 8%;
} /*작성일 열 크기*/
#ulTable>li>ul>li:first-child+li+li+li {
	width: 10%;
} /*작성자 열 크기*/
#ulTable>li>ul>li:first-child+li+li+li+li {
	width: 7%;
} /*조회수 열 크기*/
#divPaging {
	clear: both;
	margin: 0 auto;
	width: 220px;
	height: 50px;
}

#divPaging>div {
	float: left;
	width: 30px;
	margin: 0 auto;
	text-align: center;
}

#liSearchOption {
	clear: both;
}

#liSearchOption>div {
	margin: 0 auto;
	margin-top: 30px;
	width: auto;
	height: 100px;
}

#txtKeyWord {
	border: 0.1px solid #272727;
	border-bottom-right-radius: 1px;
	border-bottom-left-radius: 1px;
	border-top-right-radius: 1px;
	border-top-left-radius: 1px;
}

/* 검색창 */
.searchbox {
	width: 1000px;
	height: 100px;
	left: 37%;
	position: relative;
}

#searchOption {
	width: 70px;
	height: 95px;
	float: left;
}

#searchWord {
	width: 230px;
	height: 95px;
	float: left;
}
/* 페이징 */
#pageNavi {
	width: 100%;
	position: relative;
	text-align: center;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>
		<div id="nav"></div>
		<div id="contents">
			<p style="text-align: right; font-size: 13px;">홈 > Q&A</p>
			<legend id="legendtitle">Q & A - 검색결과</legend>
			<br>
			<hr>
			<br>
			<br>

			<ul id="ulTable">
				<li class="liTable">
					<ul class="ulTable">
						<li class="liTable">글번호</li>
						<li class="liTable">글제목</li>
						<li class="liTable">작성자</li>
						<li class="liTable">작성일</li>
						<li class="liTable">조회수</li>
					</ul>
				</li>
				<!-- 게시물이 출력될 영역 -->
				<li class="liTable"><c:forEach items="${fList }" var="notice"
						varStatus="index">
						<ul class="ulTable">
							<li class="liTable">${notice.noticeNo }</li>
							<li class="liTable"><a
								href="/comboard/select?comNoticeNo=${notice.noticeNo }">${notice.subject }</a></li>
							<li class="liTable">${notice.userId }</li>
							<li class="liTable">${notice.regDate }</li>
							<li class="liTable">${notice.readcount }</li>
						</ul>

					</c:forEach></li>
			</ul>
			<br> <br>
			<div id="pageNavi">${PageNavi }</div>
			<br> <br>


			<!-- 검색 폼 영역 -->

			<div class="searchbox">
				<div id="searchOption">
					<select id='selSearchOption'>
						<option value='A'>작성자</option>
					</select>


				</div>

				<div id="searchWord">
					<form action="/notice/search" method="get">
						<input id='txtKeyWord' type="text" name="search"> <input
							type="submit" value="검색">
					</form>
				</div>
				<form action="/notice/writeform" method="get">
					<input type="submit" value="새글작성"
						style="position: relative; left: 20px;">
				</form>
			</div>
		</div>
		
	<%-- <table border ="1">
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
	</table> --%>
	<br> <br>
		<hr>
		<div id="footer"></div>

		<script type="text/javascript">
			/* include */
			$(document).ready(function() {
				$("#header").load("/include/header.jsp")
				$("#nav").load("/include/nav.html")
				$("#footer").load("/include/footer.html")
			});
		</script>
	</div>
</body>

</html>