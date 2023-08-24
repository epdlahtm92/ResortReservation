<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
</head>
<body>
	<%@ include file="./inc/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col -md-4">
				<h3>
					<c:out value="${ reviewById.reviewTitle }" />
				</h3>
				<p>
					<b>작성자 : </b>
					<c:out value="${reviewById.reviewUser }" />
				<p>
					<b>날짜 : </b>
					<c:out value="${ reviewById.reviewDate }" />
				<p>
					<b>내용 : </b> <br />
					<c:out value="${ reviewById.reviewContent }" />
					<c:out value="${ notificationById.notificationContent }" />
				<div class="float-right">
					<a href="${ pageContext.request.contextPath }/newReview"
						class="btn btn-warning">수정하기</a> <a
						href="${ pageContext.request.contextPath }/newReview"
						class="btn btn-danger">지우기</a>
				</div>
			</div>
		</div>
		<%@ include file="./inc/footer.jsp"%>
	</div>
</body>
</html>