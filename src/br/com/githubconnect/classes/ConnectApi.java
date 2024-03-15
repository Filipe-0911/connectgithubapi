package br.com.githubconnect.classes;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectApi {
    private String url;
    private String json;
    private String token;

    public ConnectApi(String url, String token) {
        this.url = url;
        this.token = token;
        _connectToApi(this.url);
    }

    public ConnectApi(User user) {
        this.url = "https://api.github.com/users/%s/repos".formatted(user.getUserName());
        this.token = user.getToken();
        _connectToApi(this.url);
    }

    private void _connectToApi(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "token " + token)
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            this.json = json;

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getJson() {
        return json;
    }
}
