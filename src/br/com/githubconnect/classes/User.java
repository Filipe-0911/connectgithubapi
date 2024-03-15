package br.com.githubconnect.classes;

public class User {
    private String userName;
    private String token;

    public User(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return String.format("User: %s", this.getUserName());
    }

}
