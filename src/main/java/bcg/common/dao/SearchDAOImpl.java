package bcg.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bcg.common.entity.CompareBook;

@Repository
public class SearchDAOImpl implements SearchDAO {

	private final String namespace = "com.bcg.mappers.bookmapper.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private RedisDAO redisDAO;

	@Override
	public List<CompareBook> searchFromDB(String title) {
		// TODO Auto-generated method stub
		String stmt = namespace + "selectByTitle";
		
		String redisQuery = stmt;
		@SuppressWarnings("unchecked")
		List<CompareBook> result = redisDAO.getObject(redisQuery, List.class);
		
		if(result == null) {
			result = sqlSession.selectList(stmt);
			redisDAO.setObject(redisQuery, result);
		}

		return result;
	}

}
