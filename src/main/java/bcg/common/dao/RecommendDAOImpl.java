package bcg.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bcg.common.entity.BookInfo;
import bcg.common.entity.Class;
import bcg.common.entity.CompareBook;
import bcg.common.entity.Genre;

@Repository
public class RecommendDAOImpl implements RecommendDAO {

	private final String namespace = "com.bcg.mappers.bookmapper.";

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private RedisDAO redisDAO;

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

	@Override
	public List<BookInfo> getBookListByGenreWithClassList(String genreCode, String classCode, Integer page) {
		String stmt = namespace + "selectBookListByGenreWithClass";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("genrecode", genreCode);
		param.put("classcode", classCode);
		param.put("page", page);
		
		String redisQuery = stmt+":" + genreCode + ":" + classCode + ":" + page;
		Object redisResult = redisDAO.getObject(redisQuery);
		
		List<BookInfo> result = null;
		
		if(redisResult == null) {
			result = sqlSession.selectList(stmt, param);
			redisDAO.setObject(redisQuery, result);
			System.out.println("unsaved");
		} else {
			result = (List<BookInfo>)redisResult;
			System.out.println("saved");
		}
		
		return result;
	}

}
