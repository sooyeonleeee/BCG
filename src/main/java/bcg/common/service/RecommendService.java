package bcg.common.service;

import java.util.List;

import bcg.common.entity.BookInfo;
import bcg.common.entity.CompareBook;
import bcg.common.entity.Genre;

public interface RecommendService {
	public List<Genre> getGenres();
	public List<CompareBook> getOrderedBookList();
	List<BookInfo> getBookListByGenreWithClassList(String genreCode, String classCode, Integer page);
}
