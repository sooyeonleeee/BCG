package bcg.common.entity;

import java.util.Date;
import java.util.HashMap;

public class BookInfo {
	// DB에서 불러올 부분
	private String bookCode;
	private String title;
	private int totalScore;
	private String imgurl;
	private int genreCode;
	private String wordCloud;
	private String graph;
	// api에서 불러올 부분
	private String author;
	private String publisher;
	private String description;
	private int price;
	private Date pubdate;
	// wordcloud와 graph는 resource에 저장해 놓고 불러오기(wordcloud_xxx, graph_xxx)
	// mapkey: classcode, mapvalue: classscore

	public BookInfo() {
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}

	public String getWordCloud() {
		return wordCloud;
	}

	public void setWordCloud(String wordCloud) {
		this.wordCloud = wordCloud;
	}

	public String getGraph() {
		return graph;
	}

	public void setGraph(String graph) {
		this.graph = graph;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	@Override
	public String toString() {
		return "BookInfo [bookCode=" + bookCode + ", title=" + title + ", totalScore=" + totalScore + ", imgurl="
				+ imgurl + ", genreCode=" + genreCode + ", wordCloud=" + wordCloud + ", graph=" + graph + ", author="
				+ author + ", publisher=" + publisher + ", description=" + description + ", price=" + price
				+ ", pubdate=" + pubdate + "]";
	}

	
	
}
