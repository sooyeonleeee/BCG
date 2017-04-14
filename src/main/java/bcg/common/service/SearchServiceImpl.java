package bcg.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bcg.common.dao.SearchDAO;
import bcg.common.entity.CompareBook;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	SearchDAO dao;
	
	List<CompareBook> books = null;

	@Override
	public List<CompareBook> searchService(String title) {
		books = dao.searchFromDB(title);
		return books;
	}
	

}
