<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
footer {
	text-align: center;
	width: 1000px;
	height: 180px;
	margin: auto;
	font-size: 11px;
}

div {
	box-sizing: border-box;
	font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
}

a {
	color: black;
	text-decoration: none;
	text-align: center;
}

#wrapper {
	width: 100%;
	height: 300px;
	margin: 0 auto;
}

#home {
	color: black;
	height: 100%;
	width: 100%;
	text-align: center;
	font-size: 70px;
}

#head1 {
	background: white;
	height: 20px;
}

#img {
	width: 80px;
	height: 80px;
}

#top {
	color: black;
	text-align: right;
	float: right;
}

#top:before {
	content: "|";
}

#navigator {
	height: 50px;
}

#contents {
	height: 800px;
}

input {
	border: none;
}

#aside_top {
	width: 100%;
	height: 55%;
}

#aside_bottom {
	width: 100%;
	height: 30%;
}

#menu {
	margin: 0;
	padding: 0;
	list-style-type: none
}

#menu ul {
	list-style-type: none;
}

#sub1 {
	position: absolute;
	margin: 0;
	padding: 0;
	list-style-type: none;
	opacity: 0;
	visibility: hidden;
}

#sub1>li {
	padding: 16px; 28 px;
	border-bottom: 1px solid rgba(0, 0, 0, 0.15);
}

#sub1>li>a {
	color: black;
	text-decoration: none;
}

#menu>li:hover #sub1 {
	opacity: 1;
	visibility: visible;
}

#menu li {
	width: 28%;
	height: 100%;
	float: left;
	text-align: center;
	line-height: 40px;
	color: black;
	list-style-type: none;
}

#menu>li>a {
	display: block;
	padding: 8px 16px;
	text-align: center;
}

#img_top {
	width: 100%;
	height: 50%;
}

#top_left {
	width: 50%;
	height: 100%;
	float: left;
}

#top_right {
	width: 50%;
	height: 100%;
	float: left;
}

#img_bottom {
	width: 100%;
	height: 50%;
}

#bottom_left {
	width: 50%;
	height: 100%;
	float: left;
}

#bottom_right {
	width: 50%;
	height: 100%;
	float: left;
}

img {
	margin: 9px 9px 0px 9px;
	width: 95%;
	height: 90%;
}

.imgCaption {
	text-align: center;
	line-height: 9px;
}

body {
	font-size: 11pt;
	padding: 0;
	margin: 0;
	text-align: center;
}

h3 {
	color: #85144b;
	font-size: 14pt;
	margin: 10 auto;
	padding: 10px;
}

.contents {
	width: 800px;
	height: 300px;
	background-color: white;
	margin: 0 auto;
}

/*  navigator */
nav {
	font-family: "Roboto", serif;
	width: 1200px;
	display: flex;
	justify-content: center;
	background-color: black;
	position: relative;
	margin: auto;
}

ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

#main-menu>li {
	float: left;
	position: relative;
}

#main-menu>li>a {
	font-size: 0.85rem;
	color: rgba(255, 255, 255, 0.85);
	text-align: center;
	text-decoration: none;
	letter-spacing: 0.05em;
	display: block;
	padding: 14px 36px;
	border-right: 1px solid rgba(0, 0, 0, 0.15);
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.2);
}

#main-menu>li:nth-child(1)>a {
	border-left: 1px solid rgba(0, 0, 0, 0.15);
}

#sub-menu {
	position: absolute;
	background: black;
	text-align: center;
	opacity: 0;
	visibility: hidden;
	transition: all 0.15s ease-in;
}

#sub-menu>li {
	padding: 10px 28px;
	border-bottom: 1px solid rgba(0, 0, 0, 0.15);
	border-bottom: 1px solid rgba(0, 0, 0, 0.15);
}

#sub-menu>li>a {
	color: rgba(255, 255, 255, 0.6);
	text-decoration: none;
}

#main-menu>li:hover #sub-menu {
	opacity: 10;
	visibility: visible;
}

#sub-menu>li>a:hover {
	text-decoration: underline;
}

/* footer */
.img_go {
	float: left;
}

.vertical {
	border-left: 1px solid grey;
	height: 175px;
	position: absolute;
}

div.footer {
	width: 25%;
	float: left;
}

/* freeboard */
ul, li {
	line-height: 2em;
	font-family: "맑은 고딕";
	list-style: none;
	text-align: center;
	padding: 0;
	margin: 0;
}

#mainWrapper {
	width: 800px;
	margin: 0 auto; /*가운데 정렬*/
}

#mainWrapper>ul>li:first-child {
	text-align: center;
	font-size: 14pt;
	height: 40px;
	vertical-align: middle;
	line-height: 30px;
}

#ulTable {
	margin-top: 10px;
	width: 1000px;
	margin: auto;
}

#ulTable>li:first-child>ul>li {
	background-color: #272727;
	font-weight: bold;
	text-align: center;
	color: white;
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

.searchbox {
	width: 900px;
	height: 100px;
	left: 795px;
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

#pageNavi {
	width: 100%;
	position: relative;
	float: left;
}
</style>

</head>


