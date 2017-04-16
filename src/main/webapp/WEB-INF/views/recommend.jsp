<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="recommend" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.nav {
	background: #333333;
}

.nav-justified {
	background: #333333;
}

.navbar {
	background: #333333;
}

#logo:hover {
	color: #E58F50;
}

#logo {
	font-size: 25px;
	font-weight: bold;
	color: white;
}

body {
	background: white;
}

#menu {
	color: white;
}

#menu:hover {
	color: black;
}

.nav-header: hover {
	background: white;
}

#page {
	padding-top: 70px;
}


</style>
<script>
$(document).ready(function(){
	$("#page").load("/bcg/recommendAll");

});

	$(function() {
		var btn = $("ul>li");
		btn.find("a").click(function() {
			btn.removeClass("active");
			$(this).parent().addClass("active");
		})
	})

	function loadPageNamedAll() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("page").innerHTML = this.responseText;
				/* eval("function clickGenre(genrecode) {document.getElementById(\"selectedClass\").innerHTML = \"ajdsfkakldjfkladsklajfsd\";}"); */
			}
		};
		xhttp.open("GET", "/bcg/recommendAll", true);
		xhttp.send();
	}

	function loadPageNamedCategory() {
		$.ajax({
			type : "GET",
			url : "/bcg/recommendByCategory.js",
			dataType: "script",
			success : function(response) {
				$.ajax({
					type : "GET",
					url : "/bcg/recommendByCategory",
					success : function(response) {
						document.getElementById("page").innerHTML = response;
					}
				});
			}
		});
	}


</script>


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
				<li id="all" class="active"><a href="javascript:loadPageNamedAll();" id="menu">
				전체 추천</a></li>
				<li id="category"><a href="javascript:loadPageNamedCategory();"
					id="menu">카테고리별 추천</a></li>
			</ul>
			</p>


		</div>
	</nav>


	<div class="container-fluid">
		<div id="page"></div>
	</div>



</body>
</html>