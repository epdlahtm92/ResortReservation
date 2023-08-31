<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 완료</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>
	<div class="container" style="margin-top:25px;">
		<div class="row justify-content-md-center">
			<div class="col-md-auto">
				<h3>회원가입이 완료 되었습니다.</h3>
			</div>
		</div>
		<div class="row justify-content-md-center" style="margin-top:25px;">
			<a style="margin-right:10px;" class="btn btn-info" href="${ pageContext.request.contextPath }/">홈</a> <a
				class="btn btn-outline-success my-2 my-sm-0" href=""
				data-toggle="modal" data-target="#login">로그인</a>
		</div>
	</div>
	<%@ include file="../inc/footer.jsp"%>
</body>
</html>