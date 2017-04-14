<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="recommendByCategory"
	content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
}

table {
	height: 100px;
	width: 300px;
}
</style>

</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>카테고리별 추천</h1>
		</div>
		<div class="container-fluid">장르와 카테고리를 선택하세요.</div>
		<br>
		<button type="button" class="btn btn-primary" id="resetBtn" onclick="javascript:reset();">선택해제</button>
		<div class="btn-group btn-group-justified">
			<c:forEach items="${genreList }" var="genre">
				<div class="btn-group">
					<button type="button" class="btn btn-primary" id="genreBtn"
						value="${genre.genreCode }" onclick="javascript:clickGenre('${genre.genreCode }');">${genre.genreName }</button>
				</div>
			</c:forEach>
		</div>
		<div class="btn-group btn-group-justified">
			<c:forEach items="${classList }" var="category">
				<div class="btn-group">
					<button type="button" class="btn btn-primary" id="classBtn"
						value="${category.classCode }" onclick="javascript:clickClass('${category.classCode }');">${category.className }</button>
				</div>
			</c:forEach>
		</div>
		
		<div id="result">
		
		</div>


	</div>
	
	
		<div id="selectedGenre"></div>
		<div id="selectedClass"></div>
	
</body>
</html>