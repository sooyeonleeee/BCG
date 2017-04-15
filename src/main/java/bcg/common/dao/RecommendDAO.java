package bcg.common.dao;

import java.util.List;

import bcg.common.entity.BookInfo;
import bcg.common.entity.CompareBook;
import bcg.common.entity.Genre;

public interface RecommendDAO {
	//장르 얻어오기
	public List<Genre> getGenreList();
	
	//점수 순으로 정렬한 책 리스트 얻어오기
	public List<CompareBook> getSortedBookList();
	
	//
	public List<BookInfo> getBookListByGenreWithClassList(String genreCode, String classCode, Integer page);
	
}
