package bcg.common.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class APIExamSearchTemp {

	public static final String log = "SYTEST: ";

	public String searchByTitle(String title, int display) {
		String clientId = "NhVxbyH9_ivHUb7aIpVE";
		String clientSecret = "9w62Ip3ley";
		StringBuffer response = null;
		try {
			String text = URLEncoder.encode(title, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/book_adv.json?d_titl=" + text + "&display=" + display; 
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
			}
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, Object> temp = mapper.readValue(response.toString(), HashMap.class);
			for (Map<String, Object> data : ((List<Map<String, Object>>) temp.get("items"))) {
				System.out.println(log + data.get("isbn"));
			}

			System.out.println(log + temp.get("items"));
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(log + response.toString());
		return response.toString();
	}

}
