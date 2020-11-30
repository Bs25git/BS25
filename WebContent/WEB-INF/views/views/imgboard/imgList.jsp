<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My FileList</title>
<script src="/js/fullPopup_1.3.js"></script>

</head>
<style>
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

#contents {
   height: 800px;
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
   padding: 16px; 28 px;
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
   width: 800px;
   height: 300px;
   background-color: white;
   margin: 0 auto;
}

/*  navigator */
nav {
   font-family: "Roboto", serif;
   width: 1200px;
   display: flex;
   justify-content: center;
   background-color: black;
   position: relative;
   margin: auto;
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
   padding: 10px 28px;
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

/* freeboard */
ul, li {
   line-height: 2em;
   font-family: "맑은 고딕";
   list-style: none;
   text-align: center;
   padding: 0;
   margin: 0;
}

#mainWrapper {
   width: 800px;
   margin: 0 auto; /*가운데 정렬*/
}

#mainWrapper>ul>li:first-child {
   text-align: center;
   font-size: 14pt;
   height: 40px;
   vertical-align: middle;
   line-height: 30px;
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
   width: 5%;
} /*No 열 크기*/
#ulTable>li>ul>li:first-child+li {
   width: 70%;
} /*제목 열 크기*/
#ulTable>li>ul>li:first-child+li+li {
   width: 8%;
} /*작성일 열 크기*/
#ulTable>li>ul>li:first-child+li+li+li {
   width: 10%;
} /*작성자 열 크기*/
#ulTable>li>ul>li:first-child+li+li+li+li {
   width: 7%;
} /*조회수 열 크기*/
#divPaging {
   clear: both;
   margin: 0 auto;
   width: 220px;
   height: 50px;
}

#divPaging>div {
   float: left;
   width: 30px;
   margin: 0 auto;
   text-align: center;
}

#liSearchOption {
   clear: both;
}

#liSearchOption>div {
   margin: 0 auto;
   margin-top: 30px;
   width: auto;
   height: 100px;
}

#txtKeyWord {
   border: 0.1px solid #272727;
   border-bottom-right-radius: 1px;
   border-bottom-left-radius: 1px;
   border-top-right-radius: 1px;
   border-top-left-radius: 1px;
}

.searchbox {
   width: 900px;
   height: 100px;
   left: 795px;
   position: relative;
}

#searchOption {
   width: 70px;
   height: 95px;
   float: left;
}

#searchWord {
   width: 230px;
   height: 95px;
   float: left;
}

#pageNavi {
   width: 100%;
   position: relative;
   float: left;
}
#layer_popup {display:none; border:5px solid #cccccc;margin:0;padding:5px;background-color:#ffffff;z-index:2000;}
#layer_popup .b-close {position:absolute;top:10px;right:15px;color:#f37a20;font-weight:bold;cursor:hand;}
#layer_popup .popupContent {margin:0;padding:0;text-align:center;border:0;width:800px;height:500px;}
#layer_popup .popupContent iframe {border:0;padding:0px;margin:0;z-index:10;}
</style>
<body>
 <h1>사진후기</h1>
<!--    <ul id="ulTable">
      <li>
         <ul>
            <li>글제목</li>
            <li>사진</li>
            <li>작성자</li>
            <li>작성일</li>
            
         </ul>
      </li> -->
      <!-- 게시물이 출력될 영역 -->
 <%--      <li><c:forEach items="${iList }" var="imgBoard"
            varStatus="index">
            <ul>
               <li>${imgBoard.fileName }</li>
               <li>${imgBoard.Img }
               <li>${imgBoard.userId }</li>
               <li>${imgBoard.regDate }</li>
               <input type="hidden" name="fileSize" value="${imgBoard.fileSize }">
               
            </ul>
         </c:forEach>
      </li> --%>
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
			    	<div id="item_img">
 					<img src="${imgBoard.filePath }">
			    	</div>
			    	<div>
			    	${imgBoard.content }
			    	</div>
			    	<hr>
			    	<div id="item_price">
			    	${imgBoard.userId }
			    	</div>
			    	<div id="item_discount">
			    	${imgBoard.regDate }
			    	</div>
		    	</div>
		    </td>
		    <c:if test="${i%j == j-1 }">
		    </c:if> 
		    <c:set var="i" value="${i+1 }" />
		    </c:forEach>
		    </table>
   <br>
   <br>
   <div id="pageNavi">${pageNavi }</div>
   <br>
   <br>
   <br>
   	<form action="/img/uploadFile" method="post" enctype="multipart/form-data">
		<input type="file" name="img">
		<input type="text" name="content">
		<input type="submit" value="업로드" >
		<input type="reset" value="취소">	
	</form>
	
	
</body>
</html>