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
		<div class="row">
			<div class="container" style="text-align: center;">
				<h3>
					<c:out value="${ notificationById.notificationTitle }" />
				</h3>
				<p>
					<b>작성자 : </b>
					<c:out value="관리자" />
					<br /> <b>날짜 : </b>
					<c:out value="${ notificationById.notificationDate }" />
				<p>
					<b>내용 : </b> <br />
				<h5>
					<c:out value="${ notificationById.notificationContent }" />
				</h5>
			</div>
			<c:if test="${ not empty notificationById.notificationImagePath }">
				<div class="container">
					<img style="margin-bottom: 50px; margin:auto; display:block; width: 75%;"
						src="${ pageContext.request.contextPath }/resources/imageFiles/${ notificationById.notificationImagePath }"
						alt="사진 없음" />
				</div>
			</c:if>
		</div>
		<div class="container" style="margin-top:50px;">
			<div class="float-right">
				<a
					href="${ pageContext.request.contextPath }/updateOneNotification?notificationId=${ notificationById.notificationId }"
					class="btn btn-warning">수정하기</a> <a
					href="${ pageContext.request.contextPath }/deleteOneNotification?notificationId=${ notificationById.notificationId }"
					class="btn btn-danger">지우기</a>
			</div>
		</div>

		<%@ include file="../inc/footer.jsp"%>
	</div>
</body>
</html>