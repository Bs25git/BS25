<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<title>정보공유 게시판</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
footer {
	text-align: center;
	width: 1000px;
	height: 180px;
	margin: auto;
	font-size: 11px;
	position: relative;
	right: 65px;
}

.vertical {
	border-left: 1px solid silver;
	height: 175px;
	position: absolute;
}

div.footer {
	width: 25%;
	float: left;
}


div {
	box-sizing: border-box;
	font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
}

a {
	color: black;
	text-decoration: none;
	display: block;
	text-align: center;
}

#wrapper {
	width: 100%;
	height: 300px;
	margin: 0 auto;
}

#home {
	color: black;
	text-align: center;
	font-size: 70px;
	float: right;
}

#head1 {
	background: white;
	height: 20px
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

div {
	box-sizing: border-box;
}

a {
	text-decoration: none;
	display: block;
}

#wrapper {
	width: 900px;
	margin: 0 auto;
}

#head a:hover {
	text-decoration: none;
	color: black;
}

#navigator {
	height: 30px;
}

#contents {
	height: 600px;
	width: 900px;
	text-align: center;
}

#footer {
	width: 900px;
	height: 200px;
}

input {
	border: none;
}

#menu {
	margin: 0;
	padding: 0;
	height: 100%;
	overflow: hidden;
}

#menu li {
	width: 30%;
	height: 100%;
	float: left;
	text-align: center;
	line-height: 40px;
	color: black;
	list-style-type: none;
}

#menu ul {
	content: "|";
}

#formQuestion {
	text-align: center;
	border: none;
}

#line {
	width: 500px;
}

#textBox {
	width: 70px;
	height: 30px;
	border: 1px solid black;
	text-align: center;
}

.selectBox {
	width: 70px;
	height: 33px;
}

#option {
	float: right;
	font-size: 15px;
	background-color: white;
}

#text {
	font-size: 25px;
	font-weight: 1000;
}

#div1 {
	float: left;
	width: 25%;
}

#div2 {
	float: left;
	width: 33.3%;
}

h5 {
	color: slategray;
	font-weight: 1000;
}

#button2, #button1 {
	width: 200px;
	height: 50px;
	background-color: black;
	color: white;
	font-size: 15px;
	font-weight: 1000;
	border-top-left-radius: 15px;
	border-top-right-radius: 15px;
	border-bottom-right-radius: 15px;
	border-bottom-left-radius: 15px;
}

#div3 {
	position: relative;
	bottom: 50px;
}

nav {
	font-family: 맑은고딕, Malgun Gothic, dotum, gulim,
		sans-serif display : flex;
	justify-content: center;
	background-color: black;
	float: left;
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
	font-size: 15px;
}

#sub-menu>li {
	padding: 16px 28px;
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

.img_go {
	float: left;
	width: 25%;
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
	height: 350px;
	width: 900px;
	text-align: center;
        padding-left: 170px;
       
}
    
    
</style>
</head>
<body>
	<div id="wrapper">
		<div id="head">
			<div id="head1">
				<a href="/cs.html" id="top">고객센터</a> <a href="#" id="top">장바구니</a> <a
					href="/enroll.html" id="top">회원가입</a> <a href="/login.html"
					id="top">로그인</a>
			</div>
			<a href="/index.html" id="home"> <img src="/img/logo.png"
				id="img" width="100" height="100">To:geDog
			</a><br>
		</div>
		<br>
		<br>
		<br>
		<br>
		<nav role="navigation" style="width: 100%;">
			<ul id="main-menu" style="position: relative; left: 250px;">
				<li><a href="#">SHOPPING</a>
					<ul id="sub-menu">
						<li><a href="#">사료 & 간식</a></li>
						<li><a href="#">의류 제품</a></li>
						<li><a href="#">장난감</a></li>
					</ul></li>
				<li><a href="#">BOOKING</a>
					<ul id="sub-menu">
						<li><a href="reservationDetail.html">예약문의</a></li>
						<li><a href="#">포토 후기</a></li>
					</ul></li>
				<li><a href="board.html">BOARD</a>
					<ul id="sub-menu">
						<li><a href="/freeboard/list">게시판</a></li>
						<li><a href="/notice/list">Q & A</a></li>
						<li><a href="/comboard/list">정보 공유</a></li>
					</ul></li>
			</ul>
		</nav>
		<div id="contents">
			<br>
			<br>
			<br>
			<br>
			<br>
				<legend style="text-align: left;">정보공유 게시판</legend>
				<hr>
				<br>
				<p id="textP">제목 : ${content.comSubject }</p>
				<p id="textA">글번호 : ${content.comNoticeNo } / 글쓴이 :
					${content.comUserId } / 작성일 :
					${content.comRegDate } / 조회수 : ${content.comReadcount }</p>
				<textarea rows="10" cols="72" name="content">${content.comContents }</textarea>
				<br>
				
				
				<div style="position: relative; left: 380px">
						<c:if test="${sessionScope.member.userId eq content.comUserId}">
						<a href="/comboard/modifyform?comNoticeNo=${content.comNoticeNo }">
						<input type="button" value="수정하기" id="buttonM"></a>
						<a href="/comboard/delete?comNoticeNo=${content.comNoticeNo }" onclick="return deleteConfirm();"> 
						<input type="submit" value="삭제하기" id="buttonD"></a> 
						
						</c:if>
						<a href="/comboard/list"><input type="button" value="목록으로 돌아가기" id="buttonL"
						onclick="javascript:history.back();"></a>
				</div>
				
				
			
		
		<script>
      function deleteConfirm() {
            return confirm ("정마알 삭제하시겠습니까?");
      }   
      
   </script>
