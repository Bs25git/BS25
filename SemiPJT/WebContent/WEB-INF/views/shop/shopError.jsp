<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - SHOPPING</title>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style>
    div {
        font-family: 맑은고딕;
    }

    #contents {
        width: 1200px;
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

    #product_explain {
        float: left;
        width: 50%;
        text-align: left;
        font-size: 13px;
    }

    #product_filter {
        float: left;
        width: 50%;
        text-align: right;
        font-size: 13px;
    }

    #filtertext {
        margin: 0px 10px;
    }

    #filtertext:hover {
        font-weight: bold;
    }

    #item {
        margin: 20px 47px;
    }

    #item_img {
        width: 200px;
        height: 200px;
    }

    #item_img:hover {
        transition-duration: 0.5s;
        transform: scale(0.95);
    }

    #item_title {
        margin-top: 5px;
    }

    #item_price {
        margin-top: 5px;
        margin-bottom: 10px;
        font-size: 13px;
        color: gray;
    }

    #item_discount {
        font-size: 14px;
    }

    #pagingbtn {
        text-align: center;
        position: relative;
        right: 5px;
    }

    #search {
        text-align: right;
    }

    #searchbox {
        width: 150px;
        height: 25px;
    }

    #btnsearch {
        width: 50px;
        height: 32px;
        background-color: black;
        border: none;
        color: white;
        font-weight: bold;
        position: relative;
        top: 1px;
        cursor: pointer;
    }

    #product_empty {
        font-size: 20px;
        font-weight: bold;
    }

    #product_empty_img {
        width: 50px;
        height: 50px;
    }
</style>

<body>
    <div id="wrapper">
        <div id="header"></div>
        <div id="nav"></div>
        <div id="contents">
            <p style="text-align: right; font-size: 13px;">홈 > SHOPPING</p>
            <legend id="legendtitle">상품 목록</legend><br>
            <div id="product_explain">${totalCount}개의 상품이 등록되어 있습니다.</div>
            <div id="product_filter">
                <a href="/all?category=new"><span id="filtertext">최신순</span></a>|
                <a href="/all?category=min"><span id="filtertext">낮은가격</span></a>|
                <a href="/all?category=max"><span id="filtertext">높은가격</span></a>
            </div>
            <br>
            <hr><br><br><br>
            <div style="text-align: center;">
                <img src="/img/logo.png" id="product_empty_img">
                <p id="product_empty">검색하신 상품이 존재하지 않아요</p>
            </div>
            <br><br><br>
            <div id="pagingbtn">
                ${pageNavi }
            </div><br>
            <div id="search">
                <form action="/allSearch" method="get">
                    <input type="text" name="search" id="searchbox">
                    <input type="hidden" name="category" value="all">
                    <input type="submit" value="검색" id="btnsearch">
                </form>
            </div>
        </div><br><br><br>
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