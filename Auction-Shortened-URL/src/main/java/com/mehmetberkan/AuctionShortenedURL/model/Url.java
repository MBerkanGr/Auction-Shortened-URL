package com.mehmetberkan.AuctionShortenedURL.model;

import javax.persistence.*;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int urlId;
    private String url;
    private String shortenedUrl;
    private int userId;

    public Url() {}

    public Url(String url, String shortenedUrl, int userId) {
        this.url = url;
        this.shortenedUrl = shortenedUrl;
        this.userId = userId;
    }

    public Url(int urlId, String url, String shortenedUrl, int userId) {
        this.urlId = urlId;
        this.url = url;
        this.shortenedUrl = shortenedUrl;
        this.userId = userId;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
