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

	<div class="container" style="text-align: center;">
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
						<td><a
							href="${pageContext.request.contextPath }/notification?notificationId=${ notification.notificationId }"><c:out
									value="${ notification.notificationId }" /></a></td>
						<td><a
							href="${pageContext.request.contextPath }/notification?notificationId=${ notification.notificationId }"><c:out
									value="${ notification.notificationTitle }" /></a></td>
						<td><c:out value="관리자" /></td>
						<td><c:out value="${ notification.notificationDate }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example" style="margin-top: 25px;">
			<form class="form-inline justify-content-center"
				style="margin-bottom: 25px;">
				<select class="custom-select">
					<option selected>검색</option>
					<option value="1" selected>제목</option>
					<option value="2">내용</option>
					<option value="3">제목+내용</option>
				</select> <input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
			<ul class="pagination justify-content-center">
				<li class="page-item disabled"><a class="page-link">&laquo;</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
			</ul>
		</nav>
		<div class="float-right">
			<a class="btn btn-primary"
				href="${ pageContext.request.contextPath }/newNotification">글 쓰기</a>
		</div>
		<%@ include file="../inc/footer.jsp"%>
	</div>
</body>
</html>