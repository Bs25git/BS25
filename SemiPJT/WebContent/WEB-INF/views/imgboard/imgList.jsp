<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
    <meta charset="UTF-8">
    <title>To:geDog - 포토 후기</title>
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

    #item_content {
   		font-weight : bold;
        margin-top: 5px;
    }

    #user_img {
        width: 23px;
        height: 23px;
        position: relative;
        top: 7px;
    }

    #item_userId {
        margin-top: 5px;
        margin-bottom: 10px;
        font-size: 14px;
        text-align: center;
    }

    #item_regDate {
        font-size: 12px;
        text-align: center;
    }

    #pagingbtn {
        text-align: center;
        position: relative;
        right: 5px;
    }

    #upload {
        text-align: right;
    }

    #btnfileselect {
        display: inline-block;
        padding: .5em .5em;
        /* label의 패딩값과 일치 */
        border: 1px solid #ebebeb;
        position: relative;
        top: 2px;
        right: 5px;
        border-radius: .25em;
        width: 178px;
    }

    #reviewbox {
        width: 170px;
        height: 25px;
        text-align: center;
    }

    #btnupload {
        width: 60px;
        height: 32px;
        background-color: black;
        border: none;
        color: white;
        font-weight: bold;
        position: relative;
        top: 1px;
        cursor: pointer;
    }

    #btnreset {
        width: 50px;
        height: 32px;
        background-color: darkgray;
        color: black;
        border: none;
        font-weight: bold;
        position: relative;
        top: 1px;
        cursor: pointer;
    }

 .modal {
        position: fixed;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        opacity: 0;
        visibility: hidden;
        transform: scale(1.1);
        transition: visibility 0s linear 0.25s, opacity 0.25s 0s, transform 0.25s;
    }
    .modal-content {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
        padding: 1rem 1.5rem;
        width: 24rem;
        border-radius: 0.5rem;
    }
    .close-button {
        float: right;
        width: 1.5rem;
        line-height: 1.5rem;
        text-align: center;
        cursor: pointer;
        border-radius: 0.25rem;
        background-color: lightgray;
    }
    .close-button:hover {
        background-color: darkgray;
    }
    .show-modal {
        opacity: 1;
        visibility: visible;
        transform: scale(1.0);
        transition: visibility 0s linear 0s, opacity 0.25s 0s, transform 0.25s;
    }
	
</style>

<body>

    <div id="wrapper">
        <div id="header"></div>
        <div id="nav"></div>
        <div id="contents">
            <p style="text-align: right; font-size: 13px;">홈 > 포토 후기</p>
            <legend id="legendtitle">포토 후기</legend><br>
            <hr>
            <c:set var="i" value="0" />
           <c:set var="j" value="4" />
           <table>
           <c:forEach items="${iList }" var="imgBoard">
           <c:if test="${i%j == 0 }"> 
           <tr>
           </tr>
         </c:if>
                <td>
                        <div id="item">
                            <div id="item_img" >
                                <a class="trigger"><img src="${imgBoard.filePath}" style="width:200px;height:200px;"></a>
                            </div>
                            <div id="item_content">
                                ${imgBoard.content }
                            </div>
                            <hr>
                            <div id="item_userId">
                                <img src="/img/profile.jpg" id="user_img"> ${imgBoard.userId }
                            </div>
                            <div id="item_regDate">
                                ${imgBoard.regDate }
                            </div>
                        </div>
                </td>
          <c:if test="${i%j == j-1 }">
          </c:if> 
          <c:set var="i" value="${i+1 }" />
          </c:forEach>
          </table><br><br><br>
            <div id="pagingbtn">
                ${pageNavi }
            </div><br><br><br>
            <div id="upload">
                <form action="/img/uploadFile" method="post" enctype="multipart/form-data">
                    <input type="file" name="img" id="btnfileselect">
                    <input type="text" name="content" placeholder="한마디 리뷰를 적어주세요" id="reviewbox">
                    <input type="submit" value="업로드" id="btnupload">
                    <input type="reset" value="취소" id="btnreset">
                </form>
            </div>
        </div><br><br><br>
        <hr>
        <div id="footer"></div>
        <div class="modal">
        <div class="modal-content">
            <span class="close-button">&times;</span>
            <h1><img src="/img/logo.png" style="width:350px;height:300px;"></h1>
            <p style="text-align:center;"><img src="/img/profile.jpg" id="user_img">우리먼지 귀엽죠?</p>
        </div>
    </div>
    </div>

<!-- Magnific Popup core JS file -->
<script src="magnific-popup/jquery.magnific-popup.js"></script>
</body>
<script type="text/javascript">
    /* include */
    $(document).ready(function() {
        $("#header").load("/include/headerWeb.jsp")
        $("#nav").load("/include/navWeb.html")
        $("#footer").load("/include/footerWeb.html")
    });
    var modal = document.querySelector(".modal");
    var trigger = document.querySelector(".trigger");
    var closeButton = document.querySelector(".close-button");

    function toggleModal() {
        modal.classList.toggle("show-modal");
    }

    function windowOnClick(event) {
        if (event.target === modal) {
            toggleModal();
        }
    }

    trigger.addEventListener("click", toggleModal);
    closeButton.addEventListener("click", toggleModal);
    window.addEventListener("click", windowOnClick);
	
</script>

</html>
