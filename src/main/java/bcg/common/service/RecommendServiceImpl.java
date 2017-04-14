package bcg.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bcg.common.dao.RecommendDAO;
import bcg.common.entity.Class;
import bcg.common.entity.CompareBook;
import bcg.common.entity.Genre;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	RecommendDAO dao;
	
	@Override
	public List<Genre> getGenres() {
		return dao.getGenreList();
	}

	@Override
	public List<Class> getClasses() {
		return dao.getClassList();
	}

	@Override
	public List<CompareBook> getOrderedBookList() {
		return dao.getSortedBookList();
	}

}
