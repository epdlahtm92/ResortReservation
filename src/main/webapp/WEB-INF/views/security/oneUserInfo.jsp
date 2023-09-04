<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 조회</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>
	<div class="container" style="margin-top: 25px;">
		<div class="row">

			<div class="container" style="text-align: center;">
				<h6>회원 정보</h6>
				<h3>
					회원 아이디 :
					<c:out value="${ userInfo.username }" />
				</h3>
				<p>
					<b>회원 이름 : </b>
					<c:out value="${ userInfo.realName }" />
				</p>
				<c:if test="${ isAdmin }">
					<p>
						<b>회원 권한 : </b>
						<c:choose>
							<c:when test="${ fn:contains(userInfo.authority, 'ADMIN') }">
								<c:out value="관리자" />
							</c:when>
							<c:when test="${ fn:contains(userInfo.authority, 'MANAGER') }">
								<c:out value="부관리자" />
							</c:when>
							<c:when test="${ fn:contains(userInfo.authority, 'MEMBER') }">
								<c:out value="일반 회원" />
							</c:when>
						</c:choose>
					</p>
				</c:if>
				<p>
					<b>이 메일 : </b>
					<c:out value="${ userInfo.email }${ userInfo.emailDomain }" />
				</p>
				<p>
					<b>가입 일자 : </b>
					<c:out value="${ userInfo.registrationDate }" />
				</p>
				<p>
					<b>핸드폰 번호 : </b>
					<c:out value="${ userInfo.phoneNumber }" />
				</p>
			</div>

			<c:if test="${ isAdmin or userInfo.username eq loginUser}">
				<div class="container" style="margin-top: 50px;">
					<hr />
					<form method="post"
						action="${ pageContext.request.contextPath }/member/deleteOneUser">
						<div class="float-right">
							<c:if test="${ isAdmin }">
								<a href="${ pageContext.request.contextPath }/admin/allUserInfo"
									class="btn btn-secondary">목록</a>
							</c:if>
							<a
								href="${ pageContext.request.contextPath }/member/updateOneUser?username=${ userInfo.username }"
								class="btn btn-warning">회원 정보 수정</a> <input type="hidden"
								name="isAdmin" value="${ isAdmin }" /> <input type="hidden"
								name="username" value="${ userInfo.username }" /> <input
								type="submit" class="btn btn-danger" value="탈퇴" /> <input
								name="${_csrf.parameterName }" type="hidden"
								value="${_csrf.token }" />
						</div>
					</form>
				</div>
			</c:if>

		</div>
	</div>

	<%@ include file="../inc/footer.jsp"%>
</body>
</html>