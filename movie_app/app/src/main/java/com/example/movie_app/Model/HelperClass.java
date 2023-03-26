package com.example.movie_app.Model;
// This class use for database
public class HelperClass {
    String email, username, password, avatarUrl;

    public HelperClass(){

    }

    public HelperClass(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public HelperClass(String email, String username, String password, String avatarUrl) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
