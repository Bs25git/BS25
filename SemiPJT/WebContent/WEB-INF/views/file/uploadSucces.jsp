<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드 성공</title>
</head>
<body>
<h1>업로드정보</h1>
<h3>파일이름 : ${fileData.fileName}</h3>
<h3>파일경로 : ${fileData.filePath}</h3>
<h3>파일크기 : ${fileData.fileSize}</h3>
<h3>업로드 아이디 : ${fileData.fileUser}</h3>
<h3>업로드 시간 : ${fileData.uploadTime}</h3>
<a href ="/index.jsp">메인페이지로 이동</a>
	
</body>
</html>