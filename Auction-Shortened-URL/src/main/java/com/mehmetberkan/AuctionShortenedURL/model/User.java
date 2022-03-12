package com.mehmetberkan.AuctionShortenedURL.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 15, message = "Username length must be between 3-15")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 5, max = 15, message = "Password length must be between 5-15")
    private String password;

    @OneToMany(mappedBy = "user",
               cascade = CascadeType.ALL)
    private List<Url> urls = new ArrayList<>();

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

    public void addUrl(Url url){
        this.urls.add(url);
    }
}
