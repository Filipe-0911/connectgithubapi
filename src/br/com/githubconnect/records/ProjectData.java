package br.com.githubconnect.records;

public record ProjectData(int id, String name, UserData owner, String html_url, String url, String created_at, String updated_at, String language) {
}
