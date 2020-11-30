<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - 수제간식 예약</title>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style>
    div {
        font-family: 맑은고딕;
    }
	#wrapper {
		width : 1890px;
		margin : 0 auto;
		padding : 0 auto;
	}
    #contents {
        width: 1200px;
        height: 1650px;
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

    #snackQuestion {
        font-size: 21px;
        font-weight: bold;
    }

    .btnphoto1,
    .btnphoto2,
    .btnphoto3,
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
</style>

<body>
	<div id="wrapper">
    <div id="header"></div>
    <div id="nav"></div>
    <div id="contents">
        <p style="text-align: right; font-size: 13px;">홈 > 예약문의 > 수제간식 예약</p>
        <form action="/mail" method="post">
            <legend id="legendtitle">수제간식 예약</legend><br>
            <hr>
            <p id="snackQuestion">남자인가요? 여자인가요?</p><br>
            <input type="button" class="btnphoto1" value="남자">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto1" value="여자"><br><br>
            <hr style="width: 500px;">

            <p id="snackQuestion">중성화 수술은 했나요?</p>
            <input type="button" class="btnphoto2" value="Yes">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto2" value="No"><br><br>
            <hr style="width: 500px;">

            <p id="snackQuestion">나이는 어떻게 되나요?</p>
            <input type="text" id="textBox" placeholder="0" pattern="[0-9]+" style="width:50px; height:30px; text-align: center;"> &nbsp;년 &nbsp;&nbsp;&nbsp;
            <input type="text" id="textBox" placeholder="0" pattern="[0-9]+" style="width:50px; height:30px; text-align: center;"> &nbsp;개월 됐어요. <br><br>
            <hr style="width: 500px;">

            <p id="snackQuestion">견종이 어떻게 되나요?</p>
            <input type="text" placeholder="비숑, 말티푸 등" style="width: 150px; height: 30px; text-align: center;" required> &nbsp;&nbsp; 이에요.<br><br>
            <hr style="width: 500px;">

            <p id="snackQuestion">현재 어떤 사료를 먹고 있나요?</p>
            <input type="button" class="btnphoto3" value="건식">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto3" value="습식">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto3" value="생식/화식"><br><br>
            <hr style="width: 500px;">

            <p id="snackQuestion">몸무게가 어떻게 되나요?</p>
            <input type="text" placeholder="0" pattern="[0-9]+" style="width:50px; height:30px; text-align: center;"> kg 입니다.
            <br><br>
            <hr style="width: 500px;">

            <p id="snackQuestion">원하시는 재료가 있나요?</p>
            <input type="button" class="btnphoto4" value="메추리">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto4" value="닭">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto4" value="소">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto4" value="양"><br><br>
            <input type="button" class="btnphoto4" value="칠면조">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto4" value="연어">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto4" value="돼지">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btnphoto4" value="오리">
            <br><br>
            <hr style="width: 500px;">

            <p id="snackQuestion">예약하시는 분의 성함을 입력해 주세요</p>
            <input type="text" style="width:200px; height:30px; text-align: center;" placeholder="성함을 입력해주세요." name="reservename" required>
            <br><br>
            <hr style="width: 500px;">
            <p id="snackQuestion">예약 확정 메일을 받을 이메일 주소를 입력해 주세요</p>
            <input type="email" style="width:250px; height:30px; text-align: center;" placeholder="이메일을 입력해주세요." name="email" required>
            <br><br>
            <hr style="width: 500px;">
            <p id="snackQuestion">수제 간식 제작 희망 날짜가 어떻게 되시나요?</p>
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
    document.getElementById("currentDate").value = new Date().toISOString().substring(0, 10);
</script></html>