package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.repository.UrlRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

class UrlImplTest {

    UrlImpl urlImpl;

    @Mock
    UrlRepository urlRepository;
    UserImpl userImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        urlImpl = new UrlImpl(urlRepository,userImpl);
    }

    @Test
    void getAllUrls() {
        User user = new User();
        Url url = new Url("Test","Test1",user);
        Url url1 = new Url("Test","Test1",user);
        List<Url> urlList = new ArrayList<>();
        urlList.add(url);
        urlList.add(url1);

        when(urlRepository.findAll()).thenReturn(urlList);

        List<Url> result = urlImpl.getAllUrls();
        assertEquals(2, result.size());
    }

    @Test
    void getByUrlId() {
        User user = new User();
        Url url = new Url(1,"Test","Test",user);

        when(urlRepository.findById(any())).thenReturn(Optional.of(url));

        Url result = urlImpl.getByUrlId(1);
        assertEquals("Test",result.getUrl());
    }

    @Test
    void getAllByUserId() {
        User user = new User();
        user.setUserId(1);
        Url url = new Url(1,"Test","Test",user);
        Url url1 = new Url(2,"Test","Test",user);
        List<Url> urlList = new ArrayList<>();
        urlList.add(url);
        urlList.add(url1);

        when(urlRepository.findAllByUser_UserId(user.getUserId())).thenReturn(urlList);

        List<Url> result = urlImpl.getAllByUserId(1);
        assertEquals(2, result.size());
    }

    @Test
    void getOriginalUrl() {
        User user = new User();
        String shortenedUrl = "Test";
        String originalUrl = "OTest";
        Url url = new Url(1,originalUrl,shortenedUrl,user);

        when(urlRepository.findAllByShortenedUrl(shortenedUrl)).thenReturn(url);

        String result = urlImpl.getOriginalUrl("Test");
        assertEquals("OTest",result);
    }

    @Test
    void getShortenedUrl() {
        User user = new User();
        user.setUserId(1);
        String originalUrl = "OTest";
        Url url = new Url(originalUrl,"ShortenedUrl",user);

        when(urlRepository.findAllByUrlAndUser_UserId(originalUrl,user.getUserId())).thenReturn(Optional.of(url));

        String shortUrl = urlImpl.getShortenedUrl(1,"OTest");
        String expected = "http://localhost:8080/api/url/ShortenedUrl";
        assertEquals(expected,shortUrl);
    }

    @Test
    void createUrl() {
        User user = new User();
        user.setUserId(1);
        String urlOriginal = "Test";
        Url url = new Url(1,"Test","Test",user);

        when(urlRepository.findAllByUrlAndUser_UserId(urlOriginal,user.getUserId())).thenReturn(Optional.of(url));
        when(urlRepository.save(any())).thenReturn(url);

        Url result = urlImpl.createUrl(1,"Test");
        assertEquals("Test",result.getShortenedUrl());
    }
}
