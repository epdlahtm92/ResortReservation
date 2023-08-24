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
			<c:forEach items="${ reviewList }" var="review"> 
				<tbody>
					<tr>
						<td><a href="${ pageContext.request.contextPath }/review?reviewId=${ review.reviewId }"><c:out value="${ review.reviewId }"/></a></td>
						<td><a href="${ pageContext.request.contextPath }/review?reviewId=${ review.reviewId }"><c:out value="${ review.reviewTitle }"/></a></td>
						<td><c:out value="${ review.reviewUser }"/></td>
						<td><c:out value="${ review.reviewDate }"/></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<div class="float-right">
			<a href="${ pageContext.request.contextPath }/newReview" class="btn btn-primary">글 쓰기</a>
		</div>
		<%@ include file="./inc/footer.jsp" %>
	</div>
</body>
</html>