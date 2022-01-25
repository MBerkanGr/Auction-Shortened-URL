package com.mehmetberkan.AuctionShortenedURL.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int urlId;
    @NotBlank(message = "Url cannot be empty")
    private String url;
    @NotBlank(message = "ShortenedUrl cannot be empty")
    private String shortenedUrl;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id")
    private User user;

    public Url() {}

    public Url(int urlId, String url, String shortenedUrl, User user) {
        this.urlId = urlId;
        this.url = url;
        this.shortenedUrl = shortenedUrl;
        this.user = user;
    }

    public Url(String url, String shortenedUrl, User user) {
        this.url = url;
        this.shortenedUrl = shortenedUrl;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
