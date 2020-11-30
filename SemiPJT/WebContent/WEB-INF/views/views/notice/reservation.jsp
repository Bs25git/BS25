<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>To:geDog</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Roboto');
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

        img {
            margin: 9px 9px 0px 9px;
            width: 95%;
            height: 90%;
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
            text-align: center;
        }

        h3 {
            color: #85144b;
            font-size: 14pt;
            margin: 10 auto;
            padding: 10px;
        }

        .contents {
            width: 1000px;
            height: 1350px;
            background-color: white;
            margin: 0 auto;
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
        
        
        
        
        
        
        #line {
            width : 500px; 
        }
        #textBox {
            width : 70px;
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
        .button1 {
            width :200px;
            height: 50px; 
            background-color: orange;
            color: white;
            font-size: 15px;
            font-weight: 1000;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
            border-bottom-right-radius: 15px;
            border-bottom-left-radius: 15px;
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
            color: orange;
            font-weight: 1000;
        }
        #textP {
            color: black;
        }
        .button2 {
            width :200px;
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
    </style>


    <script>
        $(document).ready(function() {
            //사용할 배너
            var $banner = $(".banner").find("ul");

            var $bannerWidth = $banner.children().outerWidth(); //배너 이미지의 폭
            var $bannerHeight = $banner.children().outerHeight(); // 높이
            var $bannerLength = $banner.children().length; //배너 이미지의 갯수
            var rollingId;

            //정해진 초마다 함수 실행
            rollingId = setInterval(function() {
                rollingStart();
            }, 3000); //다음 이미지로 롤링 애니메이션 할 시간차

            //마우스 오버시 롤링을 멈춘다.
            $banner.mouseover(function() {
                //중지
                clearInterval(rollingId);
                $(this).css("cursor", "pointer");
            });
            //마우스 아웃되면 다시 시작
            $banner.mouseout(function() {
                rollingId = setInterval(function() {
                    rollingStart();
                }, 3000);
                $(this).css("cursor", "default");
            });

            function rollingStart() {
                $banner.css("width", $bannerWidth * $bannerLength + "px");
                $banner.css("height", $bannerHeight + "px");
                //alert(bannerHeight);
                //배너의 좌측 위치를 옮겨 준다.
                $banner.animate({
                    left: -$bannerWidth + "px"
                }, 1500, function() { //숫자는 롤링 진행되는 시간이다.
                    //첫번째 이미지를 마지막 끝에 복사(이동이 아니라 복사)해서 추가한다.
                    $(this).append("<li>" + $(this).find("li:first").html() + "</li>");
                    //뒤로 복사된 첫번재 이미지는 필요 없으니 삭제한다.
                    $(this).find("li:first").remove();
                    //다음 움직임을 위해서 배너 좌측의 위치값을 초기화 한다.
                    $(this).css("left", 0);
                    //이 과정을 반복하면서 계속 롤링하는 배너를 만들 수 있다.
                });
            }
        });
    </script>



</head>

<body>
    <div id="wrapper">
        <div id="head">
            <div id="head1">
                <a href="/view/member/cs.html" id="top">고객센터</a>
                <a href="#" id="top">장바구니</a>
                <a href="/view/member/enroll.html" id="top">회원가입</a>
                <a href="/view/member/login.jsp" id="top">로그인</a>
                
            </div>
            <a href="/index.jsp" id="home"> <img src="/img/logo.png" id="img" width="100" height="100">To:geDog</a><br>
        </div>
        
        <nav role="navigation" style="text-align: center;">
            <ul id="main-menu">
                <li><a href="#">SHOPPING</a>
                    <ul id="sub-menu" >
                        <li><a href="#">사료 & 간식</a></li>
                        <li><a href="#">의류 제품</a></li>
                        <li><a href="#">장난감</a></li>
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
                        <li><a href="/notice/list">Q & A</a></li>
                        <li><a href="#">정보 공유</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        
    </div>
    <div id="contents">
          <form>
                <legend>예약문의</legend>
                <hr>
                <fieldset id="formQuestion">
                    <p id="text">혹시 지금껏 간식에 반려견을 맞추지는 않았나요?</p>
                    <p>To:geDog은 아이들의 세세한 부분까지 맞춰 직접 수제간식을 제작합니다<br>이제 우리 아이들만을 위한 맞춤형 간식을 만나보세요</p><br>
                    <div id="div1">
                    <img src="img/1.PNG">
                    <h6>입맛 없는 아이</h6>
                    </div>
                    <div id="div1">
                    <img src="img/2.PNG">
                    <h6>소화 기능이 약한 아이</h6>
                    </div>
                    <div id="div1">
                    <img src="img/3.PNG">
                    <h6>몸이 약한 아이</h6>
                    </div>
                    <div id="div1">
                    <img src="img/4.PNG">
                    <h6>수분 섭취가 부족한 아이</h6>
                    </div>
                </fieldset>
                <hr>
            </form>
            <form action="snack.html" method="get">
                <fieldset id="formQuestion">
                    <p id="text">To:geDog, 우리는 특별합니다</p><br>
                    <div id="div1">
                    <h5>입맛 없는 아이</h5>
                        <p>국내외 수의영양학 데이터를<br>
                        기반으로 반려견의 상태에<br>
                        가장 적합한 간식을 제공합니다</p>
                    </div>
                    <div id="div1">
                    <h5>소화 기능이 약한 아이</h5>
                        <p>높은 고기 함유량은 물론<br>
                        맛과 풍미가 그대로 살아있어<br>
                        선호도가 높습니다</p>
                    </div>
                    <div id="div1">
                    <h5>몸이 약한 아이</h5>
                        <p>75℃이하 진공저온 공법을<br>
                        활용하여 동결건조보다도<br>
                        영양소 손실이 적습니다</p>
                    </div>
                    <div id="div1">
                    <h5>수분 섭취가 부족한 아이</h5>
                    <p>수비드 조리법은 저온살균<br>
                    방식으로 식중독 예방은 물론<br>
                    겨울철 상온보관도 가능합니다</p>
                    </div>
                    <input class="button1" type="submit" value="맞춤간식 만들기">
                </fieldset>
                <hr>
            </form>
            <form action="photoshoot.html" method="get">
                <fieldset id="formQuestion">
                    <p id="text">To:geDog만의 특별한 포토 슛을 만나보세요</p><br>
                    <div id="div2">
                    <h5 id="textP">세심한 디테일</h5>
                        <p>To:geDog은 세세한 부분<br>
                        하나하나 신경써서<br>
                        포토 슛을 준비합니다</p>
                    </div>
                    <div id="div2">
                    <h5 id="textP">여러가지 테마</h5>
                        <p>To:geDog에서 준비한<br>
                        8가지의 각종 테마를<br>
                        취향에 맞게 골라보세요</p>
                    </div>
                    <div id="div2">
                    <img src="img/개해맑.jpg">
                    </div>
                    <div id="div3">
                    <input class="button2" type="submit" value="포토 슛 예약하기"></div>
                </fieldset>
            </form>


        </div>
    </div>
    <hr>
    <footer>
        <div class="footer">
            <p style="font-size: 16px;">고객센터<br><img src="https://cdn.onlinewebfonts.com/svg/img_1059.png" style="width: 35px; height: 35px;">02-123-4567</p>
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
           <a href="#">
            <div class="img_go" style="padding-left: 20px;">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_108495.png" style="width: 35px; height: 35px; "></div>
                <div style="width: 50px;">장바구니</div>
            </div></a>
            <a href="#">
            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_214830.png" style="width: 35px; height: 35px; "></div>
                <div style="width: 50px;">후원하기</div>
                </div></a>
            <a href="#">
            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_377674.png" style="width: 35px; height: 35px; "></div>
                <a href="#"><div style="width: 50px;">주문조회</div></a>
                </div></a>
            <a href="#">
            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_377768.png" style="width: 35px; height: 35px; "></div>
                <div style="width: 50px;">공지사항</div>
                </div></a>
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