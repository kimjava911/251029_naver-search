import model.NewsItem;
import service.NaverNewsSearchService;
import service.NaverSearchService;
import util.SearchUtil;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        NaverSearchService searchService = new NaverNewsSearchService();
        // TODO : NaverImageSearchService();
        // 파싱 -> JSON 해석
        String query = "닭도리탕";
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