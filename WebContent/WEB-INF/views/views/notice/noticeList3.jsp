<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div {
   box-sizing: border-box;
   font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
}

a {
   color: black;
   text-decoration: none;
   text-align: center;
}


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
</style>


<title>공지사항</title>
</head>
<body>
	<h1>공지사항 & QnA 게시판</h1>

<!-- 	<table border ="1">
	<tr><th>글번호</th><th>글제목</th>
	<th>글쓴이</th><th>작성일</th><th>조회수</th><tr> -->
	
	
	<!-- 여기에는 EL/JSTL를 이용해서 forEach으로 공지사랑 리스트 출력
		jsp에 데이터를 출력하기 위해서는 Servlet을 거쳐서 데이터를 가져와야함
	 -->
	 <%-- <c:forEach items="${nList }" var="notice" varStatus="index">
	 <tr>
	 	<td>${notice.noticeNo }</td>
<!-- 	 	하나의 게시글에 대한 내용을 검색하기 위해서 noticeNo를 서블릿으로 넘겨줌
		
 -->

 	
  <td><a href="/notice/select?noticeNo=${notice.noticeNo}&readcount=${notice.readcount}">${notice.subject }</a></td>
	 	<td>${notice.userId }</td>
	 	<td>${notice.regDate }</td>
	 	<td>${notice.readcount }</td>
	 	
	 	
	 
	 </tr>
	 
	 </c:forEach> --%>
	 <ul id="ulTable">
      <li>
         <ul>
            <li>글번호</li>
            <li>글제목</li>
            <li>작성자</li>
            <li>작성일</li>
            <li>조회수</li>
         </ul>
      </li>
	  <li><c:forEach items="${nList }" var="notice"
            varStatus="index">
            <script>
		function back(){
			alert("관리자 및 작성자만 볼 수 있습니다.");
			location.href="/notice/list";
		}
		
	</script>
	<body onclick = "return back();"></body>
	<c:if test="${sessionScope.member.userId ne 'munji' && content.userId ne sessionScope.member.userId }">
            <ul>
               <li>${notice.noticeNo }</li>
               <li>${notice.userId }</li>
               <li>${notice.regDate }</li>
               <li>${notice.readcount }</li>
            </ul>
            </c:if>
         </c:forEach>
         </li>
	
	 <tr>
	 <td colspan = "4" align="center">
	 	${pageNavi }
	 	<br><br><br>
	 	<div class="searchbox">
      <div id="searchOption">
         <select id='selSearchOption'>
            <option value='A'>작성자</option>
         </select>


      </div>
       <div id="searchWord">
         <form action="/notice/search" method="get">
            <input id='txtKeyWord' type="text" name="search"> <input
               type="submit" value="검색">
         </form>
      </div>
      <form action="/notice/writeform" method="get">
         <input type="submit" value="새글작성"
            style="position: relative; left: 20px;">
      </form>
   </div>
      
	 	

	
	 </tr>
	
	</table>
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>