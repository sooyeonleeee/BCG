package bcg.common.dao;

import java.util.List;

import bcg.common.entity.CompareBook;

public interface SearchDAO {	
	public List<CompareBook> searchFromDB(String title);
	
}
