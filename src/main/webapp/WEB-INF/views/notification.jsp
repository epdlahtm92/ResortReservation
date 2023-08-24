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
	<h3>공지 사항</h3>
	<div class="container">
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
				    <th scope="col">제목</th>
				    <th scope="col">게시자</th>
				    <th scope="col">일자</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${ notificationId }" /></td>
					<td><c:out value="${ notificationTitle }" /></td>
					<td><c:out value="${ notificationUser }" /></td>
					<td><c:out value="${ notificationDate }" /></td>
				</tr>
			</tbody>
		</table>
		<%@ include file="./inc/footer.jsp" %>
	</div>
</body>
</html>