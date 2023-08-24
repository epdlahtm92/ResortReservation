<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="${ pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
	<%@ include file="onMouseOver.jsp" %>
<title>Header</title>
</head>
<body>
<nav class="navbar navbar-light" style="background-color:#e3f2fd; height:200%;">
	<div class="navbar-header">
		<a href="${ pageContext.request.contextPath }" style="margin-right:10px;"><img style="height:40px;;" src="${ pageContext.request.contextPath }/resources/imageFiles/resortLogo.PNG" alt=""></a>
		<a class="navbar-brand" onmouseover="menuShow(0);">KOPO 리조트</a>
		<a class="navbar-brand" onmouseover="menuShow(1);">찾아오기</a>
		<a class="navbar-brand" onmouseover="menuShow(2);">주변여행지</a>
		<a class="navbar-brand" onmouseover="menuShow(3);" >예약하기</a>
		<a class="navbar-brand" onmouseover="menuShow(4);">리조트 소식</a>
	</div>
</nav>
<nav class="navbar navbar-light" style="height:100%; padding-top:0px; padding-bottom:0px; margin-bottom:20px; background-color:#e3f2fd;">
	<div id="secondMenu0" class="navbar-header" style="display:none">
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/resortInfo">리조트 소개</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/room0Info">VIP 룸</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/room1Info">일반 룸</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/room2Info">합리적인 룸</a>
	</div>
	<div id="secondMenu1" class="navbar-header" style="display:none;">
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/mapInfo">지도</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/mapInfo">대중교통</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/mapInfo">자가용</a>
	</div>
	<div id="secondMenu2" class="navbar-header" style="display:none;">
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/sight0Info">AA 국립공원</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/sight1Info">BB 해수욕장</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/sight2Info">CC 온천</a>
	</div>
	<div id="secondMenu3" class="navbar-header" style="display:none;">
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/reservationList">예약 상황</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/adminPage">관리자 페이지</a>
	</div>
	<div id="secondMenu4" class="navbar-header" style="display:none;">
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/notification">공지 사항</a>
		<a class="navbar-brand" href="${ pageContext.request.contextPath }/reviewList">이용 후기</a>
	</div>
</nav>
</body>
</html>