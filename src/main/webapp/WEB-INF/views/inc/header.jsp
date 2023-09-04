<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/resources/css/bootstrap.bundle.min.js"></script>
<link
	href="${ pageContext.request.contextPath }/resources/css/bootstrap.min.css"
	rel="stylesheet">
<sec:authorize access="isAuthenticated()" var="isAuthenticated" />
<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../security/modalLogIn.jsp"%>
	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: #e3f2fd; text-align: center;">
		<a class="navbar-brand" href="${ pageContext.request.contextPath }"><img
			style=""
			src="${ pageContext.request.contextPath }/resources/imageFiles/resortLogo.PNG"
			alt="로고" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="${ pageContext.request.contextPath }">홈</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> 리조트 소개 </a>
					<div class="dropdown-menu">
						<a class="dropdown-item"
							href="${ pageContext.request.contextPath }/resortInfo">리조트 소개</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="${ pageContext.request.contextPath }/room0Info">VIP 객실</a>
						<a class="dropdown-item"
							href="${ pageContext.request.contextPath }/room1Info">고급 객실</a> <a
							class="dropdown-item"
							href="${ pageContext.request.contextPath }/room2Info">일반 객실</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="${ pageContext.request.contextPath }/mapInfo">오시는 길</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> 주변 여행지 </a>
					<div class="dropdown-menu">
						<a class="dropdown-item"
							href="${ pageContext.request.contextPath }/sight0Info">AA
							국립공원</a> <a class="dropdown-item"
							href="${ pageContext.request.contextPath }/sight1Info">BB
							해수욕장</a> <a class="dropdown-item"
							href="${ pageContext.request.contextPath }/sight2Info">CC 온천</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> 예약 하기 </a>
					<div class="dropdown-menu">
						<a class="dropdown-item"
							href="${ pageContext.request.contextPath }/reservationList">예약 하기</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="${ pageContext.request.contextPath }/adminPage">관리자 페이지</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> 리조트 소식 </a>
					<div class="dropdown-menu">
						<a class="dropdown-item"
							href="${ pageContext.request.contextPath }/notificationList">공지
							사항</a> <a class="dropdown-item"
							href="${ pageContext.request.contextPath }/reviewList">이용 후기</a>
					</div></li>
			</ul>
			<c:if test="${ logInError eq 'true' }">
				<script type="text/javascript">
					$('#login').modal('show')
				</script>
			</c:if>
			<c:choose>
				<c:when test="${ isAuthenticated and isAdmin eq false }">
					<span style="margin-right: 10px;">
						<sec:authentication property="principal.username" var="loginUser" />환영합니다. ${ loginUser } 님
					</span>
					<div class="dropdown" style="margin-right:10px;">
						<button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
							마이 페이지
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">나의 예약</a> <a
								class="dropdown-item" href="${ pageContext.request.contextPath }/member/oneUserInfo?username=${ loginUser }">나의 회원 정보</a> <a
								class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
					<form action="${ pageContext.request.contextPath }/logout"
						method="post">
						<input name="${_csrf.parameterName }" type="hidden"
							value="${_csrf.token }" />
						<button type="submit" class="btn btn-outline-success my-2 my-sm-0">로그아웃</button>
					</form>
				</c:when>
				<c:when test="${ isAdmin }">
					<span style="margin-right: 10px;">
						<sec:authentication property="principal.username" var="loginUser" />환영합니다. ${ loginUser } 님 
					</span>
					<div class="dropdown" style="margin-right:10px;">
						<button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
							관리자 페이지
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="${ pageContext.request.contextPath }/reservationList">예약 현황</a> 
							<a class="dropdown-item" href="${ pageContext.request.contextPath }/admin/allUserInfo">회원 관리</a> 
							<a class="dropdown-item" href="#">사이트 정보</a>
						</div>
					</div>
					<form action="${ pageContext.request.contextPath }/logout"
						method="post">
						<input name="${_csrf.parameterName }" type="hidden"
							value="${_csrf.token }" />
						<button type="submit" class="btn btn-outline-success my-2 my-sm-0">로그아웃</button>
					</form>
				</c:when>
				<c:otherwise>
					<a class="btn btn-outline-success my-2 my-sm-0" href=""
						data-toggle="modal" data-target="#login">로그인</a>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
</body>
</html>