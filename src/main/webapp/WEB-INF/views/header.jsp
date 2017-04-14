<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="recommend" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">

			<div class="navbar-header">
				<p align="justify">
					<a class="navbar-brand" href="/bcg/main" id="logo">BookChiGi</a>
				</p>
			</div>

			<p align="justify">
			<ul class="nav nav-pills nav-justified">
				<li id="all" class="active"><a
					href="javascript:loadPageNamedAll();" id="menu"> 전체 추천</a></li>
				<li id="category"><a href="javascript:loadPageNamedCategory();"
					id="menu">카테고리별 추천</a></li>
			</ul>
			</p>


		</div>
	</nav>

</body>
</html>