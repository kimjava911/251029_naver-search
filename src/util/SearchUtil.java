package util;

import model.ImageItem;
import model.NewsItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

public class SearchUtil {
    // query -> UTF8 인코딩
    public static String encodeQuery(String query) {
        return URLEncoder.encode(query, StandardCharsets.UTF_8);
    }

    public static NewsItem getNewsItem(String jsonItem) {
        String[] data = jsonItem.split("\":\""); // ":"
        return new NewsItem(
                data[1].split("\",")[0],
                data[2].split("\",")[0],
                data[3].split("\",")[0],
                data[4].split("\",")[0],
                data[5].strip().substring(0, data[5].strip().length() - 1)
                        .split("\"")[0]
        );
    }

    public static void saveNewsItem(String query, List<NewsItem> items) {
        // 파일 이름에 확장자가 없음
//        String filename = query + "_" + LocalDateTime.now().toString().replace(":", ".");
        String filename = "%s_%s.txt".formatted(query, LocalDateTime.now().toString().replace(":", "."));
        File file = new File(filename);
        try (FileWriter writer = new FileWriter(file)) {
            if (!file.exists()) { // 존재여부 확인
                file.createNewFile();
            }
            for (NewsItem item : items) {
                writer.write("제목 : " + item.title() + "\n");
                writer.write("원본링크 : " + item.originallink() + "\n");
                writer.write("링크 : " + item.link() + "\n");
                writer.write("설명 : " + item.description() + "\n");
                writer.write("작성일시 : " + item.pubDate() + "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageItem getImageItem(String jsonItem) {
        String[] data = jsonItem.split("\":\""); // ":"
        return new ImageItem(
                data[1].split("\",")[0],
                data[2].split("\",")[0],
                data[3].split("\",")[0],
                data[4].split("\",")[0],
                data[5].strip().substring(0, data[5].strip().length() - 1)
                        .split("\"")[0]
        );
    }

}
