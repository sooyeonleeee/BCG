
/* Drop Tables */

DROP TABLE bookinfo CASCADE CONSTRAINTS;
DROP TABLE genre CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE bookinfo
(
	bookcode varchar2(100) NOT NULL,
	genrecode number NOT NULL,
	title varchar2(4000),
	imgurl varchar2(4000),
	wordcloud varchar2(4000),
	graph varchar2(4000),
	totalscore number(10,4),
	satisfactionscore number(10,4),
	impressionscore number(10,4),
	legibilityscore number(10,4),
	compositionscore number(10,4),
	authorscore number(10,4),
	designscore number(10,4),
	usefulnessscore number(10,4),
	PRIMARY KEY (bookcode)
);


CREATE TABLE genre
(
	genrecode number NOT NULL,
	genrename varchar2(100) NOT NULL,
	PRIMARY KEY (genrecode)
);



/* Create Foreign Keys */

ALTER TABLE bookinfo
	ADD FOREIGN KEY (genrecode)
	REFERENCES genre (genrecode)
;



