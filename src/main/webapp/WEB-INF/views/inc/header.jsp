<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/css/bootstrap.bundle.min.js"></script>
<link href="${ pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color:#e3f2fd;">
  <a class="navbar-brand" href="${ pageContext.request.contextPath }"><img style="fit-height" src="${ pageContext.request.contextPath }/resources/imageFiles/resortLogo.PNG"  alt="로고" /></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>	
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="${ pageContext.request.contextPath }">홈</a>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          리조트 소개
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/resortInfo">리조트 소개</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/room0Info">VIP 객실</a>
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/room1Info">고급 객실</a>
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/room2Info">일반 객실</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${ pageContext.request.contextPath }/mapInfo">오시는 길</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
			주변 여행지
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/sight0Info">AA 국립공원</a>
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/sight1Info">BB 해수욕장</a>
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/sight2Info">CC 온천</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          예약 하기
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/reservationList">예약 상황</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/adminPage">관리자 페이지</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          리조트 소식
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/notificationList">공지 사항</a>
          <a class="dropdown-item" href="${ pageContext.request.contextPath }/reviewList">이용 후기</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <a class="btn btn-outline-success my-2 my-sm-0" href="#">로그인</a>
    </form>
  </div>
</nav>
</body>
</html>