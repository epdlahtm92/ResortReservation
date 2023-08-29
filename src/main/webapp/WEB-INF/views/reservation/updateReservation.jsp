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
	        .replace(/(^02.{0}|^01.{1}|[0-9]{3,4})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
	}
	
	function trimSpace(target) {
		target.value = target.value.trim();
	}
	
	function trimSpaceStart(target) {
		target.value = target.value.trimStart();
	}
</script>
<meta charset="UTF-8">
<title>예약 하기</title>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>

	<div class="container">
		<form:form modelAttribute="updateReservation" class="form-horizontal"
			method="post">
			<fieldset>
			<legend style="text-align:center;">${ newReservationTitle }</legend>
				<div class="form-group-row" style="text-align:center;">
					<c:choose>
						<c:when test="${ newReservation.reservationRoom eq 0}">
							<div class="jumbotron" style="padding: 0px;">
								<img style="width: 100%;"
									src="${ pageContext.request.contextPath }/resources/imageFiles/room0.jpg"
									alt="사진 없음" />
							</div>
							<h5>예약 객실 : VIP 객실</h5>
						</c:when>
						<c:when test="${ newReservation.reservationRoom eq 1}">
							<div class="jumbotron" style="padding: 0px;">
									<img style="width: 100%;"
										src="${ pageContext.request.contextPath }/resources/imageFiles/room1.jpg"
										alt="사진 없음" />
							</div>
							<h5>예약 객실 : 고급 객실</h5>
						</c:when>
						<c:when test="${ newReservation.reservationRoom eq 2}">
							<div class="jumbotron" style="padding: 0px;">
									<img style="width: 100%;"
										src="${ pageContext.request.contextPath }/resources/imageFiles/room2.jpg"
										alt="사진 없음" />
							</div>
							<h5>예약 객실 : 일반 객실</h5>
						</c:when>
					</c:choose>
					<h5>예약 일자 : ${ newReservation.reservationDate }</h5>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">이름</label>
					<div class="col -sm-3">
						<form:input path="name" class="form-control" oninput="trimSpace(this)" required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">주소</label>
					<div class="col -sm-3">
						<form:input path="address" class="form-control" oninput="trimSpaceStart(this)" required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">전화번호</label>
					<div class="col -sm-3">
						<form:input path="phoneNumber" class="form-control" oninput="oninputPhone(this)" maxlength="14" required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">입금자명</label>
					<div class="col -sm-3">
						<form:input path="payer" class="form-control" oninput="trimSpace(this)" required="true" />
					</div>
				</div>
				<div class="form-group-row">
					<label class="col-sm-2 control-label">남기실 말</label>
					<div class="col -sm-3">
						<form:textarea path="userComment" class="form-control" oninput="trimSpaceStart(this)" required="true"/>
					</div>
				</div>
				<div class="float-right" style="margin-top:25px;">
					<div class="col -sm-offset-2 col -sm-10">
						<a href="${pageContext.request.contextPath }/reservationList" class="btn btn-danger" >예약 현황으로</a> 
						<input type="reset" class="btn btn-warning" value="다시쓰기" /> 
						<input type="submit" class="btn btn-primary" value="확인" />
					</div>
				</div>
			</fieldset>
		</form:form>
		<%@ include file="../inc/footer.jsp"%>
	</div>
</body>
</html>