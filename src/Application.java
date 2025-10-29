import model.HttpException;
import model.NewsItem;
import service.NaverNewsSearchService;
import service.NaverSearchService;
import util.SearchUtil;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        NaverSearchService searchService = new NaverNewsSearchService();
        // TODO : NaverImageSearchService();
        // 파싱 -> JSON 해석
        String query = "칼국수";
        String result = searchService.search(query);
        if (searchService instanceof NaverNewsSearchService) {
            String tmp = result.split("\"items\":\\[")[1].strip();
            String[] items = tmp.split("},");
            List<NewsItem> itemList = new ArrayList<>();
            for (String v : items) {
                itemList.add(SearchUtil.getNewsItem(v));
            }
            SearchUtil.saveNewsItem(query, itemList);
        }
    }
}