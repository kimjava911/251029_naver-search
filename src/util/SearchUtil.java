package util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SearchUtil {
    // query -> UTF8 인코딩
    public static String encodeQuery(String query) {
        return URLEncoder.encode(query, StandardCharsets.UTF_8);
    }
}
