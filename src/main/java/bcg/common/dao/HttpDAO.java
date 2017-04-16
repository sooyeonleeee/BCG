package bcg.common.dao;

import bcg.common.entity.BookInfo;

public interface HttpDAO {
	public BookInfo getDetailDataWithIsbn(String isbn);
	public String getGraphUrl(String genrecode, String isbn);
	public String getWordCloudUrl(String genrecode, String isbn);
}
