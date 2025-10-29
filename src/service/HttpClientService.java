package service;

import model.HttpException;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// mixin
public interface HttpClientService {
    // interface default.
    HttpClient client = HttpClient.newHttpClient();

    default String sendRequest(String url, String[] headers) throws HttpException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .headers(headers)
                .build();
        // IOException <- 일반적으로 발생할 일 없는데...
        HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString()
        );
        if (response.statusCode() != 200) {
            // URL 잘못 입력했거나 api key 누락되면 발생...
            throw new HttpException(
                    response.statusCode(),
                    response.body());
        }
        return response.body();
    }
}
