<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 페이지</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>

	<div class="row">
		<div class="container" style="margin-top: 25px; text-align: center;">
			<h3 style="margin-bottom: 25px;">회원 관리 페이지</h3>
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">유저 이름</th>
						<th scope="col">이메일</th>
						<th scope="col">권한</th>
						<th scope="col">가입 일자</th>
						<th scope="col">핸드폰 번호</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${ userList }" var="user">
					<tr>
						<td>#</td>
						<td><a href="${ pageContext.request.contextPath }/member/oneUserInfo?username=${ user.username }"><c:out value="${ user.username }" /></a>
						<td><c:out value="${ user.email }" />
						<td><c:out value="${ user.authority }" />
						<td><c:out value="${ user.registrationDate }" />
						<td><c:out value="${ user.phoneNumber }" />
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<%@ include file="../inc/footer.jsp"%>
</body>
</html>