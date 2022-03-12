package com.mehmetberkan.AuctionShortenedURL.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private int userId;
    private String username;
    private String password;
    private List<UrlDto> urls = new ArrayList<>();


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public List<UrlDto> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlDto> urls) {
        this.urls = urls;
    }

    public void addUrl(UrlDto result) {
        this.urls.add(result);
    }
}
