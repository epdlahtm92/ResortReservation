<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용 후기</title>
</head>
<body>
	<%@ include file="./inc/header.jsp" %>
	<div class="container" style="text-align:center;">
		<h3>이용 후기</h3>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
				    <th scope="col">제목</th>
				    <th scope="col">게시자</th>
				    <th scope="col">일자</th>
				</tr>
			</thead>
	<%-- <c:forEach items="${ reservationList }" value="reservationList"> --%>
				<tbody>
					<tr>
						<td><c:out value="${ reviewId }"/></td>
						<td><c:out value="${ reviewTitle }"/></td>
						<td><c:out value="${ reviewUser }"/></td>
						<td><c:out value="${ reviewDate }"/></td>
					</tr>
				</tbody>
<%-- 		</c:forEach> --%>
		</table>
			
			<%@ include file="./inc/footer.jsp" %>
		</div>
</body>
</html>