<body>
	<div id="wrapper">
		<div id="head">
			<div id="head1">
				<a href="/view/member/cs.html" id="top">고객센터</a> <a href="#"
					id="top">장바구니</a> <a href="/view/member/enroll.html" id="top">회원가입</a>
				<a href="/view/member/login.jsp" id="top">로그인</a>

			</div>
			<a href="/index.jsp" id="home"> <img src="/img/logo.png" id="img"
				width="100" height="100">To:geDog
			</a><br>
		</div>

		<nav role="navigation" style="text-align: center;">
			<ul id="main-menu">
				<li><a href="#">SHOPPING</a>
					<ul id="sub-menu">
						<li><a href="#">사료 & 간식</a></li>
						<li><a href="#">의류 제품</a></li>
						<li><a href="#">장난감</a></li>
					</ul></li>
				<li><a href="#">BOOKING</a>
					<ul id="sub-menu">
						<li><a href="reservationDetail.html">예약문의</a></li>
						<li><a href="photoshoot.html">포토 슛</a></li>
						<li><a href="#">포토 후기</a></li>
					</ul></li>
				<li><a href="board.html">BOARD</a>
					<ul id="sub-menu">
						<li><a href="/notice/list">QnA 게시판</a></li>
						<li><a href="/freeboard/list">자유게시판</a></li>
						<li><a href="/comboard/list">정보 공유</a></li>
					</ul></li>
			</ul>
		</nav>

	</div>

	<h1>QnA 게시판</h1>

	<ul id="ulTable">
		<li>
			<ul>
				<li>글번호</li>
				<li>글제목</li>
				<li>작성자</li>
				<li>작성일</li>
				<li>조회수</li>
			</ul>
		</li>
		<!-- 게시물이 출력될 영역 -->
		<li><c:forEach items="${nList }" var="notice" varStatus="index">
		
				<ul>
					<li>${notice.noticeNo }</li>
					<li><a href="/notice/select?noticeNo=${notice.noticeNo }"
						onclick="return checkPerm('${notice.userId }');">${notice.subject }</a></li>
					<li>${notice.userId }</li>
					<li>${notice.regDate }</li>
					<li>${notice.readcount }</li>
				</ul>
				
			</c:forEach></li>
	</ul>
	<br>
	<br>
	<div id="pageNavi">${pageNavi }</div>
	<br>
	<br>
	<br>

	<script>
		function checkPerm(userId) {
			var memberId = '${sessionScope.member.userId }';
			if ( memberId != 'munji' && userId != memberId ) {
				alert("관리자 및 작성자만 볼 수 있습니다.");
				return false;	
			}
		}
	</script>


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

	<br>


	<br>
	<br>
	<br>
	<br>
	<br>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>

	<footer>
		<div class="footer">
			<p style="font-size: 16px;">
				고객센터<br> <img
					src="https://cdn.onlinewebfonts.com/svg/img_1059.png"
					style="width: 35px; height: 35px;">02-123-4567
			</p>
			운영시간: 오전 09:00 ~ 오후 06:00<br> 주말, 공휴일은 휴무일입니다.
		</div>


		<div class="footer">
			<div class="vertical"></div>
			<p style="font-size: 16px;">입금계좌</p>
			국민 523202 - 04 - 030162<br> 예금주: 김수연<br>

			<p style="font-size: 16px;">후원계좌</p>
			국민 523202 - 04 - 030162<br> 예금주: 김수연<br>

		</div>
		<div class="footer">
			<div class="vertical"></div>
			<p style="font-size: 16px;">바로가기</p>
			<a href="#">
				<div class="img_go" style="padding-left: 20px;">
					<div>
						<img src="https://cdn.onlinewebfonts.com/svg/img_108495.png"
							style="width: 35px; height: 35px;">
					</div>
					<div style="width: 50px;">장바구니</div>
				</div>
			</a> <a href="#">
				<div class="img_go">
					<div>
						<img src="https://cdn.onlinewebfonts.com/svg/img_214830.png"
							style="width: 35px; height: 35px;">
					</div>
					<div style="width: 50px;">후원하기</div>
				</div>
			</a> <a href="#">
				<div class="img_go">
					<div>
						<img src="https://cdn.onlinewebfonts.com/svg/img_377674.png"
							style="width: 35px; height: 35px;">
					</div>
					<a href="#"><div style="width: 50px;">주문조회</div></a>
				</div>
			</a> <a href="/notice/list">
				<div class="img_go">
					<div>
						<img src="https://cdn.onlinewebfonts.com/svg/img_377768.png"
							style="width: 35px; height: 35px;">
					</div>
					<div style="width: 50px;">공지사항</div>
				</div>
			</a>
		</div>

		<div class="footer">
			<div class="vertical"></div>
			<p style="font-size: 16px;">회사소개 | 이용안내 | 이용약관</p>
			상호 : To:geDog | 비선실세 : 김수연<br> 주소 : 서울특별시 중구 남대문로 120 대일빌딩<br>
			메일 semi@togedog.co.kr<br> 팩스 : 02-1236-4567<br> 사업자등록번호 :
			123-45-67890

		</div>
	</footer>
</body>

</html>