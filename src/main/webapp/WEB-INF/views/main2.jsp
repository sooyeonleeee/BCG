<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="main" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title> BookChiGi </title>
</head>
<style>
.col-xs-12 {
	padding-top: 70px;
	padding-bottom: 70px;
}

.col-xs-6 {
	padding-top: 0px;
	padding-bottom: 0px;
}
</style>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12" style="background-color: lavender;">
				<h1>Title</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6">
				<p align="center">
					<a href="/bcg/compare"><img src="<%=request.getContextPath() %>/resources/menuicon.png"
						id="compare" class="img-responsive margin" style="width:65%" /></a>
				</p>
			</div>
			<div class="col-xs-6" >
				<p align="center">
					<a href="/bcg/recommend"><img
						src="<%=request.getContextPath() %>/resources/menuicon.png" id="recommend" class="img-responsive margin" style="width:65%" /></a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>