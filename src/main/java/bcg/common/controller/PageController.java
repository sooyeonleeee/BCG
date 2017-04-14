package bcg.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bcg.common.entity.CompareBook;
import bcg.common.service.RecommendServiceImpl;
import bcg.common.service.SearchServiceImpl;

@Controller
public class PageController {

	@Autowired
	SearchServiceImpl sservice;

	@Autowired
	RecommendServiceImpl rservice;

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
		mav.addObject("classList", rservice.getClasses());
		return mav;
	}

	@RequestMapping("/bookinfo")
	public ModelAndView showBookInfo(String bookCode) {
		System.out.println("SYTEST: " + bookCode);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("compare");
		return mav;
	}

}
