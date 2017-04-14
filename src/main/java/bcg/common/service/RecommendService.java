package bcg.common.service;

import java.util.List;

import bcg.common.entity.Class;
import bcg.common.entity.CompareBook;
import bcg.common.entity.Genre;

public interface RecommendService {
	public List<Genre> getGenres();
	public List<Class> getClasses();
	public List<CompareBook> getOrderedBookList();
}
