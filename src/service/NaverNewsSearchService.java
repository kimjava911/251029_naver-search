package service;

import model.HttpException;
import util.SearchUtil;

public class NaverNewsSearchService extends AbstractNaverSearchService {

    public NaverNewsSearchService() {
        super("https://openapi.naver.com/v1/search/news.json");
    }

    @Override
    public String search(String query) { // throws도 interface와 일치해야함
        String url = "%s?query=%s".formatted(baseUrl, SearchUtil.encodeQuery(query));
//        String[] headers = {"X-Naver-Client-Id", NAVER_CLIENT_ID, "X-Naver-Client-Secret", NAVER_CLIENT_SECRET};
        try {
            return sendRequest(url, headers);
        } catch (HttpException e) { // Custom -> 내용을 보강하고...
            throw new RuntimeException(e.statusCode + " " + e.getMessage());
//            throw e; // 해당 에러를 다시 던지고 싶으면
        } catch (Exception e) { // 어쩔 수 없는...
            throw new RuntimeException(e);
        }
    }
}
