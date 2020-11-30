<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - 마이페이지</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<style>
    div {
        font-family: 맑은고딕;
    }

    #contents {
        width: 1200px;
        height: 1000px;
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

    ul,
    li {
        margin: 15px 0px;
        padding: 0px;
        list-style: none;
    }

    #agreementmargin {
        margin: 15px 0px;
        padding: 0px;
    }

    #inputbox,
    #postCode {
        border: 1px solid black;
        width: 185px;
        height: 25px;
    }

    #roadAddr,
    #detailAddr {
        border: 1px solid black;
        width: 291px;
        height: 25px;
    }

    #addrSearchBtn {
        width: 100px;
        height: 30px;
        background-color: black;
        color: white;
        font-size: 14px;
        font-weight: 1000;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
        border-bottom-left-radius: 5px;
        cursor: pointer;
    }

    #buttonW {
        width: 150px;
        height: 40px;
        background-color: black;
        color: white;
        font-size: 15px;
        font-weight: bold;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
        border-bottom-right-radius: 15px;
        border-bottom-left-radius: 15px;
        border: none;
        position: relative;
        left: 390px;
        cursor: pointer;
    }

    #buttonR {
        width: 150px;
        height: 40px;
        background-color: darkgray;
        color: black;
        font-size: 15px;
        font-weight: bold;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
        border-bottom-right-radius: 15px;
        border-bottom-left-radius: 15px;
        border: none;
        position: relative;
        left: 135px;
        bottom: 55px;
        cursor: pointer;
    }

    .myul,
    .myli {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    form ul {
        list-style: none;
    }

    form ul>li {
        text-align: left;
        width: 900px;
    }


    #ulTable {
        margin-top: 10px;
        width: 1000px;
        margin: auto;
    }

    #ulTable>li:first-child>ul>li {
        background-color: #272727;
        font-weight: bold;
        text-align: center;
        color: white;
        font-size: 15px;
        height: 23px;
        vertical-align: middle;
    }

    #ulTable>li>ul>li {
        background-color: white;
        font-weight: bold;
        text-align: center;
        color: white;
        font-size: 15px;
        height: 130px;
        vertical-align: middle;
    }

    #ulTable>li>ul {
        clear: both;
        padding: 0px auto;
        position: relative;
        min-width: 40px;
    }

    #ulTable>li>ul>li {
        float: left;
        font-size: 10pt;
        border-bottom: 1px solid silver;
        vertical-align: baseline;
    }

    #ulTable>li>ul>li:first-child {
        width: 15%;
    }

    /*No 열 크기*/
    #ulTable>li>ul>li:first-child+li {
        width: 55%;
    }

    /*제목 열 크기*/
    #ulTable>li>ul>li:first-child+li+li {
        width: 15%;
    }

    /*작성일 열 크기*/
    #ulTable>li>ul>li:first-child+li+li+li {
        width: 15%;
    }

    /*작성자 열 크기*/
    .verticalO {
        border-left: 1px solid silver;
        height: 130px;
        position: absolute;
    }

    .list-table thead th {
        height: 40px;
        border-top: 2px solid #09C;
        border-bottom: 1px solid #CCC;
        font-weight: bold;
        font-size: 17px;
    }

    .list-table tbody td {
        text-align: center;
        padding: 10px 0;
        border-bottom: 1px solid #CCC;
        height: 20px;
        font-weight: bold;
        font-size: 14px
    }

    .bak_item {
        height: 150px;
        margin: 10px;
    }

    #delivery_check {
        width: 100px;
        height: 30px;
        background-color: black;
        color: white;
        font-size: 14px;
        font-weight: 1000;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
        border-bottom-left-radius: 5px;
        cursor: pointer;
    }
</style>

