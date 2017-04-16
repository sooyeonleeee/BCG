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
			books = JSON.parse(response);
			size = books.length;
			result="";
			
			for(i=0;i < size;i++) {
				document.getElementById("btnimg").innerHTML = "<button>"+books[i].imgurl+"</button>";
				document.getElementById("booktitle").innerHTML = books[i].title;
				document.getElementById("score").innerHTML = books[i].totalScore;
			}
			
		}
	});
	
}
async function delayGetBookListFromServer(currTime) {
	await sleep(3000);
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