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
        width: 1200px;
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

    #btnList {
        width: 140px;
        height: 40px;
        background-color: darkgray;
        color: black;
        font-size: 15px;
        font-weight: bold;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        border-bottom-right-radius: 10px;
        border-bottom-left-radius: 10px;
        border: none;
        margin: 0px 20px;
        cursor: pointer;
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
        border: none;
        margin: 0px 20px;
        cursor: pointer;
    }

    #PText {
        font-size: 17px;
        font-weight: bold;
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
        right: 105px;
    }

    #DeliveryPrice {
        font-size: 20px;
        font-weight: bold;
        position: relative;
        right: 52px;
    }

    #TotalPrice {
        font-size: 20px;
        font-weight: bold;
        color: red;
        position: relative;
        text-align: right;
        bottom: 107px;
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
        font-size: 17px
    }

    .bak_item {
        height: 150px;
        margin: 10px;
    }
</style>

<body>
    <div id="wrapper">
        <div id="header"></div>
        <div id="nav"></div>
        <div id="contents">
            <p style="text-align: right; font-size: 13px;">홈 > 장바구니</p>
            <c:if test="${not empty pList }">
            <form action="/views/paymentApi.jsp" method="post">
                <legend id="legendtitle">장바구니</legend><br>
                <table class="list-table">
                    <thead>
                        <tr>
                            <th width="700">상품 정보</th>
                            <th width="150">수량</th>
                            <th width="150">배송비</th>
                            <th width="200">상품 금액</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${pList }" var="cart">
                        <tr>
                            <td width="700">
                                <div class="bak_item" style="float: left;">
                                
                                    <img src="${cart.img }" style="width: 150px; height: 150px;">
                                </div>
                                <div style="float: left; position: relative; top: 20px; font-size: 20px;">${cart.productName}</div><br><br><br>
                                <div style="float: left; font-size: 15px;">배송일 평균 3일 이상 소요</div>
                            </td>
                            <td width="150" >${cart.quantity}개</td>
                            <td width="150">무료</td>
                            <td width="200" class="cartTotal">${cart.discount * cart.quantity}원</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div style="text-align: right; position: relative; right: 45px;">
                    <span id="PText">총 ${cart.quantity} 개의 상품 금액</span>
                    <span id="Pcalculate"> + </span>
                    <span id="PText">배송비</span>
                    <span id="Pcalculate"> = </span>
                    <span id="PText" style="position: relative; left: 5px;">합계</span>
                </div>
                <div style="text-align: right; position: relative; right: 84px;">
                    <span id="Price">0원</span>
                    <span id="DeliveryPrice">무료</span>
                </div>
                <hr>
                <input type="submit" value="구매하기" id="btnbuy" style="position: relative; left:510px;">
            </form>
            
            <div style="text-align: right;">
                     <form action="/cart/delete" method="post">
			            <input type="hidden" value="${cart.img }" name="img">
			            <input type="hidden" value="${cart.productNo }" name="productNo">
			            <input type="hidden" value="${cart.productName }" name="productName">
			            <input type="hidden" value="${cart.price}" name="price">
			            <input type="hidden" value="${cart.discount }" name="discount">
            			<input type="submit" value="상품 삭제" id="btnList" style="position: relative; bottom: 40px; right: 186px;">
            		</form>
            <p id="TotalPrice" style="position: relative; bottom: 145px;">${cart.discount * cart.quantity}원</p>
            </div>
            
            </c:if>

            <c:if test="${empty pList }">
            	<form action="#" method="post">
                <legend id="legendtitle">장바구니</legend><br>
                <table class="list-table">
                    <thead>
                        <tr>
                            <th width="700">상품 정보</th>
                            <th width="150">수량</th>
                            <th width="150">배송비</th>
                            <th width="200">상품 금액</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        </tr>
                    </tbody>
                </table>
                <br><br><br><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkS09s11PsHWRkRykmq_NBiamMtfim9tf2NA&usqp=CAU" style="width: 100px; height: 100px;">
                            <p>장바구니가 비어 있습니다</p><br><br><br>
                <div style="text-align: right; position: relative; right: 45px;">
                    <span id="PText">총 0 개의 상품 금액</span>
                    <span id="Pcalculate"> + </span>
                    <span id="PText">배송비</span>
                    <span id="Pcalculate"> = </span>
                    <span id="PText" style="position: relative; left: 5px;">합계</span>
                </div>
                <div style="text-align: right; position: relative; right: 84px;">
                    <span id="Price">0원</span>
                    <span id="DeliveryPrice">무료</span>
                </div>
                <hr>
                <div style="text-align: right;">
                    <a href=""><input type="button" value="상품 삭제" id="btnList"></a>
                    <input type="submit" value="구매하기" id="btnbuy">
                </div>
                <p id="TotalPrice" style="position: relative; right: 40px;">0원</p>
            </form>
            </c:if>
        </div><br>
        <hr>
        <div id="footer"></div>
    </div>
</body>
<script>
    /* include */
    var sum = 0;
    $(document).ready(function() {
        $("#header").load("/include/headerWeb.jsp");
        $("#nav").load("/include/navWeb.jsp");
        $("#footer").load("/include/footerWeb.html");
        $(".cartTotal").each(function(idx, item) {
        	var num = parseInt($(item).html());
        	sum += num;
        });
        $("#Price").html(sum + "원");
        $("#TotalPrice").html(sum + "원");
    });
</script>
</html>





