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
	<%@ include file="../inc/header.jsp"%>
	<div class="container" style="margin-top: 50px;">
		<div class="row" style="margin-bottom:50px;">
			<div class="container" style="text-align: center;">
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
			</div>
			<c:if test="${ not empty reviewById.reviewImagePath }">
				<div class="container">
					<img 
						style="margin-bottom: 50px; margin: auto; display: block; width: 75%;"
						src="${ pageContext.request.contextPath }/resources/imageFiles/${ reviewById.reviewImagePath }"
						alt="사진 없음" />
				</div>
			</c:if>
		</div>
		<div class="container">
			<div class="float-right" style="margin-bottom:25px;">
				<a href="${ pageContext.request.contextPath }/reviewList" class="btn btn-secondary"></a>
				<a
					href="${ pageContext.request.contextPath }/updateOneReview?reviewId=${ reviewById.reviewId}"
					class="btn btn-warning">수정하기</a> <a
					href="${ pageContext.request.contextPath }/deleteOneReview?reviewId=${ reviewById.reviewId }"
					class="btn btn-danger">지우기</a>
			</div>
		</div>
		<%@ include file="../inc/reply.jsp"%>
		<%@ include file="../inc/footer.jsp"%>
	</div>
</body>
</html>