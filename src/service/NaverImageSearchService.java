package service;

import model.HttpException;
import util.SearchUtil;

// https://developers.naver.com/docs/serviceapi/search/image/image.md
public class NaverImageSearchService extends AbstractNaverSearchService {

    // baseUrl 교체
    public NaverImageSearchService() {
        super("https://openapi.naver.com/v1/search/image.json");
    }

    @Override
    public String search(String query) {
        // AbstractClass로 올리는게 맞긴한데...
        String url = "%s?query=%s".formatted(baseUrl, SearchUtil.encodeQuery(query));
        try {
            return sendRequest(url, headers);
        } catch (HttpException e) { // Custom -> 내용을 보강하고...
            throw new RuntimeException(e.statusCode + " " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
