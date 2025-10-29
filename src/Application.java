import model.HttpException;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String[] args) {
        /*
            curl "https://openapi.naver.com/v1/search/news.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1&sort=sim" \
                -H "X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}" \
                -H "X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}"
         */
        final String baseUrl = "https://openapi.naver.com/v1/search/news.json";
        String query = "칼국수";
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String NAVER_CLIENT_ID = System.getenv("NAVER_CLIENT_ID");
        String NAVER_CLIENT_SECRET = System.getenv("NAVER_CLIENT_SECRET");
        HttpRequest request = HttpRequest.newBuilder()
                // 쿼리스트링(queryString). Search Parameters
                .uri(URI.create("%s?query=%s".formatted(baseUrl, encodedQuery)))
                .header("X-Naver-Client-Id", NAVER_CLIENT_ID)
                .header("X-Naver-Client-Secret", NAVER_CLIENT_SECRET)
                .build();
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
//            System.out.println(statusCode);
            if (statusCode != 200) {
                throw new HttpException(statusCode, response.body());
            }
            System.out.println(response.body());
            // 400 -> {"errorMessage":"/v1/search/news.json : Bad Request. (Check Extension or Required Parameter)","errorCode": "400"}
            // 401 -> {"errorMessage":"Not Exist Client ID : Authentication failed. (인증에 실패했습니다.)","errorCode":"024"}
        } catch (HttpException e) {
            System.err.println(e.statusCode);
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}