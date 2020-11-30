<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - 로그인</title>
    

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style>
    div {
        font-family: 맑은고딕;
    }

    #contents {
        width: 900px;
        height: 500px;
        text-align: center;
        margin: 0 auto;
        position: relative;
        bottom: 35px;
    }

    #Login {
        font-size: 30px;
        font-weight: bold;
    }

    #userId,
    #userPwd {
        border: 1px solid;
        width: 300px;
        height: 30px;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
        border-bottom-left-radius: 5px;
    }

    .btnLogin {
        width: 305px;
        height: 40px;
        background-color: black;
        color: white;
        font-size: 18px;
        font-weight: bold;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        border-bottom-right-radius: 10px;
        border-bottom-left-radius: 10px;
    }

    .btnKakao {
        width: 152.5px;
        height: 40px;
        background-color: #ffe26f;
        color: black;
        font-size: 15px;
        font-weight: bold;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        border-bottom-right-radius: 10px;
        border-bottom-left-radius: 10px;
        border: none;
    }

    .btnNaver {
        width: 152.5px;
        height: 40px;
        background-color: #2ecc71;
        color: white;
        font-size: 15px;
        font-weight: bold;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        border-bottom-right-radius: 10px;
        border-bottom-left-radius: 10px;
        border: none;
    }
    
    #enroll:hover{
        font-weight: bold;
    }
</style>

<body>
    <div id="header"></div>
    <div id="nav"></div>
    <div id="contents">
        <p style="text-align: right; font-size: 13px;">홈 > 로그인</p>
        <p id="Login">LOGIN</p>
        <form action="/member/login" method="post">
            <input type="text" name="userId" id="userId" placeholder="아이디"><br><br>
            <input type="password" name="userPwd" id="userPwd" placeholder="비밀번호"><br><br>
            <input class="btnLogin" type="submit" value="로그인">
            <br><br>
            <hr style="width: 310px;">
            <span>아이디찾기 | </span>
            <span>비밀번호 찾기 |</span>
            <span id="enroll" style="color: blue; cursor:pointer;">회원가입</span><br><br>
        </form>
        <button class="btnKakao">카카오로 시작</button>
        <button class="btnNaver">N&nbsp;&nbsp;&nbsp;네이버로 시작</button>
    </div>
    <hr>
    <div id="footer"></div>
</body>
<script type="text/javascript">
    /* include */
    $(document).ready(function() {
        $("#header").load("/include/headerWeb.jsp")
        $("#nav").load("/include/navWeb.html")
        $("#footer").load("/include/footerWeb.html")
    });
</script></html>