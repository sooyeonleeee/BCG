package bcg.common.entity;

public class Genre implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int genreCode;
	private String genreName;

	public Genre() {

	}

	public Genre(int genreCode, String genreName) {
		this.genreCode = genreCode;
		this.genreName = genreName;
	}

	public int getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreCode=" + genreCode + ", genreName=" + genreName + "]";
	}

}
