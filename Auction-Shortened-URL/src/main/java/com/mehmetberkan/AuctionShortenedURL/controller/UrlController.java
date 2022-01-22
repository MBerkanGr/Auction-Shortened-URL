package com.mehmetberkan.AuctionShortenedURL.controller;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<Url> createUrl(@RequestParam("userId") int userId, @RequestParam("url") String url) {
        return ResponseEntity.ok(urlService.createUrl(userId,url));
    }

    @GetMapping
    public ResponseEntity<List<Url>> getAllUrls() {
        return ResponseEntity.ok(urlService.getAllUrls());
    }

    @GetMapping("/{urlId}")
    public ResponseEntity<Url> getByUrlId(@PathVariable int urlId) {
        return ResponseEntity.ok(urlService.getByUrlId(urlId));
    }

    @GetMapping("/redirect/{redirectUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String redirectUrl){
        String url = urlService.getOriginalUrl(redirectUrl);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create(url)).build();
    }

    @DeleteMapping("/{urlId}")
    public ResponseEntity<String> deleteUrl(@PathVariable int urlId) {
        return ResponseEntity.ok(urlService.deleteUrl(urlId));
    }
}
