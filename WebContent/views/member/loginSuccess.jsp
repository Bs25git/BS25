<%@ page import="member.model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%	
	// 자바코드 사용시 <% % > 스크립틀릿 사용
	Member member = (Member) session.getAttribute("member");


%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="0.5 url=/views/reservation/reservationDetail.jsp">
<title>로그인 성공</title>
</head>
<body>

	<%-- 값을 출력할땐 <%= %>요소 사용 --%>
	
	<!-- 자바코드를 사용하지않고 EL을 이용하여 데이터를 출력
	ㄴ session에 저장된 데이터를 가져오기대문에 sessionScope
	sessionScope.member라고 작성함. 가져온 멤버 객체는 Member 클래스를 통해서 만들어진 것이므로
	.(점) Member 클래스의 멤버변수를 적어야함 -->
	
	
</body>
</html>