package com.mehmetberkan.AuctionShortenedURL.repository;

import com.mehmetberkan.AuctionShortenedURL.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
