package service;

public interface NaverSearchService {
    // https://developers.naver.com/docs/serviceapi/search/news/news.md
    String search(String query);
    // interface => 뉴스, 이미지
    // json -> 문자열
}
