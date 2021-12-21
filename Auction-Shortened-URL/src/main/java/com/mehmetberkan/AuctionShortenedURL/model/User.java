package com.mehmetberkan.AuctionShortenedURL.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user",
               cascade = CascadeType.ALL)
    private List<Url> urls;

    public User() {}

    public User(int userId, String username, String password, List<Url> urls) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.urls = urls;
    }

    public User(String username, String password, List<Url> urls) {
        this.username = username;
        this.password = password;
        this.urls = urls;
    }

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

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }
}
