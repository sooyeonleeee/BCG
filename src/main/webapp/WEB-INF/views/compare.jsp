<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="bcg.common.api.APIExamSearch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="compare" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.col-xs-12 {
	margin-top: 30px;
}

#showmore{
	width: 300px;
	height: 150px;
}

#title {
	margin: 0px;
	margin-left: 30px;
	margin-top: 30px;
	margin-bottom: 15px;
}

.container-fluid {
	margin-left: 150px;
	margin-right: 150px;
}

.totalscore {
	text-decoration: none;
	text-align: right;
}
</style>
<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();   
});
</script>
</head>
<body>

	<div class="fluid-container">
		<div class="row">
			<div class="col-xs-12" id="title">
				<h1>도서 비교</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-9"></div>
			<div class="col-xs-3">
			<h4><a class="totalscore" href="#" title="긍정지수 산정방법" data-toggle="popover" data-placement="top"
				data-content="긍정지수 어떻게 산정했는지">긍정지수?</a></h4>
			</div>
		</div>
	</div>

	<div class="container">
		<form method="GET" action="/bcg/search">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search"
					name="title">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
	</div>


	<div class="container-fluid">
		<h3 class="margin">${searchResultComment }</h3>
		<br>
		<div class="row">
			
			<c:forEach items="${result }" var="book">
				<div class="media">
					<div class="media-left">
					
							<button type="button" class="btn btn-info btn-lg" onclick="location.href='/bcg/bookinfo?bookCode=${book.bookCode}'">
							<img src="${book.imgurl }" class="media-object"
								style="width: 150px">
						</button>
					
					</div>

					<div class="media-body">
						<p align="justify">
						<h4 class="media-heading">${book.title }</h4> 
						<br>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="70"
								aria-valuemin="0" aria-valuemax="100"
								style="width:${book.totalScore}%">${book.totalScore}%</div>
						</div>
					</div>		
				</div>
				<hr>
			</c:forEach>
		</div>
	</div>
	
	<!--  더보기 버튼  -->
	<div class="container">
		<form method="GET" action="/bcg/showMore">
				<button class="btn btn-default" type="submit" value="더보기" id="showmore">더보기
				</button>
		</form>
	</div>
	
</body>
</html>
