package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlImpl implements UrlService {

    private UrlRepository urlRepository;

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
        Url url = urlRepository.findAllByUrlAndUserId(originalUrl,userId).get();
        return url.getShortenedUrl();
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

        String urlShort = String.valueOf(userId).hashCode()+""+ url.hashCode();
        return urlShort;
    }
}
