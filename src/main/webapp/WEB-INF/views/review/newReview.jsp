<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="${pageContext.request.contextPath }/resources/javaScriptFiles/trimSpace.js"></script>
<meta charset="UTF-8">
<title>이용후기 작성</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>
	<c:if test="${fileTypeAlert eq 'alert'}">
		<script>
			window.alert('이미지 파일만 업로드 하세요');
		</script>
	</c:if>
	<div class="container" style="margin-top:25px;">
		<form:form modelAttribute="newReview" class="form-horizontal"
			method="post" enctype="multipart/form-data">
			<fieldset>
				<legend style="text-align:center;">이용후기 작성하기</legend>
				<hr />
				<div class="form-group-row">
					<label class="col-sm-2 control-label">제목</label>
					<div class="col -sm-3">
						<form:input path="reviewTitle" class="form-control"
							oninput="trimSpaceStart(this)" required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">내용</label>
					<div class="col -sm-3">
						<form:textarea style="height:500px;" path="reviewContent"
							class="form-control" oninput="trimSpaceStart(this)"
							required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">게시자</label>
					<div class="col -sm-3">
						<form:input path="reviewUser" class="form-control"
							oninput="trimSpace(this)" required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">사진</label>
					<div class="col -sm-3">
						<form:input type="file" path="reviewImageFile"
							accept="image/gif, image/jpeg, image/png" />
					</div>
				</div>
				<hr />
				<div class="float-right" style="margin-top: 25px;">
					<div class="col -sm-offset-2 col -sm-10">
						<input type="reset" class="btn btn-warning" value="다시쓰기" /> <input
							type="submit" class="btn btn-primary" value="확인" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>

	<%@ include file="../inc/footer.jsp"%>
</body>
</html>