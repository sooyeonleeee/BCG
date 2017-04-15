package bcg.common.dao;

public interface RedisDAO {
	public Object getObject(String key);
	public void setObject(String key, Object value);
}