<body>
    <div id="wrapper">
        <div id="header"></div>
        <div id="nav"></div>
        <div id="contents">
            <p style="text-align: right; font-size: 13px;">홈 > 마이페이지</p>
            <form action="/member/update" method="post">
                <legend id="legendtitle">주문조회</legend>
                <br>
                <table class="list-table">
                    <thead>
                        <tr>
                            <th width="700">구매 상품 정보</th>
                            <th width="150">날짜</th>
                            <th width="150">주문번호</th>
                            <th width="200">운송장 조회</th>
                        </tr>
                    </thead>
                    <tbody>
                   
                        <tr>
                            <td width="700">
                                <div class="bak_item" style="float: left;">
                                    <img src="/img/logo.png" style="width: 150px; height: 150px;">
                                </div>
                                <div style="float: left; position: relative; top: 20px; font-size: 20px;">제 이름은 먼지 입니당</div><br><br><br>
                                <div style="float: left; position: relative; top: 20px; font-size: 15px;">배송일은 물어보지 마세요</div>
                            </td>
                            <td width="150">1996년 09월 12일</td>
                            <td width="150">2584-5959-82749</td>
                            <td width="200"><button id="delivery_check" onclick="window.open('https://www.cjlogistics.com/ko/tool/parcel/tracking')">운송장 조회</button></td>
                        </tr>
                    </tbody>
                </table>
                <br><br><br><br>
                <legend id="legendtitle">개인정보</legend>
                <br>
                <hr>
                <ul>
                    <li>&nbsp;아이디<input type="text" name="userId" id="inputbox" style="position: relative; left: 94px" value="${member.userId}" readonly>
                        <snap style="font-size: 13px; position: relative; left: 110px;">(영문 소문자 / 숫자, 6~15자)</snap>
                    </li>
                    <hr>
                    <li>&nbsp;비밀번호<input type="password" name="userPwd" id="inputbox" style="position: relative; left: 78px">
                        <snap style="font-size: 13px; position: relative; left: 94px;">(영문 소문자 / 숫자 / 특수문자 중 2가지 이상 조합, 10~15자)</snap>
                    </li>
                    <hr>
                    <li>&nbsp;비밀번호 확인<input type="password" name="userPwdC" id="inputbox" style="position: relative; left: 40px"></li>
                    <hr>
                    <li>&nbsp;이름<input type="text" value="${member.name }" name="name" id="inputbox" style="position: relative; left: 110px" readonly></li>
                    <hr>
                    <li>&nbsp;폰번호<input type="phone" name="phone" id="inputbox" style="position: relative; left: 94px" value="${member.phone}"></li>
                    <hr>
                    <li>&nbsp;이메일<input type="email" name="email" id="inputbox" style="position: relative; left: 94px" value="${member.email}"></li>
                    <hr>
                    <li>&nbsp;주소<input type="text" id="postCode" style="position: relative; left: 110px" value="${member.zipcode }" name="zipcode">
                        <button id="addrSearchBtn" style="position: relative; left: 110px">주소검색</button>
                    </li>
                    <li><input type="text" id="roadAddr" style="position: relative; left: 147px" value="${member.address }" name="address"></li>
                    <li><input type="text" id="detailAddr" style="position: relative; left: 147px" placeholder="상세주소"></li>
                    <hr>
                    <input type="submit" onclick="return modify();" value="수정하기" id="buttonW">
                </ul>
            </form>
            <form action="/member/delete" method="post" style="text-align:center;">
                <input type="submit" onclick="return question();" value="회원탈퇴" id="buttonR">
            </form>
        </div><br><br><br>
        <hr>
        <div id="footer"></div>
    </div>
</body>
<script type="text/javascript">
    $(document).ready(function() {
        /* include */
        $("#header").load("/include/headerWeb.jsp")
        $("#nav").load("/include/navWeb.jsp")
        $("#footer").load("/include/footerWeb.html")
    });
</script>
<script>
    $("#addrSearchBtn").click(function(e) {
        /* 지도 API */
        e.preventDefault();
        new daum.Postcode({
            oncomplete: function(data) {
                $("#postCode").val(data.zonecode);
                $("#roadAddr").val(data.address);
                $("#jibunAddr").val(data.jibunAddress);
            }
        }).open();
    });
</script>
<script>
    function question() {
        var result = confirm("정말로 탈퇴하시겠습니까?");
        if (result) {
            return true;
        } else {
            return false;
        }
    }
</script>
<script>
    function modify() {
        var result = confirm("개인정보 수정 후, 로그아웃 됩니다.");
        if (result) {
            return true;
        } else {
            return false;
        }
    }
</script></html>