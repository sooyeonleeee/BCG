package bcg.common.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;

import bcg.common.entity.BookInfo;

@Repository
public class HttpDAOImpl implements HttpDAO {
	private static final String PORT_NUMBER = "8080";
	private static final String CLIENT_ID = "NhVxbyH9_ivHUb7aIpVE";
	private static final String CLIENT_SECRET = "9w62Ip3ley";
	private static final String REQUEST_URL = "https://openapi.naver.com/v1/search/book_adv.json";
	
	@Autowired
	private RedisDAO redisDAO;

	@Override
	public BookInfo getDetailDataWithIsbn(String isbn) {
		String urlWithQuery = REQUEST_URL + "?display=10&d_isbn=" + isbn;
		String redisQuery = urlWithQuery;
		BookInfo result = redisDAO.getObject(redisQuery, BookInfo.class);
		
		if (result != null) {
			try {
				HttpURLConnection con = (HttpURLConnection) new URL(urlWithQuery).openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
				con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
				con.connect();
				int responseCode = con.getResponseCode();
				
				if (responseCode == 200) { // 정상 호출
					@SuppressWarnings("unchecked")
					Map<String, Object> response = (Map<String, Object>) (new ObjectMapper()).readValue(con.getInputStream(), Map.class);
					System.out.println(response);
					@SuppressWarnings("unchecked")
					List<Map<String, Object>> items = (List<Map<String, Object>>)response.get("items");
					Map<String, Object> item = items.get(0);
					result.setTitle((String)item.get("title"));
					result.setImgurl((String)item.get("image"));
					result.setAuthor((String)item.get("author"));
					result.setPublisher((String)item.get("publisher"));
					result.setDescription((String)item.get("description"));
					result.setPrice((Integer)item.get("price"));
					result.setBookCode((String)item.get("isbn"));
					result.setPubdate(new SimpleDateFormat("yyyyMMdd").parse((String)item.get("pubdate")));
					
					redisDAO.setObject(redisQuery, result);
				} else { // 에러 발생
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
					StringBuffer response = new StringBuffer();
					for(String inputLine = br.readLine(); inputLine != null; inputLine = br.readLine()) {
						response.append(inputLine);
					}
					result = null;
					System.out.println(response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = null;
			}
		}
		
		return result;
	}
	
	public String getGraphUrl(String genrecode, String isbn) {
		String result = "/bcg/resources/graph/" + genrecode + "a" + isbn + ".png";
		try {
			HttpURLConnection con = (HttpURLConnection) new URL("http://localhost:" + PORT_NUMBER + result).openConnection();
            con.connect();
            if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
            	result = null;
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = null;
		}
		return result;
	}
	
	public String getWordCloudUrl(String genrecode, String isbn) {
		String result = "/bcg/resources/wordCloud/" + genrecode + "a" + isbn + ".html";
		try {
			HttpURLConnection con = (HttpURLConnection) new URL("http://localhost:" + PORT_NUMBER + result).openConnection();
            con.connect();
            if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
            	result = "/bcg/resources/wordCloud/" + genrecode + "a" + isbn + ".png";
            	con = (HttpURLConnection) new URL("http://localhost:" + PORT_NUMBER + result).openConnection();
                con.connect();
                if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                	result = null;
                }
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = null;
		}
		return result;
	}
}
