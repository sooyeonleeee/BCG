<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style>
.progress, .smallheader {
	margin-left: 60px;
	margin-right: 60px;
}
</style>

</head>
<body>

<!-- /webapp/resources/wordcloud/genrecode+a+isbn.html -->
		<!-- /webapp/resources/graph/genrecode+a+isbn.png -->



	<div class="container-fluid">
		<div class="page-header">
		<h1>책제목</h1>
		</div>
		<div class="row">
		<div id="smallheader"><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도서 정보</h2></div>
			<div class="col-xs-6"><img src="/bcg/resources/images/books.jpg" style="width:150px"></div>
			<div class="col-xs-6">
			작가: 이수연<br>
			개요: description<br>
			가격: 45000원<br>
			출판사: publisher<br>
			출판일: pubdate<br>
			</div>
		</div>
		<hr>
		
		<div class="row" id="result">
		<div id="smallheader"><h2>&nbsp; 분석 결과</h2></div>
		<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="70"
								aria-valuemin="0" aria-valuemax="100"
								style="width:70%">70%</div>
						</div>
			<div class="col-xs-6"><iframe src="https://www.w3schools.com" id="wordcloud" style="width:150px"></iframe></div>
			<div class="col-xs-6"><img src="/bcg/resources/images/books.jpg" id="graph" style="width:150px"></div>
		</div>
	</div>
	
	
	
</body>
</html>