package bcg.common.entity;

import java.util.Date;

public class BookInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	// DB에서 불러올 부분
	private String bookCode;
	private String title;
	private Double totalScore;
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
	
	private Double satisfactionScore;
	private Double impressionScore;
	private Double legibilityScore;
	private Double compositionScore;
	private Double authorScore;
	private Double designScore;
	private Double usefulnessScore;
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

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
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

	public Double getSatisfactionScore() {
		return satisfactionScore;
	}

	public void setSatisfactionScore(Double satisfactionScore) {
		this.satisfactionScore = satisfactionScore;
	}

	public Double getImpressionScore() {
		return impressionScore;
	}

	public void setImpressionScore(Double impressionScore) {
		this.impressionScore = impressionScore;
	}

	public Double getLegibilityScore() {
		return legibilityScore;
	}

	public void setLegibilityScore(Double legibilityScore) {
		this.legibilityScore = legibilityScore;
	}

	public Double getCompositionScore() {
		return compositionScore;
	}

	public void setCompositionScore(Double compositionScore) {
		this.compositionScore = compositionScore;
	}

	public Double getAuthorScore() {
		return authorScore;
	}

	public void setAuthorScore(Double authorScore) {
		this.authorScore = authorScore;
	}

	public Double getDesignScore() {
		return designScore;
	}

	public void setDesignScore(Double designScore) {
		this.designScore = designScore;
	}

	public Double getUsefulnessScore() {
		return usefulnessScore;
	}

	public void setUsefulnessScore(Double usefulnessScore) {
		this.usefulnessScore = usefulnessScore;
	}

	@Override
	public String toString() {
		return "BookInfo [bookCode=" + bookCode + ", title=" + title + ", totalScore=" + totalScore + ", imgurl="
				+ imgurl + ", genreCode=" + genreCode + ", wordCloud=" + wordCloud + ", graph=" + graph + ", author="
				+ author + ", publisher=" + publisher + ", description=" + description + ", price=" + price
				+ ", pubdate=" + pubdate + ", satisfactionScore=" + satisfactionScore + ", impressionScore="
				+ impressionScore + ", legibilityScore=" + legibilityScore + ", compositionScore=" + compositionScore
				+ ", authorScore=" + authorScore + ", designScore=" + designScore + ", usefulnessScore="
				+ usefulnessScore + "]";
	}	
}
