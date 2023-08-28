<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script>
function trimSpaceStart(target) {
	target.value = target.value.trimStart();
}
</script>
<meta charset="UTF-8">
<title>댓글 작성</title>
</head>
<body>
	<div class="container" align="center" style="margin-top: 20px;">
		<table class="table table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col">작성자</th>
					<th scope="col">내용</th>
					<th scope="col">작성 일시</th>
					<th scope="col">삭제하기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ replyList }" var="reply">
					<tr>
						<td><c:out value="${ reply.replyUser }" /></td>
						<td><c:out value="${ reply.replyContent }" /></td>
						<td><c:out value="${ reply.replyDate }" /></td>
						<td><a href="${ pageContext.request.contextPath }/deleteOneReviewReply?reviewId=${ reviewById.reviewId }&replyId=${ reply.replyId }" class="badge badge-danger">X</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form:form modelAttribute="newReply" method="post">
		<div class="container">
			<form:hidden path="rootId" value="${ reviewById.reviewId }" />
			<form:hidden path="replyUser" value="kopo17" />
			<form:input type="text" class="form-control mb-2" path="replyContent"
				oninput="trimSpaceStart(this)" placeholder="댓글을 입력하세요" required="true" />
			<form:hidden path="replyCategory" value="review" />
			<div class="float-right">
				<input type="submit" class="btn btn-primary mb-2" value="쓰기" />
			</div>
		</div>
	</form:form>

</body>
</html>