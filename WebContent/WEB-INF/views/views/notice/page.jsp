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
    <title>메인페이지</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Roboto');
        div {
            box-sizing: border-box;
            font-family: "Roboto", serif;
        }

        a {
        color: black;
            text-decoration: none;
            display: block;
            text-align: center;
        }
        #wrapper {
            width: 1200px;
            margin: 0 auto;
        }
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

        #contents{
            margin: 15px;
            margin-top: 50px;
            overflow: auto;
        }
        #contents_img{
            width: 48%;
            height: 30%;
            float: left;
        }
        #contents_detail{
            width: 48%;
            height: 30%;
            float: right;
            border-top: 1px solid gray;
        }
        #contents_title{
            text-align: left;
        }
        #contents_title h3{
            margin-top: 5px;
        }
        #contents_price_1{
            line-height: 50px;
            width: 30%;
            float: left;
            text-align: left;
            
        }
        #contents_price_2{
            line-height: 50px;
            margin-bottom: 10px;
            width: 70%;
            float: left;
            text-align: left;
        }
        #contents_price_2 input{
            width: 30px;
            height: 100%;
        }
        #contents_size{
            text-align: left;
            border-bottom: 1px solid gray;
        }
        #contents_size select{
            width: 100%;
        }
        #contents_size1{
            margin-bottom: 10px;
            width: 30%;
            float: left;
        }
        #contents_size2{
            margin-bottom: 10px;
            width: 70%;
            float: left;
        }
        #contents_total{
            margin-bottom: 10px;
            margin-right: 10px;
            text-align: right;
        }
        #contents_btn{
            margin-top: 50px;
            text-align: center;
        }
        input{
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
            border-bottom-left-radius: 5px;
            border-bottom-right-radius: 5px;
            width: 150px;
            height: 50px;
        }
        #contents2{
            width: 100%;
            margin-top: 100px;
            text-align: center;
            float: left;
        }
        button{
            width: 200px;
            height: 50px; 
        }
        #contents3{
            text-align: center;
            margin-top: 50px;
            float: left;
        }
        #contents3_1{
           text-align: center;
        }
        #contents3_2{
            text-align: left;
        }
        #contents3_3{
            text-align: left;
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
    </style>


    <script>
        $(document).ready(function(){
           $("#btn1").click(function(){
               $("#contents3_1").show();
               $("#contents3_2").hide();
               $("#contents3_3").hide();
           });
        });
        $(document).ready(function(){
           $("#btn2").click(function(){
               $("#contents3_1").hide();
               $("#contents3_2").show();
               $("#contents3_3").hide();
           });
        });
        $(document).ready(function(){
           $("#btn3").click(function(){
               $("#contents3_1").hide();
               $("#contents3_2").hide();
               $("#contents3_3").show();
           });
        });
        
    </script>

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
            <a href="/main.jsp" id="home"> <img src="/img/logo.png" id="img">To:geDog</a><br>
        </div>
        
        <nav role="navigation" style="text-align: center;">
            <ul id="main-menu">
                <li><a href="#">SHOPPING</a>
                    <ul id="sub-menu" >
                        <li><a href="/food/list">사료 & 간식</a></li>
                        <li><a href="/clothes/list">의류 제품</a></li>
                        <li><a href="/toy/list">장난감</a></li>
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
        <div id="contents_img">
                <img src="${shop.img }" width="100%;" height="100%">
            </div>
            <div id="contents_detail">
                <div id="contents_title"><h3>${shop.productName }</h3></div>
                <div id="contents_price_1">소비자가<br>할인가<br>수량<br>배송방법<br>배송비</div>
                <div id="contents_price_2"><del>${shop.price }원</del><br>${shop.discount }원<br>
                    <input type="number" value="1" min="1" max="100"/>
                    <br>택배<br>무료
                </div>
                <div id="contents_size">
                    <div id="contents_size1">옵션</div>
                    <div id="contents_size2">
                        <select name="">
                            <option value="1">[옵션] 옵션을 선택해 주세요</option>
                            <option value="2">[옵션] 옵션을 선택해 주세요</option>
                            <option value="3">[옵션] 옵션을 선택해 주세요</option>
                        </select>
                    </div>
                </div>
                <div id=contents_total>총 상품 금액 : 9,900</div>
                <div id=contents_btn>
                    <input type="submit" value="장바구니 담기" onclick="return bag();">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" value="바로 구매" onclick="return bag();">
                    <script>
                    function bag(){
                    	var memberId = '${sessionScope.member.memberId}';
                    	if(userId  != memberId){
                    		alert("로그인 후 이용해주세요.");
                    		return false;
                    	}
                    }
                    
                    </script>
                </div>
            </div>
            <div id="contents2">
                <button id="btn1">상품 상세 정보</button>
                <button id="btn2">상품 구매 안내</button>
                <button id="btn3">환불 / 교환 안내</button>
            </div>
            <div id="contents3">
                <div id="contents3_1" style="display: block">
                    <img src="${shop.infoImg1 }" width="800px">
                    <img src="${shop.infoImg2 }" width="800px">
                    <img src="${shop.infoImg3 }" width="800px">
                </div>
                <div id="contents3_2" style="display: none">
                    호구 어서오고
                    <hr width="100%;" noshade>
                    <p>갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다
                    갚진 교훈얻었다고 생각합시다</p>
                </div>
                <div id="contents3_3" style="display: none">
                    환불해줘
                    <hr width="100%" noshade>
                    <p>고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다
                    고객님 환불은 어렵겠습니다</p>
                    
                </div>
            </div>
        </div>
        </div>
    <hr>
    <footer>
        <div class="footer">
            <p style="font-size: 16px;">고객센터<br><img class="footerimg2" src="https://cdn.onlinewebfonts.com/svg/img_1059.png" style="width: 44px; height: 30px;">02-123-4567</p>
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