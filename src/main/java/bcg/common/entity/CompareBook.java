package bcg.common.entity;

public class CompareBook implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String bookCode;
	private String title;
	private String imgurl;
	private int totalScore;
	private int isExistsInDB;

	public CompareBook() {
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

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getIsExistsInDB() {
		return isExistsInDB;
	}

	public void setIsExistsInDB(int isExistsInDB) {
		this.isExistsInDB = isExistsInDB;
	}

	@Override
	public String toString() {
		return "CompareBook [bookCode=" + bookCode + ", title=" + title + ", imgurl=" + imgurl + ", totalScore="
				+ totalScore + ", isExistsInDB=" + isExistsInDB + "]";
	}

}
