<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="bookInfo" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">책 표지와 작가 등 기본 정보가 들어가는 부분</div>
		</div>
		만약 책의 순위가 카테고리별 top 100안에 들어가지 못했을 경우 sec1은 hidden영역임.
		<div class="row" id="sec1">
			<div class="col-xs-6" id="wordcloud">리뷰에서 많이 나오는 단어를 wordcloud로
				표현하는 부분</div>
			<div class="col-xs-6" id="estimate">인지도, 구성 등 카테고리별 긍정지수와 부정지수를
				막대그래프로 나타내는 부분</div>
		</div>
	</div>
</body>
</html>