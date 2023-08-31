<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리조트 홈페이지</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>

	<div class="jumbotron" style="padding: 0px;">
		<img style="width: 100%"
			src="${ pageContext.request.contextPath }/resources/imageFiles/resort.jpg"
			alt="">
	</div>
	<div class="container" style="text-align: center">
		<h3>Welcome to KOPO Resort!</h3>
		<h5>${ connectionLog }</h5>
		<h6>
			<c:out value="gitHub : https://github.com/epdlahtm92" />
		</h6>
	</div>

		<%@ include file="../inc/footer.jsp"%>

</body>
</html>