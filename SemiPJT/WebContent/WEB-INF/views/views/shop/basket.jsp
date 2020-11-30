<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - 장바구니</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style>
    div {
        font-family: 맑은고딕;
    }
    
    #contents {
        width: 900px;
        height: 550px;
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

    #btnbuy {
        width: 140px;
        height: 40px;
        background-color: black;
        color: white;
        font-size: 15px;
        font-weight: bold;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        border-bottom-right-radius: 10px;
        border-bottom-left-radius: 10px;
        position: relative;
        left: 380px;
    }

    #PText {
        font-size: 17px;
        font-weight: 1000;
    }

    #Pcalculate {
        font-size: 40px;
        font-weight: 1000;
        position: relative;
        top: 24px;
    }

    #Price {
        font-size: 20px;
        font-weight: bold;
        position: relative;
        right: 133px;
    }

    #DeliveryPrice {
        font-size: 20px;
        font-weight: bold;
        position: relative;
        right: 63px;
    }

    #TotalPrice {
        font-size: 20px;
        font-weight: bold;
        color: red;
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
        color: black;
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
</style>

<body>
    <div id="header"></div>
    <div id="nav"></div>
    <div id="contents">
        <p style="text-align: right; font-size: 13px;">홈 > 장바구니</p>
        <c:if test="${empty cart }">
        <form action="#" method="post">
            <legend id="legendtitle">장바구니</legend><br>
            <hr>
            <br><br><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkS09s11PsHWRkRykmq_NBiamMtfim9tf2NA&usqp=CAU" style="width: 100px; height: 100px;">
            <p>장바구니가 비어 있습니다</p><br><br>
            <div style="text-align: right;">
                <span id="PText">총 0 개의 상품 금액</span>
                <span id="Pcalculate"> + </span>
                <span id="PText">배송비</span>
                <span id="Pcalculate"> = </span>
                <span id="PText">합계</span>
            </div>
            <div style="text-align: right;">
                <span id="Price">0원</span>
                <span id="DeliveryPrice">0원</span>
                <span id="TotalPrice">0원</span>
            </div>
            <hr>
            <input type="submit" value="구매하기" id="btnbuy">
        </form>
        </c:if>
        <c:if test="${not empty cart }">
        <form action="#" method="post">
            <legend id="legendtitle">장바구니</legend><br>
            <hr>
            <br><br>
             <ul id="ulTable" class="myul">
                <li class="myli">
                    <ul class="myul">
                        <li class="myli">상품이미지</li>
                        <li class="myli">상품명</li>
                        <li class="myli">뭘 넣어야 할까?</li>
                        <li class="myli">옵션</li>
                    </ul>
                </li>
                <!-- 게시물이 출력될 영역 -->
                <li class="myli">
                    <ul class="myul">
                        <li class="myli"><img src="${cart.img }" width="135px" height="131px"></li>
                        <li class="myli">
                            <div class="verticalO">${cart.productName }</div>
                        </li>
                        <li class="myli">
                            <div class="verticalO"></div>
                        </li>
                        <li class="myli">
                            <div class="verticalO"></div>
                        </li>
                    </ul>
                </li>
            </ul>

            <br><br>
            <div style="text-align: right;">
                <span id="PText">총 ${cart.quantity} 개의 상품 금액</span>
                <span id="Pcalculate"> + </span>
                <span id="PText">배송비</span>
                <span id="Pcalculate"> = </span>
                <span id="PText">합계</span>
            </div>
            <div style="text-align: right;">
                <span id="Price">${cart.discount * cart.quantity}원</span>
                <span id="DeliveryPrice">무료</span>
                <span id="TotalPrice">${cart.discount * cart.quantity}원</span>
            </div>
            <hr>
            <input type="submit" value="구매하기" id="btnbuy">
            </form>
            <form action="/cart/delete" method="post">
	            <input type="hidden" value="${cart.img }" name="img">
	            <input type="hidden" value="${cart.productNo }" name="productNo">
	            <input type="hidden" value="${cart.productName }" name="productName">
	            <input type="hidden" value="${cart.price}" name="price">
	            <input type="hidden" value="${cart.discount }" name="discount">
	            <input type="submit" value="상품 삭제" id="btndel">
        </form>
        </c:if>
    </div>
    <div id="footer"></div>
</body>
<script type="text/javascript">
    /* include */
    $(document).ready(function() {
        $("#header").load("/include/header.jsp")
        $("#nav").load("/include/nav.html")
        $("#footer").load("/include/footer.html")
    });
</script>
</html>