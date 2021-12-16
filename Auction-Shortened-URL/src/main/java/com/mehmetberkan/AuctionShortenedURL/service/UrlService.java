package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.Url;

import java.util.List;
import java.util.Optional;

public interface UrlService {
    List<Url> getAllUrls();
    Url getByUrlId(int urlId);
    List<Url> getAllByUserId(int userId);
    String getOriginalUrl(String shortUrl);
    String getShortenedUrl(int userId, String originalUrl);
    Url createUrl(int userId, String url);
    String deleteUrl(int urlId);
}
