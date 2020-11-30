<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
<meta charset="UTF-8">
<title>To:geDog - 사료 & 간식</title>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style>
div {
	font-family: 맑은고딕;
}

#contents {
	width: 1200px;
	margin: 0 auto;
	position: relative;
	bottom: 35px;
}

#legendtitle {
	text-align: left;
	font-size: 24px;
	font-weight: bold;
}

#wrapper {
	width: 1890px;
	margin: 0 auto;
	padding: 0 auto;
}

#product_explain {
	float: left;
	width: 50%;
	text-align: left;
	font-size: 13px;
}

#product_filter {
	float: left;
	width: 50%;
	text-align: right;
	font-size: 13px;
}

#filtertext {
	margin: 0px 10px;
}

#filtertext:hover {
	font-weight: bold;
}

#item {
	margin: 20px 47px;
}

#item_img {
	width: 200px;
	height: 200px;
}

#item_img:hover {
	transition-duration: 0.5s;
	transform: scale(0.95);
}

#item_title {
	margin-top: 5px;
	font-size: 20px;
}

#item_price {
	margin-top: 5px;
	margin-bottom: 10px;
	font-size: 14px;
	color: gray;
}

#item_discount {
	font-size: 15px;
}

#pagingbtn {
	text-align: center;
	position: relative;
	right: 5px;
}

#search {
	text-align: right;
}

#searchbox {
	width: 150px;
	height: 25px;
}

#btnsearch {
	width: 50px;
	height: 32px;
	background-color: black;
	border: none;
	color: white;
	font-weight: bold;
	position: relative;
	top: 1px;
	cursor: pointer;
}

select {
	width: 100px;
	/* 원하는 너비설정 */
	padding: .7em .4em;
	/* 여백으로 높이 설정 */
	/* 폰트 상속 */
	background: url('이미지 경로') no-repeat 95% 50%;
	/* 네이티브 화살표를 커스텀 화살표로 대체 */
	border: 1px solid lightgray;
	border-radius: 5px;
	margin: 0px 5px;
}
</style>

<body>
	<div id="wrapper">
		<div id="header"></div>
		<div id="nav"></div>
		<div id="contents">
			<p style="text-align: right; font-size: 13px;">홈 > SHOPPING > 사료
				& 간식</p>
			<legend id="legendtitle">상품 목록</legend>
			<br>
			<div>
				<select onchange="if(this.value) location.href=(this.value);" name="selectbox1" id="selectbox1">
					<option value="/food?category=list" selected>나이</option>
					<option value="/food/option?age=1">0~3살</option>
					<option value="/food/option?age=2">3~8살</option>
					<option value="/food/option?age=3">8살 이상</option>
				</select> <select name="selectbox2" id="selectbox2">
					<option selected>크기</option>
					<option>소형견</option>
					<option>중형견</option>
					<option>대형견</option>
				</select> <select name="selectbox3" id="selectbox3">
					<option selected>주원료</option>
					<option>고기</option>
					<option>연어</option>
					<option>비건</option>
				</select>
			</div>
			<br>
			<div id="product_explain">${totalCount}개의상품이 등록되어 있습니다.</div>
			<div id="product_filter">
				<a href="/food?category=new"><span id="filtertext">최신순</span></a>| <a
					href="/food?category=min"><span id="filtertext">낮은가격</span></a>| <a
					href="/food?category=max"><span id="filtertext">높은가격</span></a>
			</div>
			<br>
			<hr>
			<c:set var="i" value="0" />
			<c:set var="j" value="4" />
			<table>
				<c:forEach items="${nList }" var="shop">
					<c:if test="${i%j == 0 }">
						<tr>
						</tr>
					</c:if>

					<td><a href="/select/Shop?productNo=${shop.productNo }">
							<div id="item">
								<div id="item_img">
									<img src="${shop.img}" style="width: 200px; height: 200px;">
								</div>
								<div id="item_title" style="font-family: 'Do Hyeon', sans-serif">${shop.productName }</div>
								<hr>
								<div id="item_price" style="font-family: 'Do Hyeon', sans-serif">
									<del>${shop.price}원</del>
								</div>
								<div id="item_discount" style="font-family: 'Do Hyeon', sans-serif">${shop.discount}원</div>
							</div>
					</a></td>
					<c:if test="${i%j == j-1 }">

					</c:if>
					<c:set var="i" value="${i+1 }" />
				</c:forEach>
			</table>
			<br>
			<br>
			<br>
			<div id="pagingbtn">${pageNavi }</div>
			<br>
			<div id="search">
				<form action="/allSearch" method="get">
					<input type="text" name="search" id="searchbox"> <input
						type="hidden" name="category" value="all"> <input
						type="submit" value="검색" id="btnsearch">
				</form>
			</div>
		</div>
		<br>
		<br>
		<br>
		<hr>
		<div id="footer"></div>
	</div>
</body>
<script type="text/javascript">
    /* include */
    $(document).ready(function() {
        $("#header").load("/include/headerWeb.jsp")
        $("#nav").load("/include/navWeb.jsp")
        $("#footer").load("/include/footerWeb.html")
    });
</script>
</html>