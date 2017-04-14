
/* Drop Tables */

DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE bookinfo CASCADE CONSTRAINTS;
DROP TABLE class CASCADE CONSTRAINTS;
DROP TABLE genre CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE bookinfo
(
	bookcode varchar2(100) NOT NULL,
	genrecode number NOT NULL,
	title varchar2(4000),
	imgurl varchar2(4000),
	totalscore number,
	wordcloud varchar2(4000),
	graph varchar2(4000),
	PRIMARY KEY (bookcode)
);


CREATE TABLE class
(
	classcode number NOT NULL,
	classname varchar2(100) NOT NULL,
	PRIMARY KEY (classcode)
);


CREATE TABLE genre
(
	genrecode number NOT NULL,
	genrename varchar2(100) NOT NULL,
	PRIMARY KEY (genrecode)
);


CREATE TABLE review
(
	bookcode varchar2(100) NOT NULL,
	classcode number NOT NULL,
	classscore number NOT NULL,
	UNIQUE (bookcode, classcode)
);



/* Create Foreign Keys */

ALTER TABLE review
	ADD FOREIGN KEY (bookcode)
	REFERENCES bookinfo (bookcode)
;


ALTER TABLE review
	ADD FOREIGN KEY (classcode)
	REFERENCES class (classcode)
;


ALTER TABLE bookinfo
	ADD FOREIGN KEY (genrecode)
	REFERENCES genre (genrecode)
;