<br><br><br><br>

<div id="comments">
<table>
    <tr>
        <th colspan="2">댓글 목록</th>
    </tr>  
</table>
<form action = "BoardServlet" method = "post" name = "check">
<input type = "hidden" name = "command" value = "comment_write">
<input type = "hidden" name = "pnum" value = "${param.num }">
<table style="font-size: 10px;">
    <tr>
        <th>댓글 </th><br>
        <td><textarea rows="1" cols="89" name = "c_content"></textarea></td>
    
        <td><a href="/freeboard/commentwrite"><input type="button" value="댓글달기" id="buttonM"></a></td>
    </tr>
</table>
</form>
 
<c:forEach var="i" begin = "1" end ="${totalCount }" step="1">
    <a href="BoardServlet?command=board_view&num=${param.num }&page=${i}"></a>
</c:forEach>

<br><br>
 
	</div>


</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br>



	<hr>
	<footer>
		<div class="footer">
			<p style="font-size: 16px;">
				고객센터<br>
				<img src="https://cdn.onlinewebfonts.com/svg/img_1059.png"
					style="width: 35px; height: 35px;">02-123-4567
			</p>
			운영시간: 오전 09:00 ~ 오후 06:00<br> 주말, 공휴일은 휴무일입니다.
		</div>


		<div class="footer">
			<div class="vertical"></div>
			<p style="font-size: 16px;">입금계좌</p>
			국민 523202 - 04 - 030162<br> 예금주: 김수연<br>
			<br>

			<p style="font-size: 16px;">후원계좌</p>
			국민 523202 - 04 - 030162<br> 예금주: 김수연<br>

		</div>
		<div class="footer">
			<div class="vertical"></div>
			<p style="font-size: 16px;">바로가기</p>
			<br> <a href="#">
				<div class="img_go" style="padding-left: 20px;">
					<div>
						<img src="https://cdn.onlinewebfonts.com/svg/img_108495.png"
							style="width: 35px; height: 35px; position: relative; right: 8px">
					</div>
					<div style="width: 50px; position: relative; right: 10px">장바구니</div>
				</div>
			</a> <a href="/support.html">
				<div class="img_go">
					<div>
						<img src="https://cdn.onlinewebfonts.com/svg/img_214830.png"
							style="width: 35px; height: 35px;">
					</div>
					<div style="width: 50px; position: relative; left: 5px">후원하기</div>
				</div>
			</a> <a href="mypage.html">
				<div class="img_go">
					<div>
						<img src="https://cdn.onlinewebfonts.com/svg/img_377674.png"
							style="width: 35px; height: 35px;">
					</div>
					<div style="width: 50px; position: relative; left: 3px">주문조회</div>
				</div>
			</a> <a href="#">
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
			<br> 상호 : To:geDog | 비선실세 : 김수연<br> 주소 : 서울특별시 중구 남대문로 120
			대일빌딩<br> 메일 semi@togedog.co.kr<br> 팩스 : 02-1236-4567<br>
			사업자등록번호 : 123-45-67890

		</div>
	</footer>
	</div>
	<script>
      function modify() {
         var result = confirm("글을 삭제 하시겠습니까?");
         if(result) {
            return true;
         } else {
            return false;
         }
      }
   </script>
</body>
</html>