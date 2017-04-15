package bcg.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bcg.common.entity.BookInfo;
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
		
		String redisQuery = stmt;
		@SuppressWarnings("unchecked")
		List<Genre> result = redisDAO.getObject(redisQuery, List.class);
		
		if(result == null) {
			result = sqlSession.selectList(stmt);
			redisDAO.setObject(redisQuery, result);
		}

		return result;
	}

	@Override
	public List<CompareBook> getSortedBookList() {
		String stmt = namespace + "orderbyTotalScore";
		
		String redisQuery = stmt;
		@SuppressWarnings("unchecked")
		List<CompareBook> result = redisDAO.getObject(redisQuery, List.class);
		
		if(result == null) {
			result = sqlSession.selectList(stmt);
			redisDAO.setObject(redisQuery, result);
		}

		return result;
	}
	
	@Override
	public List<BookInfo> getBookListByGenreWithClassList(String genreCode, String classCode, Integer page) {
		String stmt = namespace + "selectBookListByGenreWithClass";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("genrecode", genreCode);
		param.put("classcode", classCode);
		param.put("page", page);
		
		String redisQuery = stmt + ":" + genreCode + ":" + classCode + ":" + page;
		@SuppressWarnings("unchecked")
		List<BookInfo> result = redisDAO.getObject(redisQuery, List.class);

		if(result == null) {
			result = sqlSession.selectList(stmt, param);
			redisDAO.setObject(redisQuery, result);
		}

		return result;
	}

}
