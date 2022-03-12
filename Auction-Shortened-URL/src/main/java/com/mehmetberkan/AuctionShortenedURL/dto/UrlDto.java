package com.mehmetberkan.AuctionShortenedURL.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class UrlDto {
    private int urlId;
    private String url;
    private String shortenedUrl;
    @JsonBackReference
    private UserDto user;


    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
