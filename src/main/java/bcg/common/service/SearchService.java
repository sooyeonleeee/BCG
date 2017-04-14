package bcg.common.service;

import java.util.List;

import bcg.common.entity.CompareBook;

public interface SearchService {
	
	public List<CompareBook> searchService(String title);
	
}
