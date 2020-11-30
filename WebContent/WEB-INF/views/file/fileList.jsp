<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My FilsList</title>
</head>
<body>
	<table border="1">
	<tr>
		<th>파일이름</th><th>파일사이즈</th>
		<th>업로더</th>
		<th>업로드 시간 </th><th>다운로드</th><th>삭제</th>
	</tr>
	<c:forEach items="${fileList }" var="fileOne">
	<tr>
		<td>${fileOne. fileName}</td>
		<td>${fileOne. fileSize }</td>
		<td>${fileOne. fileUser }</td>
		<td>${fileOne. uploadTime }</td>
		<td>
			<form action="/file/down" method="post">
			<input type="hidden" name="filePath" value="${fileOne.filePath }">
			<input type="hidden" name="fileUser" value="${fileOne.fileUser }">
			<input type="submit" value="다운로드">
			
			</form>
		</td>
		<td>
			<form action="/file/remove" method="post">
				<input type="hidden" name="filePath" value="${fileOne.filePath }">
				<input type="hidden" name="fileUser" value="${fileOne.fileUser }">
				<input type="submit"  value="삭제">
			
			
			</form>
		
		
		
		
		</td>
		
	
	</tr>
	
	</c:forEach>
</table>	
	
</body>
</html>