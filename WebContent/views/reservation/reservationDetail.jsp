<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - 예약문의</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style>
    div {
        font-family: 맑은고딕;
    }

    #contents {
        width: 1200px;
        height: 1250px;
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

    #reservationtitle {
        font-size: 25px;
        font-weight: 1000;
    }

    #reservationdiv1 {
        float: left;
        width: 25%;
    }

    #reservationdiv2 {
        float: left;
        width: 33.3%;
    }

    #reservationsubtitle {
        color: slategray;
        font-weight: bold;
        font-size: 19px;
    }

    #snack,
    #photoshoot {
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
        <p style="text-align: right; font-size: 13px;">홈 > 예약문의</p>
        <legend id="legendtitle">예약문의</legend><br>
        <hr>
        <div>
            <p id="reservationtitle">혹시 지금까지 간식에 반려견을 맞추지는 않았나요?</p>
            <p>To:geDog은 아이들의 세세한 부분까지 맞춰 직접 수제간식을 제작합니다<br>이제 우리 아이들만을 위한 맞춤형 간식을 만나보세요</p><br>
            <div id="reservationdiv1">
                <img src="/img/5.png">
                <p style="font-weight: bold;">입맛 없는 아이</p>
            </div>
            <div id="reservationdiv1">
                <img src="/img/6.png">
                <p style="font-weight: bold;">소화 기능이 약한 아이</p>
            </div>
            <div id="reservationdiv1">
                <img src="/img/7.png">
                <p style="font-weight: bold;">몸이 약한 아이</p>
            </div>
            <div id="reservationdiv1">
                <img src="/img/8.png">
                <p style="font-weight: bold;">수분 섭취가 부족한 아이</p><br>
            </div>
        </div>
        <hr>
        <div>
            <p id="reservationtitle">To:geDog, 우리는 특별합니다</p><br>
            <div id="reservationdiv1">
                <p id="reservationsubtitle">입맛 없는 아이</p>
                <p>국내외 수의영양학 데이터를<br>
                    기반으로 반려견의 상태에<br>
                    적합한 간식을 제공합니다</p>
            </div>
            <div id="reservationdiv1">
                <p id="reservationsubtitle">소화 기능이 약한 아이</p>
                <p>높은 고기 함유량은 물론<br>
                    맛과 풍미가 그대로 살아있어<br>
                    선호도가 높습니다</p>
            </div>
            <div id="reservationdiv1">
                <p id="reservationsubtitle">몸이 약한 아이</p>
                <p>75℃이하 진공저온 공법을<br>
                    활용하여 동결건조보다도<br>
                    영양소 손실이 적습니다</p>
            </div>
            <div id="reservationdiv1">
                <p id="reservationsubtitle">수분 섭취가 부족한 아이</p>
                <p>수비드 조리법은 저온살균<br>
                    방식으로 식중독 예방은 물론<br>
                    겨울 상온보관도 가능합니다</p>
            </div><br><br><br><br><br><br><br><br>
            <a href="/views/reservation/snack.jsp"><button id="snack" onclick="return loginCheck();">맞춤간식 만들기</button></a><br><br>
        </div>
        <hr>
		<script>
        	function loginCheck(){
            	<c:if test="${sessionScope.member.userId eq null}">	
               	alert("로그인 후 이용해 주세요");
                location.href="/views/member/reserveLogin.jsp";
                return false;
                </c:if>
            }
        </script>
        <div>
            <p id="reservationtitle">To:geDog만의 특별한 포토 슛을 만나보세요</p><br>
            <div id="reservationdiv2">
                <p id="reservationsubtitle">세심한 디테일</p>
                <p>To:geDog은 세세한 부분<br>
                    하나하나 신경써서<br>
                    포토 슛을 준비합니다</p>
            </div>
            <div id="reservationdiv2">
                <p id="reservationsubtitle">여러가지 테마</p>
                <p>To:geDog에서 준비한<br>
                    8가지의 각종 테마를<br>
                    취향에 맞게 골라보세요</p>
            </div>
            <div id="reservationdiv2">
                <img src="/img/개해맑.jpg">
            </div>
            <div style="position: relative; bottom: 50px;">
                <a href="/views/reservation/photoshoot.jsp"><button id="photoshoot" onclick="return loginCheck();">포토 슛 예약하기</button></a>
            </div>
        </div>
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
</script></html>