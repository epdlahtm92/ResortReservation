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
		<form:form modelAttribute="newNotification" class="form-horizontal" method="post">
			<fieldset>
				<legend>${ newNotificationTitle}</legend>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">제목</label>
					<div class="col -sm-3">
						<form:input path="notificationTitle" class="form-control" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">내용</label>
					<div class="col -sm-3">
						<form:input path="notificationContent" class="form-control" />
					</div>
				</div>
				<div class="float-right">
					<div class="col -sm-offset-2 col -sm-10" style="padding-right:0px;">
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