<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog</title>
    <link rel="stylesheet" type="text/css" href="http://kenwheeler.github.io/slick/slick/slick.css" />
    <link rel="stylesheet" type="text/css" href="http://kenwheeler.github.io/slick/slick/slick-theme.css" />
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="http://kenwheeler.github.io/slick/slick/slick.min.js">
    </script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
</head>
<style>
    div {
        font-family: 맑은고딕;
    }

    #contents {
        width: 1200px;
        height: 1100px;
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

    #wrapper {
        width: 1890px;
        margin: 0 auto;
        padding: 0 auto;
    }

    #slick-banner1 {
        width: 1200px;
        height: 200px;
    }

    #bannerimg1 {
        width: 1200px;
        height: 200px;
    }

    #slick-banner2 {
        width: 1200px;
        height: 200px;
    }

    #bannerimg2 {
        margin: 0px 10px;
    }

    #slick-banner3 {
        width: 400px;
        height: 400px;
        position: relative;
        left: 150px;
    }

    #bannerimg3 {
        width: 180px;
        height: 180px;
        margin: 20px;
        position: relative;
        bottom: 450px;
        left: 250px;

    }

    .slick-prev:before,
    .slick-next:before {
        color: black;
    }
</style>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<body>
    <div id="wrapper">
        <div id="header"></div>
        <div id="nav"></div>
        <br><br>
        <div id="contents">
            <div id="slick-banner1">
                <img src="/img/banner1-1.jpg" id="bannerimg1">
                <img src="/img/banner1-2.jpg" id="bannerimg1">
                <img src="/img/banner1-3.jpg" id="bannerimg1">
                <img src="/img/banner1-4.jpg" id="bannerimg1">
            </div><br>
            <hr><br>
            <div id="slick-banner2">
                <img src="/img/food_2.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=2')">
                <img src="/img/food_3.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=3')">
                <img src="/img/food_4.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=4')">
                <img src="/img/food_11.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=11')">
                <img src="/img/food_13.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=13')">
                <img src="/img/clothes_20.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=40')">
                <img src="/img/clothes_1.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=21')">
                <img src="/img/food_19.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=19')">
                <img src="/img/food_11.jpg" id="bannerimg2" onclick="window.open('/select/Shop?productNo=21')">
                <img src="/img/clothes_5.jpg" id="bannerimg2"onclick="window.open('/select/Shop?productNo=25')">
            </div>
            <br>
            <hr><br>
            <div id="slick-banner3">
                <img src="/img/clothes_3.jpg">
                <img src="/img/clothes_6.jpg">
                <img src="/img/clothes_12.jpg">
                <img src="/img/clothes_18.jpg">
                <img src="/img/clothes_20.jpg">
            </div>
            <div id="banner3">
                <img src="/img/clothes_4.jpg" id="bannerimg3">
                <img src="/img/clothes_5.jpg" id="bannerimg3"><br>
                <img src="/img/clothes_8.jpg" id="bannerimg3">
                <img src="/img/clothes_9.jpg" id="bannerimg3">
            </div>
        </div>
        <hr>
        <div id="footer"></div>
    </div>
</body>
<script type="text/javascript">
    $(document).ready(function() {
        $('#slick-banner1').slick({
            dots: true,
            infinite: true,
            speed: 1000,
            fade: true,
            autoplay: true,
            arrows: false
        });

        $('#slick-banner2').slick({
            dots: true,
            infinite: true,
            speed: 1000 /* 이미지가 슬라이딩시 걸리는 시간 */ ,
            fade: false,
            arrows: false,
            autoplaySpeed: 3000 /* 이미지가 다른 이미지로 넘어 갈때의 텀 */ ,
            slidesToShow: 5,
            slidesToScroll: 2,
            autoplay: true,
            arrows: true
        });

        $('#slick-banner3').slick({
            dots: true,
            infinite: true,
            speed: 1000 /* 이미지가 슬라이딩시 걸리는 시간 */ ,
            fade: false,
            arrows: false,
            autoplaySpeed: 3000 /* 이미지가 다른 이미지로 넘어 갈때의 텀 */ ,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true
        });

        $("#header").load("/include/headerWeb.jsp")
        $("#nav").load("/include/navWeb.jsp")
        $("#footer").load("/include/footerWeb.html")
    });
</script>
<script>
    $('#sidebarCollapse').on('click', function() {
        $('#sidebar').addClass('active');
        $('.overlay').fadeIn();
    });

    $('.overlay').on('click', function() {
        $('#sidebar').removeClass('active');
        $('.overlay').fadeOut();
    });
    
    function bag(){
        <c:if test="${sessionScope.member.userId eq null }">
        swal({
            title: "로그인해라",
            text: "말대꾸 하지마라",
            icon: "warning"
        }).then(function() {
            window.location = "/views/member/login.jsp";
        });
            return false;
        </c:if>
     }  

	
</script></html>
