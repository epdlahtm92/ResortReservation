<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<body>
	<%@ include file="./inc/header.jsp" %>
	<div class="container">
		<form:form modelAttribute="newReview" class="form-horizontal" method="post">
			<fieldset>
				<legend>${ newNotificationTitle}</legend>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">제목</label>
					<div class="col -sm-3">
						<form:input path="reviewTitle" class="form-control" required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">내용</label>
					<div class="col -sm-3">
						<form:textarea style="height:500px;" path="reviewContent" class="form-control" required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">게시자</label>
					<div class="col -sm-3">
						<form:input path="reviewUser" class="form-control" required="true" />
					</div>
				</div>
				<div class="float-right" style="margin-top:25px;">
					<div class="col -sm-offset-2 col -sm-10">
						<input type="reset" class="btn btn-warning" value="다시쓰기" />
						<input type="submit" class="btn btn-primary" value="확인" /> 
					</div>
				</div>
			</fieldset>
		</form:form>
		<%@ include file="./inc/footer.jsp" %>
	</div>
</body>
</html>