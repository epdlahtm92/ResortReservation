<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리조트 홈페이지</title>
</head>
<body>
	<%@ include file="./inc/header.jsp" %>
	
	<div class="jumbotron" style="padding:0px;">
			<img style="width: 100%" src="${ pageContext.request.contextPath }/resources/imageFiles/coastal_town-wallpaper-1920x1080.jpg" alt="">
	</div>
	<div class="container" style="text-align:center">
		<h3>Welcome!</h3>
	</div>
	
	<%@ include file="./inc/footer.jsp" %>
</body>
</html>