package com.mehmetberkan.AuctionShortenedURL.controller;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.service.UrlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UrlControllerTest {

    @Mock
    UrlService urlService;

    UrlController urlController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        urlController = new UrlController(urlService);
    }

    @Test
    void createUrl() {
        User user = new User();
        user.setUserId(1);
        String url = "Test";

        when(urlService.createUrl(user.getUserId(),url)).thenReturn(new Url(1,"Test","Test",user));

        Url result = urlService.createUrl(1,"Test");
        assertEquals("Test",result.getUrl());
    }

    @Test
    void getAllUrls() {
        User user = new User();
        Url url = new Url("Test","Test1",user);
        Url url1 = new Url("Test","Test1",user);
        List<Url> urlList = new ArrayList<>();
        urlList.add(url);
        urlList.add(url1);

        when(urlService.getAllUrls()).thenReturn(urlList);

        ResponseEntity<List<Url>> result = urlController.getAllUrls();
        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void getByUrlId() {
        int urlId = 1;
        User user = new User();

        when(urlService.getByUrlId(urlId)).thenReturn(new Url(1,"Test","Test",user));

        ResponseEntity<Url> url = urlController.getByUrlId(1);
        assertEquals(200,url.getStatusCodeValue());
    }

    @Test
    void redirect() {
        String shortenedUrl = "Test";
        String originalUrl = "OTest";

        when(urlService.getOriginalUrl(shortenedUrl)).thenReturn(originalUrl);

        ResponseEntity<Void> result = urlController.redirect("Test");
        HttpStatus status = HttpStatus.MOVED_PERMANENTLY;
        assertEquals(status,result.getStatusCode());
    }

    @Test
    void deleteUrl() {
        int urlId = 1;

        when(urlService.deleteUrl(urlId)).thenReturn("Successfully");

        ResponseEntity<String> result = urlController.deleteUrl(1);
        assertEquals(200, result.getStatusCodeValue());
    }
}
