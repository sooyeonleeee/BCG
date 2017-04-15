package bcg.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDAOImpl implements RedisDAO {
	@Autowired
	private RedisTemplate redisSesseion;

	@Override
	public Object getObject(String key) {
		return redisSesseion.opsForValue().get(key);
	}

	@Override
	public void setObject(String key, Object value) {
		redisSesseion.opsForValue().set(key, value);
	}

}
