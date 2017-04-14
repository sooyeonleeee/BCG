package bcg.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bcg.common.entity.Class;
import bcg.common.entity.CompareBook;
import bcg.common.entity.Genre;

@Repository
public class RecommendDAOImpl implements RecommendDAO {

	private final String namespace = "com.bcg.mappers.bookmapper.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Genre> getGenreList() {
		String stmt = namespace + "selectGenre";
		List<Genre> genreList = sqlSession.selectList(stmt);
		return genreList;
	}

	@Override
	public List<Class> getClassList() {
		String stmt = namespace + "selectClass";
		List<Class> classList = sqlSession.selectList(stmt);
		return classList;
	}

	@Override
	public List<CompareBook> getSortedBookList() {
		String stmt = namespace + "orderbyTotalScore";
		List<CompareBook> bookList = sqlSession.selectList(stmt);
		return bookList;
	}

}
