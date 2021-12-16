package com.mehmetberkan.AuctionShortenedURL.repository;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Integer> {
    List<Url> findAllByUserId(int userId);
    Url findAllByShortenedUrlAndUserId(String shortenedUrl, int userId);
    Optional<Url> findAllByUrlAndUserId(String url, int userId);
}
