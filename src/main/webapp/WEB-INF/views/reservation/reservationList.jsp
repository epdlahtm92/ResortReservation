<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 현황</title>
</head>
<body>
	<%@ include file="../inc/header.jsp" %>
	
	<div class="container" style="text-align:center; margin-top:25px;">
		<h3 style="margin-bottom:25px;">예약 현황</h3>
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">예약 일자</th>
					    <th scope="col">VIP 객실</th>
					    <th scope="col">고급 객실</th>
					    <th scope="col">일반 객실</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${ roomStatusList }" var="roomStatus">
					<tr>
						<td><c:out value="${ roomStatus.reservationDate }"/></td>
						<c:choose>
							<c:when test="${ roomStatus.room0Status ne '0' }">
								<td>
								<c:choose>
									<c:when test="${ isAdmin }">
										<a href="${pageContext.request.contextPath }/reservation?reservationRoom=0&reservationDate=${ roomStatus.reservationDate }">
											<c:out value="${ roomStatus.room0Status }"/>
										</a>
									</c:when>
									<c:otherwise>
										<c:out value="${ roomStatus.room0Status }"/>
									</c:otherwise>
								</c:choose>
								</td>
							</c:when>
							<c:otherwise>
								<td><a href="${pageContext.request.contextPath }/newReservation?reservationDate=${ roomStatus.reservationDate }&reservationRoom=0"><c:out value="예약 가능" /></a></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${ roomStatus.room1Status ne '0' }">
								<td>
									<c:choose>
										<c:when test="${ isAdmin }">
											<a href="${pageContext.request.contextPath }/reservation?reservationRoom=1&reservationDate=${ roomStatus.reservationDate }">
												<c:out value="${ roomStatus.room1Status }"/>
											</a>
										</c:when>
										<c:otherwise>
											<c:out value="${ roomStatus.room1Status }"/>
										</c:otherwise>
									</c:choose>
								</td>
							</c:when>
							<c:otherwise>
								<td><a href="${pageContext.request.contextPath }/newReservation?reservationDate=${ roomStatus.reservationDate }&reservationRoom=1"><c:out value="예약 가능" /></a></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${ roomStatus.room2Status ne '0' }">
								<td>
									<c:choose>
										<c:when test="${ isAdmin }">
											<a href="${pageContext.request.contextPath }/reservation?reservationRoom=2&reservationDate=${ roomStatus.reservationDate }">
												<c:out value="${ roomStatus.room2Status }"/>
											</a>
										</c:when>
										<c:otherwise>
											<c:out value="${ roomStatus.room2Status }"/>
										</c:otherwise>
									</c:choose>
								</td>
							</c:when>
							<c:otherwise>
								<td><a href="${pageContext.request.contextPath }/newReservation?reservationDate=${ roomStatus.reservationDate }&reservationRoom=2"><c:out value="예약 가능" /></a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach> 
				</tbody>
			</table>
	</div>
	
	<%@ include file="../inc/footer.jsp" %>
</body>
</html>