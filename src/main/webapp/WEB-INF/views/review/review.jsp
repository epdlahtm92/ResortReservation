<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용 후기</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>

	<div class="container" style="margin-top: 25px;">
		<div class="row">
			<div class="container" style="text-align: center;">
				<h6>이용 후기</h6>
				<h3>
					<c:out value="제목 : ${ reviewById.reviewTitle }" />
				</h3>
				<p><hr />
					<b>작성자 : </b>
					<c:out value="${reviewById.reviewUser }" />
				<p>
					<b>날짜 : </b>
					<c:out value="${ reviewById.reviewDate }" />
				<p>
					<b>내용 : </b> <br />
					<c:out value="${ reviewById.reviewContent }" />
				<p>
			</div>
			<div class="row" style="margin-top:25px;">
				<div class="container">
					<c:if test="${ not empty reviewById.reviewImagePath }">
						<img
							style="margin-bottom: 50px; margin: auto; display: block; width: 75%;"
							src="/home/kopo17/upload/${ reviewById.reviewImagePath }"
							alt="사진 없음" />
					</c:if>
				</div>
			</div>
		</div>
		<div>
			<div class="container" style="margin-bottom: 25px;">
				<div class="float-right" style="margin-bottom: 25px;">
					<a href="${ pageContext.request.contextPath }/reviewList"
						class="btn btn-secondary">목록</a> <a
						href="${ pageContext.request.contextPath }/updateOneReview?reviewId=${ reviewById.reviewId}"
						class="btn btn-warning">수정하기</a> <a
						href="${ pageContext.request.contextPath }/deleteOneReview?reviewId=${ reviewById.reviewId }"
						class="btn btn-danger">지우기</a>
				</div>
			</div>
		</div>
		
		<%@ include file="../inc/reply.jsp"%>
	</div>

	<%@ include file="../inc/footer.jsp"%>
</body>
</html>