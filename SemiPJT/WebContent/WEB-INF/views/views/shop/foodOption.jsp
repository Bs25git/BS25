<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>사료 & 간식 - To:geDog</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Roboto');
        footer {
            text-align: center;
            width: 1000px;
            height: 180px;
            margin: auto;
            font-size: 11px;
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

        
        .footerimg2 {
            width: 35px;
            height: 35px;
        }

        div {
            box-sizing: border-box;
            font-family: "Roboto", serif;
        }

        a {
            color: black;
            text-decoration: none;
            text-align: center;
        }
        
        #wrapper {
            width: 1200px;
            height: 300px;
            margin: 0 auto;
        }
        
        #home {
            color: black;
            height: 100%;
            width: 100%;
            text-align: center;
            font-size: 70px;
            display: block;
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
            padding: 16px;
            28px;
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
        
        .footer img {
            margin: 9px 9px 0px 9px;
        }

        .imgCaption {
            text-align: center;
            line-height: 9px;
        }

        .banner:hover {
            opacity: 0.7;
        }

        body {
            font-size: 11pt;
            padding: 0;
            margin: 0;
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

        /* banner */
        .banner {
            position: relative;
            width: 340px;
            height: 210px;
            top: 50px;
            margin: 0 auto;
            padding: 0;
            overflow: hidden;
        }

        .banner ul {
            position: absolute;
            margin: 0px;
            padding: 0;
            list-style: none;
        }

        .banner ul li {
            float: left;
            width: 400px;
            height: 300px;
            margin: 0;
            padding: 0;
        }

        /*  navigator */
        nav {
    
            font-family: "Roboto", serif;
            width: 100%;
            display: flex;
            justify-content: center;
            background-color: black;
            position: relative;
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
        }

        #contents_header1 {
            height: 40px;
            margin: auto;
            line-height: 40px;
            font-size: 1.2rem;
        }
        
        #contents_header2 {
            width: 100%;
            height: 50px;
            float: left;
            line-height: 60px;
        }
        #contents_explain {
            width: 30%;
            height: 50px;
            float: left;
        }
        #contents_empty {
            width: 40%;
            height: 50px;
            float: left;
        }
        #contents_filter {
            width: 30%;
            height: 50px;
            float: left;
            text-align: left;
        }     
        
        #contents_filter>a{
        	margin-left: 40px;
            height: 50px;
            float: left;
        }

      	#contents_layer1 {
            width: 100%;
            height: 650px;
            float: left;
        }
        #contents_layer2 {
            width: 100%;
            height: 50px;
            float: left;
            line-height: 150px;
        }
        #contents_empty2 {
            margin: 0;
            width: 40%;
            height: 50px;
            float: left;
        }
        #contents_pagingbtn {
            width: 30%;
            height: 50px;
            float: left;
            margin-left: 120px;
            margin-bottom: 50px;
        }
        #contents_search {
        	margin-left: -50px;
            width: 20%;
            height: 50px;
            float: left;
            text-align: right;
			line-height: 100px;
        }
        #blank {
            border: 1px black solid;
        }
        #img_top{
            width: 100%;
            height: 300px;
            margin: 20px ; 
        }
        .top{
            width: 25%;
            height: 100%;
            float: left;
        }
        #img_bottom{
            width: 100%;
            height: 300px;
            margin: 20px 20px ;
        }
        .bottom{
            width: 25%;
            height: 100%;
            float: left;
        } 
        .imgCaption{
            width: 90%;
            text-align: left;
        }
        #item{
        	margin-left: 80px;
        	margin-bottom:20px;
        }
        #item_img{
			width:200px;
			height:200px;
        }
        #item_img:hover{
        	transition-duration: 0.5s;
        	transform:scale(0.95);
        }
        #item_title{
        	margin-top: 5px;
        }
        #item_price{
        	margin-top:5px;
        	margin-bottom:10px;
        }
        #index{
           text-align: right;
           line-height: 40px;     
        }
    </style>
