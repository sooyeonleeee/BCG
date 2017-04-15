package bcg.common.dao;

public interface RedisDAO {
	public <T> T getObject(String key, Class<T> valueType);
	public <T> void setObject(String key, T value);
}
