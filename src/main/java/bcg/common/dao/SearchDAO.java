package bcg.common.dao;

import java.util.List;

import bcg.common.entity.CompareBook;

public interface SearchDAO {
	public List<CompareBook> searchFromDB(String title);	
	
	public String makeQuery(String title);
	
	public void searchFromRedis(String title);
	public List<CompareBook> searchFromOracle(String title);
	
}
