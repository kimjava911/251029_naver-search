package service;

// 추상 클래스
public abstract class AbstractNaverSearchService implements NaverSearchService, HttpClientService {
    protected final String baseUrl = "https://openapi.naver.com/v1/search/news.json";
    protected final String NAVER_CLIENT_ID = System.getenv("NAVER_CLIENT_ID");
    protected final String NAVER_CLIENT_SECRET = System.getenv("NAVER_CLIENT_SECRET");
    protected final String[] headers = {"X-Naver-Client-Id", NAVER_CLIENT_ID, "X-Naver-Client-Secret", NAVER_CLIENT_SECRET};


    protected AbstractNaverSearchService() {
        // 설정을 안해서 null 값이 나왔을 때
      if (NAVER_CLIENT_ID == null || NAVER_CLIENT_SECRET == null)  {
          // 401가 예정되어 있는 셈
          throw new RuntimeException("네이버 클라이언트 ID 혹은 네이버 클라이언트 SECRET을 찾을 수 없습니다");
          // throws X. -> 에러가 나면서 흐름 제어.
      }
    }
}
