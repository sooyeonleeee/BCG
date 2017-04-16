package bcg.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bcg.common.dao.HttpDAO;
import bcg.common.dao.SearchDAO;
import bcg.common.entity.BookInfo;

@Service
public class ShowInfoServiceImpl implements ShowInfoService {

	@Autowired
	private SearchDAO searchDAO;
	
	@Autowired
	private HttpDAO httpDAO;
	
	@Override
	public BookInfo showInfo(String isbn) {
		BookInfo result = null;
		
		BookInfo bookInfoFromDB = searchDAO.getBookinfoWithIsbn(isbn);
		BookInfo bookInfoFromHttp = httpDAO.getDetailDataWithIsbn(isbn);
		
		if (bookInfoFromHttp != null) {
			result = bookInfoFromHttp;
		}
		if (bookInfoFromDB != null) {
			result = result != null ? result : new BookInfo();
			result.setBookCode(bookInfoFromDB.getBookCode());
			result.setCompositionScore(bookInfoFromDB.getCompositionScore());
			result.setDesignScore(bookInfoFromDB.getDesignScore());
			result.setGenreCode(bookInfoFromDB.getGenreCode());
			result.setImgurl(bookInfoFromDB.getImgurl());
			result.setImpressionScore(bookInfoFromDB.getImpressionScore());
			result.setLegibilityScore(bookInfoFromDB.getLegibilityScore());
			result.setSatisfactionScore(bookInfoFromDB.getSatisfactionScore());
			result.setTitle(bookInfoFromDB.getTitle());
			result.setTotalScore(bookInfoFromDB.getTotalScore());
			result.setUsefulnessScore(bookInfoFromDB.getUsefulnessScore());
		}
		if (result != null) {
			result.setGraph(httpDAO.getGraphUrl(String.valueOf(result.getGenreCode()), isbn));
			result.setWordCloud(httpDAO.getWordCloudUrl(String.valueOf(result.getGenreCode()), isbn));
		}
		return result;
	}
}
