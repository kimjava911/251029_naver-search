import model.HttpException;
import service.NaverNewsSearchService;
import service.NaverSearchService;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String[] args) {
        NaverSearchService searchService = new NaverNewsSearchService();
        String result = searchService.search("칼국수");
        System.out.println(result);
    }
}