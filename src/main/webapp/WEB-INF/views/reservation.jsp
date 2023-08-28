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
					<c:out value="예약 정보 보기" />
				</h3>
				<p>
					<b>예약자 : </b>
					<c:out value="${ reservation.name }" />
				<p>
					<b>예약 날짜 : </b>
					<c:out value="${ reservation.reservationDate }" />
				<p>
					<b>예약 객실 : </b>
					<c:choose>
						<c:when test="${reservation.reservationRoom eq 0 }">
							<c:out value="VIP 객실" />
						</c:when>
						<c:when test="${reservation.reservationRoom eq 1 }">
							<c:out value="고급 객실" />
						</c:when>
						<c:when test="${reservation.reservationRoom eq 1 }">
							<c:out value="일반 객실" />
						</c:when>
					</c:choose>
					
				<p>
					<b>남기실 말 : </b>
					<c:out value="${reservation.userComment }" />
				<div class="float-right">
					<a href="${ pageContext.request.contextPath }"
						class="btn btn-warning">예약 정보 수정</a>
					<a href="${ pageContext.request.contextPath }/deleteOneReservation?reservationId=${ reservation.reservationId }"
						class="btn btn-danger">예약 취소</a>
				</div>
			</div>
		</div>
	</div>


	<%@ include file="./inc/footer.jsp"%>
</body>
</html>