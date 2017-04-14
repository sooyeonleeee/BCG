<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="main" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>BookChiGi</title>
<style>
html {
	background: url(resources/images/books.jpg) no-repeat center center
		fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

img {
	width: 300px;
	height: 300px;
}

.compare {
    position: absolute;
    top: 50%;
    left: 20%;
    transform: translate(-50%, -50%) rotateY(180deg);
    font-size: 18px;
    
}

.recommend {
    position: absolute;
    top: 50%;
    left: 80%;
    transform: translate(-50%, -50%);
    
}

.text {
	font-size: 18px;
	font-weight: bold;
	color: black;
}

.cpr {
	transform: rotateY(180deg);
}


</style>
</head>
<body>

	<div class="container-fluid">
		<div class="compare">
		<a href="/bcg/compare">
			<div class="text cpr">도서비교</div>
			<img src="<%=request.getContextPath() %>/resources/images/arrow2.png" />
		</a>
	</div>
		<div class="recommend">
			<a href="/bcg/recommend">
				<div class="text rcm">도서추천</div>
				<img src="<%=request.getContextPath() %>/resources/images/arrow2.png"/>
			</a>
		</div>
	</div>
</body>
</html>

