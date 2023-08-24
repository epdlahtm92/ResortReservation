<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
</head>
<body>
	<%@ include file="./inc/header.jsp" %>

	<div class="container" style="text-align:center;">
		<h3>공지 사항</h3>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
				    <th scope="col">제목</th>
				    <th scope="col">게시자</th>
				    <th scope="col">일자 및 시간</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ notificationList }" var="notification">
					<tr>
						<td><a href="${pageContext.request.contextPath }/notification?notificationId=${ notification.notificationId }"><c:out value="${ notification.notificationId }" /></a></td>
						<td><a href="${pageContext.request.contextPath }/notification?notificationId=${ notification.notificationId }"><c:out value="${ notification.notificationTitle }" /></a></td>
						<td><c:out value="관리자" /></td>
						<td><c:out value="${ notification.notificationDate }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="float-right">
			<a class="btn btn-primary" href="${ pageContext.request.contextPath }/newNotification" >글 쓰기</a>
		</div>
		<%@ include file="./inc/footer.jsp" %>
	</div>
</body>
</html>