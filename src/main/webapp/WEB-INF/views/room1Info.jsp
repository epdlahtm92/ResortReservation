<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 정보</title>
</head>
<body>
	<%@ include file="./inc/header.jsp" %>
	
	<div class="container" style="margin-bottom:150px;">
		<div class="row">
			<div class="col -md-4" style="text-align:center;">
				<h3>일반 룸</h3>
				<p>일반 룸 설명
				<p>일반 룸 설명
				<p>일반 룸 설명
				<p>일반 룸 설명
				<p>일반 룸 설명
			</div>
			<div class="col -md-8">
				<img style="position: absolute; top: 0; left: 0; width: 100%;"
					 src="${ pageContext.request.contextPath }/resources/imageFiles/room1.jpg"
					alt="사진 없음" />
			</div>
		</div>
	</div>
	
	<%@ include file="./inc/footer.jsp" %>
</body>
</html>