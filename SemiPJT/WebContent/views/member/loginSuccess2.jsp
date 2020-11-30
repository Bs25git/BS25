<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="/img/logo.png">
<meta charset="UTF-8">
<title>To:geDog - 로그인 성공</title>
<meta http-equiv="refresh" content="2 url=/">

</head>

<style>
div {
	font-family: 맑은고딕;
}

body {
	font-size: 20px;
	text-shadow: 0px 1px 0px rgba(255, 255, 255, 1);
	color: #343434;
	text-decoration: none;
	font-weight: bold;
}

.container {
	position: relative;
	z-index: 0;
	background-color: #F9F8F7;
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
	overflow: hidden;
}

.pulse {
	z-index: -1;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	max-width: 20rem;
}

circle {
	fill: #707070;
	transform: scale(0);
	opacity: 0;
	transform-origin: 50% 50%;
	animation: pulse 2.5s cubic-bezier(.5, .5, 0, 1);
	}
   
@-webkit-keyframes pulse {
	25% {
		opacity: 0.4;
	}
	100% {
		transform: scale(1);
	}
	
}
</style>
</head>
<body>

	<div class="container">
		<div id="welcome">
		
			<span id="msg"><b>${sessionScope.member.name }님, 환영합니다!</b></span>
			<svg class="pulse" viewBox="0 0 1024 1024" version="1.1"
				xmlns="http://www.w3.org/2000/svg"
				xmlns:xlink="http://www.w3.org/1999/xlink">
        	<circle cx="512" cy="512" r="512"></circle>

	</svg>
		</div>

	</div>

</body>
</html>
</body>
</html>