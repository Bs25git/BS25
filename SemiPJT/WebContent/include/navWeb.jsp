<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
    div {
        font-family: 맑은고딕;
    }
    
    .main_nav {
        z-index: 1;
        width: 100%;
        display: flex;
        justify-content: center;
        background-color: white; /* 네비 배경 색 */
        /* 흰색 외 네비 색 희망시 
        sub-menu에 position: absolute; 추가*/
    }

    .nav_li, .nav_ul {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    #main-menu>li {
        float: left;
    }

    #main-menu>li>a {
        color: black;
        font-weight: bold;
        text-decoration: none;
        text-shadow: 1px 2px 2px lightgray;
        letter-spacing: 0.1em; /* 자간 조정 */
        display: block;
        padding: 10px 70px; /* 글자간 간격 조정 */
        border-right: 1px solid lightgray;
    }
    
    #main-menu>li:nth-child(1)>a {
        border-left: 1px solid lightgray;
    }

    #sub-menu {
        background: wite; /* 서브 네비 배경 색 */
        text-align: center;
        visibility: hidden;
        opacity: 0;
        transition: all 0.3s ease-in; /* 네비 등장 시간 조정 */
        border: 1px solid lightgray;
        position: relative;
        top: 9px;
    }

    #sub-menu>li {
        padding: 10px 30px;
    }

    #sub-menu>li>a {
        color: black; /* 서브 네비 글자 색 */
        text-decoration: none;
    }

    #main-menu>li:hover #sub-menu {
        opacity: 10;
        visibility: visible;
    }

    #sub-menu>li>a:hover { /* 서브 네비 호버 효과 */
        font-weight: bold;
    }
    
</style>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<hr style="position: relative; top: 5px;">
<nav role="navigation" style="text-align: center;" class="main_nav">
    <ul id="main-menu" class="nav_ul">
        <li class="nav_li"><a href="/all?category=list">SHOPPING</a>
            <ul id="sub-menu" class="nav_ul">
                <li class="nav_li"><a href="/food?category=list">사료 & 간식</a></li>
                <li class="nav_li"><a href="/clothes?category=list">의류</a></li>
                <li class="nav_li"><a href="/toy?category=list">장난감</a></li>
            </ul>
        </li>
        <li class="nav_li"><a>BOOKING</a>
            <ul id="sub-menu" class="nav_ul">
                <li class="nav_li"><a href="/views/reservation/reservationDetail.jsp">예약문의</a></li>
                <li class="nav_li"><a href="/img/list" onclick="return bag();">포토 후기</a></li>
            </ul>
        </li>
        <li class="nav_li"><a>BOARD</a>
            <ul id="sub-menu" class="nav_ul">
                <li class="nav_li"><a href="/notice/list" onclick="return bag();">Q & A</a></li>
                <li class="nav_li"><a href="/freeboard/list" onclick="return bag();">자유 게시판</a></li>
                <li class="nav_li"><a href="/comboard/list" onclick="return bag();">정보 공유</a></li>
            </ul>
        </li>
    </ul>
</nav>
<script>
function bag(){
    <c:if test="${sessionScope.member.userId eq null }">
    swal({
        title: "로그인해라",
        text: "말대꾸 하지마라",
        icon: "warning"
    }).then(function() {
        window.location = "/views/member/login.jsp";
    });
        return false;
    </c:if>
 }      
	</script>
<hr style="position: relative; bottom: 125px;">
