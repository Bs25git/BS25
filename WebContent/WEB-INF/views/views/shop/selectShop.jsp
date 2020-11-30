<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - 상품구매</title>
	<style>
	    div {
	        font-family: 맑은고딕;
	    }
	
	    #contents {
	        width: 900px;
	        margin: 0 auto;
	        position: relative;
	        bottom: 35px;
	    }
	
	    #legendtitle {
	        text-align: left;
	        font-size: 24px;
	        font-weight: bold;
	    }
	
	    ul,
	    li {
	        margin: 15px 0px;
	        padding: 0px;
	        list-style: none;
	    }
	
	    #inputbox {
	        border: 1px solid black;
	        width: 185px;
	        height: 25px;
	    }
	
	    #productinfo_img {
	        width: 50%;
	        float: left;
	    }
	
	    #productinfo {
	        width: 50%;
	        float: left;
	    }
	
	    #basket {
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
	        cursor: pointer;
	        margin: 0px 25px;
	    }
	
	    #buy {
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
	        cursor: pointer;
	        margin: 0px 25px;
	    }
	
	    #btn_detail1,
	    #btn_detail2,
	    #btn_detail3 {
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
	        margin: 0px 15px;
	    }
	</style>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
	    /* include */
	    $(document).ready(function() {
	        $("#header").load("/include/header.jsp");
	        $("#nav").load("/include/nav.html");
	        $("#footer").load("/include/footer.html");
	        
	        $("#btn_detail1").click(function() {
	            $("#productinfo1").show();
	            $("#productinfo2").hide();
	            $("#productinfo3").hide();
	        });
	        $("#btn_detail2").click(function() {
	            $("#productinfo1").hide();
	            $("#productinfo2").show();
	            $("#productinfo3").hide();
	        });
	        $("#btn_detail3").click(function() {
	            $("#productinfo1").hide();
	            $("#productinfo2").hide();
	            $("#productinfo3").show();
	        });
	        $("#count").on("click", function(e){
	           var amount = (${shop.discount}*$("#count").val());
	           $('#productdetail_total b').empty();
	           $("#productdetail_total b").append("상품 총 금액 : " + amount + "원");
	        
	        });
	    });
	    function bag(){
	        <c:if test="${sessionScope.member.userId eq null }">
	            alert("로그인 후 이용해주세요.");
	            location.href="/views/member/login.jsp";
	            return false;
	        </c:if>
	     }    
	
	</script>
