package com.mehmetberkan.AuctionShortenedURL.config;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.repository.UrlRepository;
import com.mehmetberkan.AuctionShortenedURL.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UrlRepository urlRepository;

    public LoadData(UserRepository userRepository, UrlRepository urlRepository) {
        this.userRepository = userRepository;
        this.urlRepository = urlRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Url url =new Url();
        url.setUrl("http://merhaba.com");
        url.setShortenedUrl("http://deneme");

        User user=new User();
        user.setUsername("berkan");
        user.setPassword("berkan");
        user.addUrl(url);
        url.setUser(user);

        userRepository.save(user);


    }
}
