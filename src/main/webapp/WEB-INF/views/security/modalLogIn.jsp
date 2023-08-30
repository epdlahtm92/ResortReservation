<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div class="modal" id="login">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--  modal header -->
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
				</div>

				<!-- modal body -->
				<form action="${ pageContext.request.contextPath }/login"
					method="POST" class="was-validated">
					<div class="modal-body">
						<div class="form-group">
							<label for="username">아이디 </label> <input type="text"
								class="form-control" id="username" name="username"
								placeholder="아이디를 입력하세요" required>
							<div class="valid-feedback"></div>
							<div class="invalid-feedback"></div>
						</div>
						<div class="form-group">
							<label for="비밀번호">비밀번호 </label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="비밀번호를 입력하세요" required> <input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}" />
							<div class="valid-feedback"></div>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<!-- modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
						<a href="" class="btn btn-secondary">회원가입</a>
						<button type="submit" class="btn btn-primary">로그인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>