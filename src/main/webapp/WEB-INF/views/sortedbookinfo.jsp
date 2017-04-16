<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${result }" var="book">
	<div class="media">
		<div class="media-left">
			<button type="button" class="btn btn-info btn-lg"
				onclick="location.href='/bcg/bookinfo?bookCode=${book.bookCode}'">
				<img src="${book.imgurl }" class="media-object" style="width: 150px">
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