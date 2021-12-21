package com.mehmetberkan.AuctionShortenedURL.controller;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping("/createUrl")
    public Url createUrl(@RequestParam("userId") int userId, @RequestParam("url") String url) {
        return urlService.createUrl(userId,url);
    }

    @GetMapping("/getAllUrls")
    public List<Url> getAllUrls() {
        return urlService.getAllUrls();
    }

    @GetMapping("/getByUrlId")
    public Url getByUrlId(@RequestParam("urlId") int urlId) {
        return urlService.getByUrlId(urlId);
    }

    @GetMapping("/getAllByUserId")
    public List<Url> getAllByUser(@RequestParam("userId") int userId) {
        return urlService.getAllByUserId(userId);
    }

    @GetMapping("/getShortenedUrl")
    public String getShortedenUrl(@RequestParam("userId") int userId, @RequestParam("originalUrl") String originalUrl) {
        return urlService.getShortenedUrl(userId,originalUrl);
    }

    @GetMapping("/{redirectUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String redirectUrl){
        String url = urlService.getOriginalUrl(redirectUrl);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create(url)).build();
    }

    @DeleteMapping("/deleteUrl")
    public String deleteUrl(@RequestParam("urlId") int urlId) {
        return urlService.deleteUrl(urlId);
    }
}
