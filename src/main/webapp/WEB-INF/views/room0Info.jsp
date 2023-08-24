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
	
	<div class="container">
		<div class="row">
			<div class="col -md-4" style="text-align:center;">
				<h3>VIP 룸</h3>
				<img style="width:100%;" src="${ pageContext.request.contextPath }/resources/imageFiles/room0.jpg" alt="VIP 룸 이미지">
			</div>
		</div>
	</div>
	
	<%@ include file="./inc/footer.jsp" %>
</body>
</html>