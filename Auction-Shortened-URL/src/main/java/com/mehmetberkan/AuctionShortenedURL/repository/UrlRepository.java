package com.mehmetberkan.AuctionShortenedURL.repository;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Integer> {
    List<Url> findAllByUser_UserId(int user_Id);
    Url findAllByShortenedUrl(String shortenedUrl);
    Optional<Url> findAllByUrlAndUser_UserId(String url, int user_Id);
}