</head>
<body>
    <div id="wrapper">
        <div id="head">
            <div id="head1">
                <a href="#" id="top">고객센터</a>
                <a href="#" id="top">장바구니</a>
                <a href="#" id="top">회원가입</a>
                <a href="#" id="top">로그인</a>
            </div>
            <a href="/index.jsp" id="home"> <img src="/img/logo.png" id="img">To:geDog</a><br>
        </div>
        
        <nav role="navigation" style="text-align: center;">
            <ul id="main-menu">
                <li><a href="/all?category=list">SHOPPING</a>
                    <ul id="sub-menu" >
                        <li><a href="/food?category=list">사료 & 간식</a></li>
                        <li><a href="/clothes?category=list">의류 제품</a></li>
                        <li><a href="/toy?category=list">장난감</a></li>
                    </ul>
                </li>
                <li><a href="#">BOOKING</a>
                    <ul id="sub-menu">
                        <li><a href="reservationDetail.html">예약문의</a></li>
                        <li><a href="photoshoot.html">포토 슛</a></li>
                        <li><a href="#">포토 후기</a></li>
                    </ul>
                </li>
                <li><a href="board.html">BOARD</a>
                    <ul id="sub-menu">
                        <li><a href="#">게시판</a></li>
                        <li><a href="#">Q & A</a></li>
                        <li><a href="#">정보 공유</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="contents">
        <div id="index"><a href="/index.jsp">홈</a> > <a href="/all?category=list">&nbsp;모든물품</a> > <a href="/food?category=list">&nbsp;사료 & 간식</a></div>
            <div id="contents_header1">사료 & 간식</div>
            <div id="option">
	            <select onchange="if(this.value) location.href=(this.value);">
	               <option value="/food/list" selected>나이</option>
	               <option value="/food/option?age=1">0~3살</option>
	               <option value="/food/option?age=2">3~8살</option>
	               <option value="/food/option?age=3">8살 이상</option>
	            </select>
	            
	             <select>
	               <option selected>크기</option>
	               <option>소형견</option>
	               <option>중형견</option>
	               <option>대형견</option>
	            </select> <select>
	               <option selected>주원료</option>
	               <option>고기</option>
	               <option>연어</option>
	               <option>비건</option>
	            </select>
         	</div>
            <div id="contents_header2">
                <div id="contents_explain">${totalCount }개의 상품이 등록되어 있습니다.</div>
                <div id="contents_empty"></div>
                <div id="contents_filter">
                    <a href="/food?category=new">최신순&emsp;&emsp;|</a>
                    <a href="/food?category=min">낮은가격&emsp;&emsp;| </a>
                    <a href="/food?category=max">높은가격</a>
                </div>
            </div>            
            <hr>
            <c:set var="i" value="0" />
		     <c:set var="j" value="4" />
		     <table>
		     <c:forEach items="${nList }" var="shop">
		     <c:if test="${i%j == 0 }"> 
		     <tr>
		     </tr>
		    </c:if> 
		    <td>
		    	<div id="item">
			    	<div id="item_img">
			    	<a href="/select/Shop?productNo=${shop.productNo }"><img src="${shop.img }" width="200" height="200"></a>
			    	</div>
			    	<div id="item_title">
			    	<a href="/select/Shop?productNo=${shop.productNo }">${shop.productName }</a>
			    	</div>
			    	<hr>
			    	<div id="item_price">
			    	<a href="/select/Shop?productNo=${shop.productNo }"><del>${shop.price }원</del></a>
			    	</div>
			    	<div id="item_discount">
			    	<a href="/select/Shop?productNo=${shop.productNo }">${shop.discount }원</a>
			    	</div>
		    	</div>
		    </td>
		    <c:if test="${i%j == j-1 }">
		      
		    </c:if> 
		    <c:set var="i" value="${i+1 }" />
		    </c:forEach>
	    </table>
            <div id="contents_empty2"></div>
            <div id="contents_pagingbtn">
	 		 	${pageNavi }
            </div>
            <div id="contents_search">
            	<form action="/food/search" method="get">
		            <input type="text" name="search" id="blank" size="20">
		            <input type="submit" value="검색">
	            </form>
	        </div> 
            </div>
       </div>
           <footer>
        <div class="footer">
            <p style="font-size: 16px;">고객센터<br><img class="footerimg2" src="https://cdn.onlinewebfonts.com/svg/img_1059.png">02-123-4567</p>
            운영시간: 오전 09:00 ~ 오후 06:00<br>
            주말, 공휴일은 휴무일입니다.
        </div>

        <div class="footer">
            <div class="vertical"></div>
            <p style="font-size: 16px;">
                입금계좌</p>
            국민 523202 - 04 - 030162<br>
            예금주: 김수연<br>

            <p style="font-size: 16px;">후원계좌</p>
            국민 523202 - 04 - 030162<br>
            예금주: 김수연<br>

        </div>
        <div class="footer">
            <div class="vertical"></div>
            <p style="font-size: 16px;">바로가기</p>

            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_108495.png" style="width: 44px; height: 30px; "></div>
                <div style="width: 50px;">장바구니</div>
            </div>
            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_214830.png" style="width: 44px; height: 30px; "></div>
                <div style="width: 50px;">후원하기</div>
            </div>
            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_377674.png" style="width: 44px; height: 30px; "></div>
                <a href="#"><div style="width: 50px;">주문조회</div></a>
            </div>
            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_377768.png" style="width: 44px; height: 30px; "></div>
                <div style="width: 50px;">공지사항</div>
            </div>
        </div>

        <div class="footer">
            <div class="vertical"></div>
            <p style="font-size: 16px;">회사소개 | 이용안내 | 이용약관</p>
            상호 : To:geDog | 비선실세 : 김수연<br>
            주소 : 서울특별시 중구 남대문로 120 대일빌딩<br>
            메일 semi@togedog.co.kr<br>
            팩스 : 02-1236-4567<br>
            사업자등록번호 : 123-45-67890

        </div>
    </footer>
</body>
</html>