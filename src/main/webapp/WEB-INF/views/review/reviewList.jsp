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

	<div class="row">
		<div class="container" style="text-align: center; margin-top: 25px;">
			<h3 style="margin-bottom: 25px;">이용 후기</h3>
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
							<td><a
								href="${ pageContext.request.contextPath }/review?reviewId=${ review.reviewId }"><c:out
										value="${ review.reviewId }" /></a></td>
							<td><a
								href="${ pageContext.request.contextPath }/review?reviewId=${ review.reviewId }"><c:out
										value="${ review.reviewTitle }" /></a></td>
							<td><c:out value="${ review.reviewUser }" /></td>
							<td><c:out value="${ review.reviewDate }" /></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
			<hr />
			<div class="row">
				<div class="container">
					<div class="float-right">
						<a href="${ pageContext.request.contextPath }/newReview"
							class="btn btn-primary">글 쓰기</a>
					</div>
				</div>
			</div>
			<nav aria-label="Page navigation example" style="margin-top: 25px;">
				<form class="form-inline justify-content-center"
					style="margin-bottom: 25px;">
					<select class="custom-select" style="margin-right: 10px;">
						<option selected>검색</option>
						<option value="1" selected>제목</option>
						<option value="2">내용</option>
						<option value="3">제목+내용</option>
						<option value="4">게시자</option>
						<option value="5">댓글 내용</option>
						<option value="6">댓글 게시자</option>
					</select> <input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
				</form>
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/reivewList?currentPage=1">&laquo;</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/reivewList?currentPage=${ currentPage -10 }">&lt;</a></li>
					<c:forEach begin="${ currentTabStart }" end="${ currentTabEnd }"
						step="1" varStatus="stauts">
						<li class="page-item"><a class="page-link"
							href="${pageContext.request.contextPath}/reviewList?currentPage=${ stauts.index}">${ stauts.index }</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/reivewList?currentPage=${ currentPage +10 }">&gt;</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/reivewList?currentPage=${ totalPage }">&raquo;</a></li>
				</ul>
			</nav>
		</div>
	</div>

	<%@ include file="../inc/footer.jsp"%>
</body>
</html>