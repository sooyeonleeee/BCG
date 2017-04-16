<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${result }" var="book">
	<div class="media">
		<div class="media-left">

			<!-- <button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#bookInfo" > -->
			<%-- <button type="button" class="btn btn-info btn-lg" 
						id="bookimg" onclick="show(${book.bookCode})" > --%>

			<button type="button" class="btn btn-info btn-lg"
				onclick="location.href='/bcg/bookinfo?bookCode=${book.bookCode}'">
				<img src="${book.imgurl }" class="media-object" style="width: 150px">
			</button>

		</div>

		<script type="text/javascript">
			function show(code) {
				$("#booktitle").html(str);
				$("#bookcontent").html();	
				$("#bookInfo").modal('show');				
			}
		</script>
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
	<!-- modal -->
	<div class="modal fade" id="bookInfo" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="booktitle"></h4>
				</div>
				<div class="modal-body">
					<p id="bookcontent">
						<!--  bookinfo -->
						${book.title }
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<hr>
</c:forEach>