<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
<meta charset="UTF-8">
<title>To:geDog - 정보공유 게시판</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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
	margin: 0 auto;
	position: relative;
	bottom: 35px;
	text-align: center;
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
	position: relative;
	left: -0%;
}

#ulTable {
	margin-top: 10px;
	width: 1060px;
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
	width: 7%;
} /*No 열 크기*/
#ulTable>li>ul>li:first-child+li {
	width: 66%;
} /*제목 열 크기*/
#ulTable>li>ul>li:first-child+li+li {
	width: 10%;
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
			<p style="text-align: right; font-size: 13px;">홈 > 정보공유 게시판</p>
			<legend id="legendtitle">정보공유 게시판</legend>
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
				<li class="liTable"><c:forEach items="${cList }" var="comboard"
						varStatus="index">
						<ul class="ulTable">
							<li class="liTable">${comboard.comNoticeNo }</li>
							<li class="liTable"><a
								href="/comboard/select?comNoticeNo=${comboard.comNoticeNo }">${comboard.comSubject }</a></li>
							<li class="liTable">${comboard.comUserId }</li>
							<li class="liTable">${comboard.comRegDate }</li>
							<li class="liTable">${comboard.comReadcount }</li>
						</ul>
					</c:forEach></li>
			</ul>
			<br> <br>
			<div id="pageNavi">${pageNavi }</div>
			<br> <br> <br>

			<!-- 검색 폼 영역 -->

			<div class="searchbox">
				<div id="searchOption">
					<select id='selSearchOption'>
						<option value='A'>작성자</option>
					</select>
				</div>
				<div id="searchWord">
					<form action="/comboard/search" method="get">
						<input id='txtKeyWord' type="text" name="search"> <input
							type="submit" value="검색">
					</form>
				</div>
				<form action="/comboard/writeform" method="get">
					<input type="submit" value="새글작성"
						style="position: relative; left: 20px;">
				</form>
			</div>
		</div>
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
	</div>
</body>

</html>