<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style>
    div {
        font-family: 맑은고딕;
    }

    a {
        text-decoration: none;
    }

    .socialnetwork_img {
        width: 30px;
        height: 30px;
        margin: 0px 8px;
    }

    #smallnav1 {
        text-align: left;
        float: left;
        width: 50%;
    }

    #smallnav2 {
        text-align: right;
        float: right;
        width: 50%;
    }

    #smallnav2>a {
        color: black;
        margin: 8px;
        /* a태그간의 간격 조정 */
    }

    #logo {
        font-family: "Oswald";
        text-align: center;
        font-size: 60px;
    }

    #logo>a {
        color: black;
        /* 로고 색 변경 */
    }

    #img_logo {
        width: 100px;
        height: 100px;
        position: relative;
        top: 25px;
        right: 10px;
        opacity: 1;
    }

    #head_title {
        position: relative;
        bottom: 15px;
    }

    #head_subtitle {
        font-size: 13px;
        position: relative;
        left: 50px;
        bottom: 30px;
    }

    #smallnav2 a:hover {
        /* 네비 호버 효과 */
        font-weight: bold;
    }

    #sidebar {
        width: 270px;
        position: fixed;
        top: 0;
        left: -270px;
        height: 100%;
        z-index: 999;
        background: black;
        color: white;
        transition: all 0.3s;
        font-weight: bold;
    }

    #sidebar>a {
        color: white;
        font-size: 13px;
    }

    #sidebar>a:hover {
        color: skyblue;
    }

    #sidebar.active {
        left: 0;
    }

    .overlay {
        position: fixed;
        top: 0;
        width: 100vw;
        height: 100vh;
        background: rgba(0, 0, 0, 0.3);
        z-index: 998;
        display: none;
    }

    #back-to-top {
        display: inline-block;
        background-color: black;
        width: 50px;
        height: 50px;
        text-align: center;
        border-radius: 4px;
        position: fixed;
        bottom: 30px;
        right: 30px;
        transition: background-color .3s,
            opacity .5s, visibility .5s;
        opacity: 0;
        visibility: hidden;
        z-index: 1000;
    }

    #back-to-top::after {
        content: "\f077";
        font-family: FontAwesome;
        font-weight: normal;
        font-style: normal;
        font-size: 2em;
        line-height: 50px;
        color: #fff;
    }

    #back-to-top:hover {
        cursor: pointer;
        background-color: #333;
    }

    #back-to-top:active {
        background-color: #555;
    }

    #back-to-top.show {
        opacity: 1;
        visibility: visible;
    }

</style>
<a id="back-to-top"></a>
<nav id="sidebar">
    <p style="font-weight: bold; font-size: 25px; margin: 20px 70px 20px 70px;">To:geDog</p>
    <hr>▶ SHOPPING
    <hr><a href="/food?category=list">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사료 & 간식</a>
    <br><a href="/clothes?category=list">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;의류 제품</a>
    <br><a href="/toy?category=list">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;장난감</a>
    <hr>▶ BOOKING
    <hr><a href="/views/reservation/reservationDetail.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;예약문의</a>
    <br><a href="/img/list">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포토 후기</a>
    <hr>▶ BOARD
    <hr><a href="/notice/list" onclick="return bag();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Q & A</a>
    <br><a href="/freeboard/list" onclick="return bag();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;자유게시판</a>
    <br><a href="/comboard/list" onclick="return bag();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;정보공유</a>
    <hr>
    <div style="text-align: center;">
        <a href="#"><img src="/img/Facebook.png" class="socialnetwork_img"></a>
        <a href="#"><img src="/img/Twitter.png" class="socialnetwork_img"></a>
        <a href="#"><img src="/img/Instagram.png" class="socialnetwork_img"></a>
        <a href="#"><img src="/img/YouTube.png" class="socialnetwork_img"></a>
    </div>
</nav>
<div class="overlay"></div>
<div id="head">
    <div id="smallnav1">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS8fCYHy5FrKCQlj7TgbKI7RGyUvdBHXNVtvQ&usqp=CAU" class="socialnetwork_img" style="cursor: pointer;" id="sidebarCollapse">
        <a href="#"><img src="/img/Facebook.png" class="socialnetwork_img"></a>
        <a href="#"><img src="/img/Twitter.png" class="socialnetwork_img"></a>
        <a href="#"><img src="/img/Instagram.png" class="socialnetwork_img"></a>
        <a href="#"><img src="/img/YouTube.png" class="socialnetwork_img"></a>
    </div>
    <div id="smallnav2">
  			 <c:if
               test="${member.userId eq sessionScope.member.userId and member.userId ne null }">
               <a href="/member/logout">로그아웃</a>
               <a href="/views/member/myInfo.jsp">마이페이지</a>
               <a href="/views/shop/basket.jsp">장바구니</a>
               <a href="/views/cs/cs.html">고객센터</a>
            </c:if>
            <c:if test="${member.userId eq null }">
               <a href="/views/member/login.jsp">로그인</a>
               <a href="/views/member/enroll.html">회원가입</a>
               <a href="/views/member/login.jsp">장바구니</a>
               <a href="/views/cs/cs.html">고객센터</a>
            </c:if>
    </div>
    <br><br>
    <hr style="position: relative; bottom: 12px;">
    <div id="logo">
        <a href="/index.jsp"><img src="/img/logo.png" id="img_logo"><span id="head_title">To:geDog</span></a>
        <p id="head_subtitle">Of the dog, By the dog, For the dog</p>
    </div>
</div>
<script>
    $('#sidebarCollapse').on('click', function() {
        $('#sidebar').addClass('active');
        $('.overlay').fadeIn();
    });

    $('.overlay').on('click', function() {
        $('#sidebar').removeClass('active');
        $('.overlay').fadeOut();
    });

</script>
<script type="text/javascript">
    $(function() {
        $('#back-to-top').on('click', function(e) {
            e.preventDefault();
            $('html,body').animate({
                scrollTop: 0
            }, 600);
        });

        $(window).scroll(function() {
            if ($(document).scrollTop() > 100) {
                $('#back-to-top').addClass('show');
            } else {
                $('#back-to-top').removeClass('show');
            }
        });
    });
</script>
<script>
	    function bag(){
	        <c:if test="${sessionScope.member.userId eq null }">
	            alert("로그인 후 이용해주세요.");
	            location.href="/views/member/login.jsp";
	            return false;
	        </c:if>
	     }    
	
</script>
