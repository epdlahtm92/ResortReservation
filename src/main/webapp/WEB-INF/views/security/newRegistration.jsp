<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script>
	function oninputPhone(target) {
	    target.value = target.value
	        .replace(/[^0-9]/g, '')
	        .replace(/^(\d{3})(\d{4})(\d{4})$/, "$1-$2-$3");
	}
	function passwordConfirm(target) {
		var password = document.getElementById("password")
		if(target.value != password) {
			target.title = "패스워드가 일치하지 않습니다.";
		}
	}
</script>
<script
	src="${pageContext.request.contextPath }/resources/javaScriptFiles/trimSpace.js"></script>
<meta charset="UTF-8">
<title>회원 가입 하기</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>
	<div class="row">
		<div class="container">
			<form:form modelAttribute="newRegistration" class="form-horizontal"
				method="POST">
				<fieldset>
					<legend style="text-align:center;">회원 가입</legend>
					<div class="form-group-row">
						<label class="col-sm-2 control-label">아이디</label>
						<div class="col -sm-3">
							<form:input path="username" class="form-control" id="password" oninput="trimSpace(this)" type="text" pattern=".{8,14}" title="8~14 사이로 입력해주세요" maxlength="14" required="true" />
						</div>
						<div>
						</div>
					</div>
					<div class="form-group-row">
						<label class="col-sm-2 control-label">비밀번호</label>
						<div class="col -sm-3">
							<form:input path="password" id="password" class="form-control" oninput="trimSpace(this);" type="password" pattern=".{8,12}" title="8~12 사이로 입력해주세요" maxlength="12" required="true" />
						</div>
					</div>
					<div class="form-group-row">
						<label class="col-sm-2 control-label">비밀번호 확인</label>
						<div class="col -sm-3">
							<form:input path="" class="form-control"  oninput="trimSpace(this); passwordConfirm(this);" type="password" pattern=".{8,12}" title="8~12 사이로 입력해주세요" maxlength="12" required="true" />
						</div>
					</div>
					<div class="form-group-row">
						<label class="col-sm-2 control-label">핸드폰번호</label>
						<div class="col -sm-3">
							<form:input path="phoneNumber" type="text" class="form-control" oninput="oninputPhone(this)" pattern=".{11,13}" maxlength="12" required="true" />
						</div>
				</div>
					<div class="form-group-row">
						<label class="col-sm-2 control-label">이메일</label>
						<div class="col -sm-3">
							<div class="row mx-md-n5">
								<div class="col px-md-5">
									<form:input path="email" class="form-control" oninput="trimSpace(this)" type="text" required="true" />
								</div>
								<span style="font-size:1.5em; font-weight:bold; color:gray;">@</span>
								<div class="col px-md-5">
									<form:select path="" class="custom-select">
										<form:option value="@kopo.ac.kr">@kopo.ac.kr</form:option>
										<form:option value="@google.com">@google.com</form:option>
										<form:option value="@naver.com">@naver.com</form:option>
										<form:option value="@hanmail.net">@hanmail.net</form:option>
									</form:select>
								</div>	
							</div>
						</div>
					</div>
					<div class="float-right" style="margin-top: 25px;">
						<div class="col -sm-offset-2 col -sm-10">
							<a href="${ pageContext.request.contextPath }" class="btn btn-danger">취소</a> 
							<input type="reset" class="btn btn-warning" value="다시쓰기" />
							<input type="submit" class="btn btn-primary" value="가입하기" />
						</div>
					</div>
				</fieldset>

			</form:form>
		</div>
	</div>
	<%@ include file="../inc/footer.jsp"%>
</body>
</html>