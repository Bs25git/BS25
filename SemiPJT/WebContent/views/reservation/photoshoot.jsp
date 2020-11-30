<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - 포토슛 예약</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style>
    div {
        font-family: 맑은고딕;
    }

    #contents {
        width: 1200px;
        height: 1400px;
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

    #photoQuestion {
        font-size: 21px;
        font-weight: bold;
    }

    .btnphoto1,
    .btnphoto2,
    .btnphoto4,
    .btnphoto5 {
        width: 110px;
        height: 42px;
        background-color: darkgray;
        color: black;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
        border-bottom-right-radius: 15px;
        border-bottom-left-radius: 15px;
        border: none;
        font-size: 16px;
        font-weight: bold;
    }

    .btnphoto3 {
        width: 140px;
        height: 42px;
        background-color: darkgray;
        color: black;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
        border-bottom-right-radius: 15px;
        border-bottom-left-radius: 15px;
        border: none;
        font-size: 16px;
        font-weight: bold;
    }

    .btnreservationS {
        width: 180px;
        height: 45px;
        background-color: black;
        color: white;
        font-size: 15px;
        font-weight: 1000;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
        border-bottom-right-radius: 15px;
        border-bottom-left-radius: 15px;
        border: none;
        cursor: pointer;
    }
    
    #wrapper {
        width: 1890px;
        margin: 0 auto;
        padding: 0 auto;
    }
</style>

<body>
	<div id="wrapper">
    <div id="header"></div>
    <div id="nav"></div>
    <div id="contents">
        <p style="text-align: right; font-size: 13px;">홈 > 예약문의 > 포토슛 예약</p>
        <form action="/mail" method="post">
            <legend id="legendtitle">포토슛 예약</legend><br>
            <hr>
            <p id="photoQuestion">남자인가요? 여자인가요?</p><br>
            <input type="button" class="btnphoto1" value="남자"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto1" value="여자"><br><br>
            <hr style="width: 500px;">

            <p id="photoQuestion">어떤 테마를 원하시나요?</p>
            <input type="button" class="btnphoto2" value="봄">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto2" value="여름">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto2" value="가을">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto2" value="겨울"><br><br>
            <input type="button" class="btnphoto2" value="결혼">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto2" value="영화">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto2" value="가족사진">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto2" value="영정사진">
            <br><br>
            <hr style="width: 500px;">

            <p id="photoQuestion">원하는 사진의 사이즈를 선택하여 주세요 (mm x mm) </p>
            <input type="button" class="btnphoto3" value="50 x 70 (명함)">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto3" value="89 x 127 (3 x 5)">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto3" value="210 x 297 (A4)">
            <br><br>
            <hr style="width: 500px;">

            <p id="photoQuestion">액자가 필요하신 가요?</p>
            <input type="button" class="btnphoto4" value="Yes"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto4" value="No">
            <br><br>
            <hr style="width: 500px;">

            <p id="photoQuestion">사진은 몇장 필요하신가요?</p>
            <input type="button" class="btnphoto5" value="5"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto5" value="10"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto5" value="15"><br><br>
            <hr style="width: 500px;">


            <p id="photoQuestion">예약하시는 분의 성함을 입력해 주세요</p>
            <input type="text" id="textBox" style="width:200px; height:30px; text-align: center;" placeholder="성함을 입력해주세요." name="reservename" required>
            <br><br>
            <hr style="width: 500px;">
            <p id="photoQuestion">예약 확정 메일을 받을 이메일 주소를 입력해 주세요</p>
            <input type="email" id="textBox" style="width:250px; height:30px; text-align: center;" placeholder="이메일을 입력해주세요." name="email" required>
            <br><br>
            <hr style="width: 500px;">
            <p id="photoQuestion">수제 간식 제작 희망 날짜가 어떻게 되시나요?</p>
            <input type="date" id="currentDate" style="width: 150px; height: 30px; font-size: 15px; border: 1px solid black;" name="reserveDate">
            <br><br><br>
            <input class="btnreservationS" type="submit" value="예약하기">
        </form>
    </div>
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
<script>
    var help = document.getElementsByClassName('btnphoto1');
    for (var i = 0; i < help.length; i++) {
        help[i].addEventListener('click', function() {
            for (var j = 0; j < help.length; j++) {
                help[j].style.backgroundColor = "darkgray";
                help[j].style.color = "black";
            }
            this.style.backgroundColor = "black";
            this.style.color = "white";
        });
    }
</script>
<script>
    var hel = document.getElementsByClassName('btnphoto2');
    for (var i = 0; i < hel.length; i++) {
        hel[i].addEventListener('click', function() {
            for (var j = 0; j < hel.length; j++) {
                hel[j].style.backgroundColor = "darkgray";
                hel[j].style.color = "black";
            }
            this.style.backgroundColor = "black";
            this.style.color = "white";
        });
    }
</script>
<script>
    var he = document.getElementsByClassName('btnphoto3');
    for (var i = 0; i < he.length; i++) {
        he[i].addEventListener('click', function() {
            for (var j = 0; j < he.length; j++) {
                he[j].style.backgroundColor = "darkgray";
                he[j].style.color = "black";
            }
            this.style.backgroundColor = "black";
            this.style.color = "white";
        });
    }
</script>
<script>
    var h = document.getElementsByClassName('btnphoto4');
    for (var i = 0; i < h.length; i++) {
        h[i].addEventListener('click', function() {
            for (var j = 0; j < h.length; j++) {
                h[j].style.backgroundColor = "darkgray";
                h[j].style.color = "black";
            }
            this.style.backgroundColor = "black";
            this.style.color = "white";
        });
    }
</script>
<script>
    var help2 = document.getElementsByClassName('btnphoto5');
    for (var i = 0; i < help2.length; i++) {
        help2[i].addEventListener('click', function() {
            for (var j = 0; j < help2.length; j++) {
                help2[j].style.backgroundColor = "darkgray";
                help2[j].style.color = "black";
            }
            this.style.backgroundColor = "black";
            this.style.color = "white";
        });
    }
</script>
<script>
    document.getElementById("currentDate").value = new Date().toISOString().substring(0, 10);
</script>
</html>