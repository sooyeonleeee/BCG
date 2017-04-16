package bcg.common.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bcg.common.entity.BookInfo;
import bcg.common.entity.CompareBook;
import bcg.common.service.RecommendServiceImpl;
import bcg.common.service.SearchServiceImpl;
import bcg.common.service.ShowInfoService;

@Controller
public class PageController {

	@Autowired
	SearchServiceImpl sservice;

	@Autowired
	RecommendServiceImpl rservice;
	
	@Autowired
	ShowInfoService showInfoService;

	@RequestMapping("/main")
	public String gotoMain() {
		return "main";
	}

	@RequestMapping("/compare")
	public String gotoCompare() {
		return "compare";
	}

	@RequestMapping("/search")
	public ModelAndView searchBook(String title) {
		ModelAndView mav = new ModelAndView();
		String comment = "' " + title + " '의 검색 결과";
		mav.addObject("searchResultComment", comment);
		List<CompareBook> result = sservice.searchService(title);
		mav.addObject("result", result);
		mav.setViewName("compare");
		return mav;
	}

	@RequestMapping("/recommend")
	public String recommend() {
		return "recommend";
	}
	
	
	@RequestMapping("/recommendAll")
	public ModelAndView callPageAll() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("recommendAll");
		List<CompareBook> list = rservice.getOrderedBookList();
		mav.addObject("orderedList", list);
		System.out.println("SYTEST: " + list.toString());
		return mav;
	}

	@RequestMapping("/recommendByCategory")
	public ModelAndView callPageCategory(String genreCode) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("recommendByCategory");
		mav.addObject("genreList", rservice.getGenres());
		List<SimpleEntry<String, String>> classList = new ArrayList<SimpleEntry<String, String>>();
		classList.add(new SimpleEntry<String, String>("satisfactionscore", "만족도"));
		classList.add(new SimpleEntry<String, String>("impressionscore", "느낌"));
		classList.add(new SimpleEntry<String, String>("legibilityscore", "가독성"));
		classList.add(new SimpleEntry<String, String>("compositionscore", "구성"));
		classList.add(new SimpleEntry<String, String>("authorscore", "작가"));
		classList.add(new SimpleEntry<String, String>("designscore", "표지디자인"));
		classList.add(new SimpleEntry<String, String>("usefulnessscore", "유익성"));
		mav.addObject("classList", classList);
		return mav;
	}
	
	@RequestMapping("/recommendByCategory.js")
	public ModelAndView callPageCategoryJS() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("recommendByCategoryJS");
		return mav;
	}

	@RequestMapping("/bookinfo")
	public ModelAndView showBookInfo(String bookCode) {
		System.out.println("SYTEST: " + bookCode);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookInfo");
		mav.addObject("bookinfo", showInfoService.showInfo(bookCode));
		
		return mav;
	}
	
	@RequestMapping(value = "/sortedbookinfo")
	public ModelAndView getBookListByGenreWithClass(HttpServletResponse response, String genreCode, String classCode, Integer page) {
		classCode = classCode.equals("undefined") || classCode == null ? "totalscore" : classCode;
		genreCode = genreCode.equals("undefined") ? null : genreCode;
		
		List<BookInfo> result = rservice.getBookListByGenreWithClassList(genreCode, classCode, page);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName("sortedbookinfo");
		
		return mav;
	}

}