package bcg.common.dao;

import java.util.List;

import bcg.common.entity.BookInfo;
import bcg.common.entity.CompareBook;
import bcg.common.entity.Genre;

public interface RecommendDAO {
	//�帣 ������
	public List<Genre> getGenreList();
	
	//���� ������ ������ å ����Ʈ ������
	public List<CompareBook> getSortedBookList();
	
	//
	public List<BookInfo> getBookListByGenreWithClassList(String genreCode, String classCode, Integer page);
	
}
