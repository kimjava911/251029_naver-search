import model.ImageItem;
import model.NewsItem;
import service.NaverImageSearchService;
import service.NaverNewsSearchService;
import service.NaverSearchService;
import util.SearchUtil;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        NaverSearchService searchService = new NaverNewsSearchService();
        NaverSearchService searchService = new NaverImageSearchService();
        // TODO : NaverImageSearchService();
        // 파싱 -> JSON 해석
        String query = "닭도리탕";
        String result = searchService.search(query);
        // TODO : Util 안에 든 static으로 담을 것이냐 혹은 Service 메서드에 내장 시켜버릴 거냐...
        String tmp = result.split("\"items\":\\[")[1].strip();
        String[] items = tmp.split("},");
        if (searchService instanceof NaverNewsSearchService) {
            List<NewsItem> itemList = new ArrayList<>();
            for (String v : items) {
                itemList.add(SearchUtil.getNewsItem(v));
            }
            SearchUtil.saveNewsItem(query, itemList);
        } else if (searchService instanceof NaverImageSearchService) {
//            System.out.println(result);
            // TODO : Generic을 써서 ImageItem과 NewsItem을 동시에 처리하는 메서드
            List<ImageItem> itemList = new ArrayList<>();
            for (String v : items) {
                itemList.add(SearchUtil.getImageItem(v));
            }
            System.out.println(itemList);
        }
    }
}