<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="page-header">
		<h1>카테고리별 추천</h1>
	</div>
	<div class="container-fluid">장르와 카테고리를 선택하세요.</div>
	<br>
	<p align="right">
	<button type="button" class="btn btn-primary" id="resetBtn"
		onclick="javascript:reset();">모든 선택 해제</button></p>
	<div class="btn-group btn-group-justified">
		<c:forEach items="${genreList }" var="genre">
			<div class="btn-group">
			
				<button type="button" class="btn btn-primary" id="genreBtn"
					value="${genre.genreCode }"
					onclick="javascript:clickGenre('${genre.genreCode }');">${genre.genreName }</button>
			</div>
		</c:forEach>
	</div>
	<br>
	<div class="btn-group btn-group-justified">
		<c:forEach items="${classList }" var="category">
			<div class="btn-group">
				<button type="button" class="btn btn-primary" id="classBtn"
					value="${category.key }"
					onclick="javascript:clickClass('${category.key }');">${category.value }</button>
			</div>
		</c:forEach>
	</div>

<!-- 여기부터 수정함(원래 result div만 있던 곳) -->
	<div class="container-fluid" id="info">
		<div class="row">
				<div class="media">
					<div class="media-left">
							
							<button type="button" id ="btnimg" style="width:150px; h" class="btn btn-info btn-lg media-object" onclick="location.href='#'">
								<!-- <img src="" class="media-object" style="width: 150px" id="btnimg"> -->
								
							</button>
					</div>
					

					<div class="media-body">
						<p align="justify">
						<h4 class="media-heading" id="booktitle"></h4> 
						<br>
						
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="70"
								aria-valuemin="0" aria-valuemax="100" id="scorebar"></div> 
						</div>
					
					</div>
				
				
				</div>
		</div>
	</div>
</div>


<div id="selectedGenre"></div>
<div id="selectedClass"></div>