package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
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

class UrlImplTest {

    UrlImpl urlImpl;

    @Mock
    UrlRepository urlRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        urlImpl = new UrlImpl(urlRepository);
    }

    @Test
    void getAllUrls() {
        List<Url> urlList = new ArrayList<>();
        urlList.add(new Url("Test","Test",2));

        when(urlRepository.findAll()).thenReturn(urlList);

        List<Url> result = urlImpl.getAllUrls();
        assertEquals(1,result.size());
    }

    @Test
    void getByUrlId() {
        Url url = new Url();
        url.setUrlId(1);

        when(urlRepository.findById(1)).thenReturn(Optional.of(url));

        Url result = urlImpl.getByUrlId(1);
        assertEquals(1, result.getUrlId());
    }

    @Test
    void getAllByUserId() {
        List<Url> urlList = new ArrayList<>();
        urlList.add(new Url("Test","Test",2));

        when(urlRepository.findAllByUserId(2)).thenReturn(urlList);

        List<Url> result = urlImpl.getAllByUserId(2);
        assertEquals(1, result.size());
    }

    @Test
    void createUrl() {
        Url url = new Url("Test","Test2",1);
        when(urlRepository.save(url)).thenReturn(url);
        Url result = urlImpl.createUrl(1,"Test");
        assertEquals(1,result.getUserId());
    }
}
