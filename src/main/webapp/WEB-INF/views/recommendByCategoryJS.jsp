<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
var lastRequestTime = 0;
var currPageInfo = 0;
function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}
function getBookListFromServer() {
	var selectedGenreCode = document.getElementById("selectedGenre").val;
	var selectedClassCode = document.getElementById("selectedClass").val;
	var urlParam = "genreCode=" + selectedGenreCode + "&classCode=" + selectedClassCode + "&page=" + currPageInfo;
	var books, size, i;
	$.ajax({
		type : "GET",
		url : "/bcg/sortedbookinfo?" + urlParam,
		success : function(response) {
			console.log(response);
			books = response;
			size = books.length;
			console.log(size);
			for(i=0;i < size;i++) {
				 document.getElementById("info").style.visibility ="visible";
				  document.getElementById("booktitle").innerHTML += books[i].title;
				  document.getElementById("scorebar").style.width="books[i].totalScore";
				   document.getElementById("scorebar").innerHTML = books[i].totalScore+"%";
				document.getElementById("btnimg").style.backgroundImage = "url(\'" + books[i].imgurl + "\')";
			}
			
		}
	});
	
}
async function delayGetBookListFromServer(currTime) {
	await sleep(1000);
	console.log("called : " + lastRequestTime + " : " + currTime);
	if ( currTime == lastRequestTime) {
		getBookListFromServer()
	}
}
function clickGenre(genrecode) {
	lastRequestTime = lastRequestTime + 1;
	document.getElementById("selectedGenre").val = genrecode;
	currPageInfo = 0;
	delayGetBookListFromServer(lastRequestTime);
}
function clickClass(classcode) {
	lastRequestTime = lastRequestTime + 1;
	document.getElementById("selectedClass").val = classcode;
	currPageInfo = 0;
	delayGetBookListFromServer(lastRequestTime);
}
function reset() {
	document.getElementById("selectedGenre").val = "";
	document.getElementById("selectedClass").val = "";
	currPageInfo = 0;
}