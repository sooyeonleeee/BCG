package bcg.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bcg.common.api.APIExamSearch;
import bcg.common.entity.BookInfo;

@Service
public class ShowInfoServiceImpl implements ShowInfoService {

	@Autowired
	APIExamSearch api;
	
	@Override
	public BookInfo showInfo() {
	
		return null;
	}

}
