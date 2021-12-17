package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.repository.UrlRepository;
import com.mehmetberkan.AuctionShortenedURL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlImpl implements UrlService {

    private String Url8080 = "http://localhost:8080/api/url/";

    private UrlRepository urlRepository;
    private UserRepository userRepository;

    @Autowired
    private UserImpl userImpl = new UserImpl(userRepository);

    @Autowired
    public UrlImpl(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    @Override
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    @Override
    public Url getByUrlId(int urlId) {
        return urlRepository.findById(urlId).get();
    }

    @Override
    public List<Url> getAllByUserId(int userId) {
        return urlRepository.findAllByUserId(userId);
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        Url url = urlRepository.findAllByShortenedUrl(shortUrl);
        return url.getUrl();
    }

    @Override
    public String getShortenedUrl(int userId, String originalUrl) {
        Url shortenedUrl = urlRepository.findAllByUrlAndUserId(originalUrl,userId).get();
        String url = Url8080 + shortenedUrl.getShortenedUrl();
        return url;
    }

    @Override
    public Url createUrl(int userId, String url) {
        Optional<Url> controlUrl = urlRepository.findAllByUrlAndUserId(url,userId);

        if(controlUrl.isEmpty()){
            String createdUrl = builderUrl(userId,url);
            Url creatUrl = new Url(url,createdUrl,userId);
            urlRepository.save(creatUrl);
            return creatUrl;
        }
        return controlUrl.get();
    }

    @Override
    public String deleteUrl(int urlId) {
        try{
            urlRepository.deleteById(urlId);
            return "Successfully deleted";
        }catch (Exception e){
            return "Unsuccessful ( " + e.getMessage() + " )";
        }
    }

    private String builderUrl(int userId,String url){
        User s = userImpl.getUserById(userId);

        String urlShort = url.hashCode()+s.getUsername().hashCode()+s.getPassword().hashCode()+"1";
        System.out.println(urlShort);
        return urlShort;
    }
}
