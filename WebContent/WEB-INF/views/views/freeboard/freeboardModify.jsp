<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<title>자유게시판 - 글 수정</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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

        div {
            box-sizing: border-box;
        }
        a{
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
            height:750px;
            width:900px;
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
        #menu ul{
            content: "|";
        }
        #formQuestion {
            text-align: center;
            border: none; 
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
        nav {
            font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif
            display: flex;
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
        #buttonW {
            width :140px;
            height: 40px; 
            background-color: black;
            color: white;
            font-size: 15px;
            font-weight: 1000;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
            border-bottom-right-radius: 15px;
            border-bottom-left-radius: 15px;
        }
        #buttonR {
            width : 140px;
            height: 40px; 
            background-color: darkgray;
            color: black;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
            border-bottom-right-radius: 15px;
            border-bottom-left-radius: 15px;
        }
    </style>
</head>
<body>
   <div id="wrapper">
        <div id="head">
            <div id="head1">
                <a href="/cs.html" id="top">고객센터</a>
                <a href="#" id="top">장바구니</a>
                <a href="/enroll.html" id="top">회원가입</a>
                <a href="/login.html" id="top">로그인</a>
            </div>
                <a href="/index.html" id="home"> <img src="/img/logo.png" id="img" width="100" height="100">To:geDog</a><br>
        </div>
        <br><br><br><br>
        <nav role="navigation" style="width: 100%;">
            <ul id="main-menu" style="position: relative; left: 250px;">
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
                        <li><a href="#">포토 후기</a></li>
                    </ul>
                </li>
                <li><a href="board.html">BOARD</a>
                    <ul id="sub-menu">
                        <li><a href="/freeboard/list">게시판</a></li>
                        <li><a href="/notice/list">Q & A</a></li>
                        <li><a href="/comboard/list">정보 공유</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="contents">
            <br><br><br><br><br>
            

	<form action="/freeboard/modify" method="post">
                <legend style="text-align: left;">자유게시판 - 글 수정</legend>
                <hr><br><p id="textP">제목</p>
                <input type="text" size="70" placeholder="제목을 작성하세요" name="subject" value="${freeboard.freeSubject }" style="border: 1px solid black;"><br><br>
				<p id="textP">내용</p>
                <textarea rows="10" cols="72" placeholder="내용을 작성하세요" name="content" >${freeboard.freeContents }</textarea><br><br>
				<input type="hidden" name="freeNoticeNo" value="${freeboard.freeNoticeNo }">
                <input type="submit" value="수정하기" id="buttonW">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" onclick="javascript:history.back();" value="취소" id="buttonR">
            </form>
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
            예금주: 김수연<br><br>

            <p style="font-size: 16px;">후원계좌</p>
            국민 523202 - 04 - 030162<br>
            예금주: 김수연<br>

        </div>
        <div class="footer">
            <div class="vertical"></div>
            <p style="font-size: 16px;">바로가기</p><br>
           <a href="#">
            <div class="img_go" style="padding-left: 20px;">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_108495.png" style="width: 35px; height: 35px; position: relative; right: 8px"></div>
                <div style="width: 50px; position: relative; right: 10px">장바구니</div>
            </div></a>
            <a href="/support.html">
            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_214830.png" style="width: 35px; height: 35px; "></div>
                <div style="width: 50px; position: relative; left: 5px">후원하기</div>
                </div></a>
            <a href="mypage.html">
            <div class="img_go">
                <div><img src="https://cdn.onlinewebfonts.com/svg/img_377674.png" style="width: 35px; height: 35px; "></div>
                <div style="width: 50px; position: relative; left: 3px">주문조회</div>
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
            <br>
            상호 : To:geDog | 비선실세 : 김수연<br>
            주소 : 서울특별시 중구 남대문로 120 대일빌딩<br>
            메일 semi@togedog.co.kr<br>
            팩스 : 02-1236-4567<br>
            사업자등록번호 : 123-45-67890

        </div>
    </footer>
    </div>
    <script>
      function modify() {
         var result = confirm("글을 수정 하시겠습니까?");
         if(result) {
            return true;
         } else {
            return false;
         }
      }
   </script> 
</body>
</html>