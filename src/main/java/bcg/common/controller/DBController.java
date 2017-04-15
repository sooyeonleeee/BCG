package bcg.common.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DBController {

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Resource(name = "redisTemplate")
	private HashOperations<String, String, String> hashOperations;

	static final Logger LOGGER = LoggerFactory.getLogger(DBController.class);

	@RequestMapping("/rediskeys")
	public ModelAndView testMethod() {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		/*
		 * String pattern = "*나미야*"; ScanOptions options =
		 * ScanOptions.scanOptions().match(pattern).count(0).build();
		 * Cursor<Entry<String, String>> result = hashOperations.scan("Book",
		 * options);
		 */
		Map<String, String> map = hashOperations.entries("Book");
		System.out.println("SYTEST: 책 return 결과 ->" + map);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("header");
		mav.addObject("result", map);
		return mav;
	}

	@RequestMapping("jsontest")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("header");
		JSONObject test = new JSONObject();
		test.put("key", "value");
		test.put("aa", "valueofaa");
		mav.addObject("result", test);
		System.out.println("SYTEST: " + test.toJSONString());
		return mav;
	}

}