</head>
<body>
    <div id="header"></div>
    <div id="nav"></div>
    <div id="contents">
        <p style="text-align: right; font-size: 13px;">홈 > 상품구매</p>
        <form action="/cart/add" method="post">
   
            <input type="hidden" value="${shop.img }" name="img">
            <input type="hidden" value="${shop.productNo }" name="productNo">
            <input type="hidden" value="${shop.productName }" name="productName">
            <input type="hidden" value="${shop.price}" name="price">
            <input type="hidden" value="${shop.discount }" name="discount">
            <div id="productinfo_img">
                <img src="${shop.img }" style="width:420px;height:420px;">
            </div>                 
            <div id="productinfo">
                <ul>
                    <hr>
                    <li style="font-weight: bold; font-size: 19px; margin: 10px;">${shop.productName }</li>
                    <hr>
                    <li style="margin: 20px 10px;">소비자가<del style="position: relative; left: 95px;">${shop.price }원</span></li>
                    <li style="margin: 20px 10px;">할인가<span style="position: relative; left: 111px;">${shop.discount }원</del></li>
                    <li style="margin: 20px 10px;">수량<input type="number" value="1" min="1" max="100" style="width: 30px; height: 20px; position: relative; left: 127px;" id="count" name="quantity"></li>
     
                    <li style="margin: 20px 10px;">배송방법<span style="position: relative; left: 95px;">택배</span></li>
                    <li style="margin: 20px 10px;">배송비<span style="position: relative; left: 111px;">무료</span></li>
                    <li style="margin: 20px 10px;">옵션
                        <select style="position: relative; left:122px; width: 250px; height: 25px;">
                            <option value="1" selected>[옵션] 옵션을 선택해 주세요</option>
                            <option value="2">먼지 사랑</option>
                            <option value="3">먼지는 기욤 기욤</option>
                        </select>
                    </li>
                    <hr>
             
                    <li style="margin: 10px; text-align: right;"><div id="productdetail_total"><b> 총 금액 :  ${shop.discount }</b></div><br><br></li>
                        <div style="text-align: center;">
                            <input type="submit" value="장바구니 담기" onclick="return bag();" id="basket">
                            <a href="/index.jsp"><input type="button" value="바로 구매" onclick="return bag();" id="buy"></a>
                        </div>
                </ul>
            </div>
        </form>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <div>
            <div style="text-align: center;">
                <button id="btn_detail1">상품 상세 정보</button>
                <button id="btn_detail2">상품 구매 안내</button>
                <button id="btn_detail3">환불 / 교환 안내</button>
            </div><br><br>
            <div>
                <div id="productinfo1" hidden>
                    <b style="font-size: 20px;">상품 상세 정보</b>
                    <hr noshade>
                    <img src="${shop.infoImg1}" width="900px">
                    <img src="${shop.infoImg2}" width="900px">
                    <img src="${shop.infoImg3}" width="900px">
                </div>
                <div id="productinfo2" hidden>
                    <b style="font-size: 20px;">상품 결제 정보</b>
                    <hr noshade>
                    <p>고액결제의 경우 안전을 위해 카드사에서 확인전화를 드릴 수도 있습니다.
                        확인과정에서 도난 카드의 사용이나 타인 명의의 주문 등 정상적인 주문이 아니라고
                        판단될 경우 임의로 주문을 보류 또는 취소할 수 있습니다.<br><br>
                        무통장 입금은 상품 구매 대금은 PC뱅킹, 인터넷뱅킹, 텔레뱅킹 혹은 가까운 은행에서 직접 입금하시면 됩니다.
                        주문시 입력한 입금자명과 실제 입금자의 성명이 반드시 일치하여야 하며, 7일 이내로 입금을 하셔야 하며
                        입금되지 않은 주문은 자동취소 됩니다.</p>
                    <br><br><br>
                    <b style="font-size: 20px;">배송정보</b>
                    <hr noshade>
                    <p>산간벽지나 도서지방은 별도의 추가금액을 지불하셔야하는 경우가 있습니다.<br><br>
                        고객님께서 주문하신 상품은 입금 확인 후 배송해 드립니다.<br>다만, 상품종류에 따라서 상품의 배송이 다소 지연될 수 있습니다.
                    </p>
                </div>
                <div id="productinfo3" hidden>
                    <b style="font-size: 20px;">교환 및 반품정보</b>
                    <hr noshade>
                    <p>교환 및 반품 주소<br>
                        - 우리집<br><br>

                        교환 및 반품이 가능한 경우<br>
                        - 상품을 공급 받읜 날로부터 7일이내 단, 가전제품의 경우 포장을 개봉하였거나 포장이 훼손되어
                        상품가치가 상실된 경우에는 교환/반품이 불가능합니다.<br>
                        - 공급받으신 상품 및 용역의 내용이 표시 광고 내용과 다르거나 다르게 이행된 경우에는 공급받은 날로부터<br>
                        3월이내, 그 사실을 알게 된 날로부터 30일이내
                        <br><br>

                        교환 및 반품이 불가능한 경우<br>
                        - 고객님의 책임 있는 사유로 상품등이 멸실 또는 훼손된 경우<br>
                        단, 상품의 내용을 확인하기 위하여 포장 등을 훼손한 경우는 제외<br>
                        - 포장을 개봉하였거나 포장이 훼손되어 상품가치가 상실된 경우<br>
                        (예 : 가전제품, 식품, 음반 등, 단 액정화면이 부착된 노트북, LCD모니터, 디지털 카레마 등의 불량화소에
                        따른 반품/교환은 제조사 기준에 따릅니다.)<br>
                        - 고객님의 사용 또는 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우 단, 화장품 등의 경우 사용제품을<br>
                        제공한 경우에 한 합니다.<br>
                        - 시간의 경과에 의하여 재만패가 곤란할 정도로 상품등의 가치가 현저히 감소한 경우<br>
                        - 복제가 가능한 상품등의 포장을 훼손한 경우<br>
                        (자세한 내용은 고객만족센터 1:1 상듬을 이용해 주시기 바랍니다.)
                        <br><br>
                        ※ 고객님의 마음이 바뀌어 교환, 반품을 하실 경우 상품반송 비용은 고객님께서 부담하셔야 합니다.<br>
                        (색상 교환, 사이즈 교환 등 포함)
                    </p>
                </div>
            </div>
        </div><br><br><br>
    </div>
    <hr>
    <div id="footer"></div>
</body>

</html>