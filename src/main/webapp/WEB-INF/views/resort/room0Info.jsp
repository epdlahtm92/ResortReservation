<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 정보</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>

	<div class="jumbotron" style="padding: 0px;">
		<img style="width: 100%;"
			src="${ pageContext.request.contextPath }/resources/imageFiles/room0.jpg"
			alt="사진 없음" />
	</div>
	<div class="container"
		style="margin-top: 50px; margin-bottom: 150px; text-align: center;">
		<h3>VIP 객실 안내</h3>
		<p>vip 룸 설명
		<p>vip 룸 설명
		<p>vip 룸 설명
		<p>vip 룸 설명
		<p>vip 룸 설명
		<div class="container">
			<a href="${ pageContext.request.contextPath }/reservationList"
				class="btn btn-primary">예약 현황</a>
		</div>
	</div>

	<%@ include file="../inc/footer.jsp"%>
</body>
</html>