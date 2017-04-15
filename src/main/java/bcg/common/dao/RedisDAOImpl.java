package bcg.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDAOImpl implements RedisDAO {
	@Autowired
	private RedisTemplate<String, Object> redisSesseion;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getObject(String key, Class<T> valueType) {
		return (T)redisSesseion.opsForValue().get(key);
	}

	@Override
	public <T> void setObject(String key, T value) {
		redisSesseion.opsForValue().set(key, value, 10, java.util.concurrent.TimeUnit.MINUTES);
	}

}
