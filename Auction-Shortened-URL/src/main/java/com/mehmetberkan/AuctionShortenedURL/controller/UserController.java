package com.mehmetberkan.AuctionShortenedURL.controller;

import com.mehmetberkan.AuctionShortenedURL.dto.UserDto;
import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.service.UrlService;
import com.mehmetberkan.AuctionShortenedURL.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UrlService urlService;

    public UserController(UserService userService, UrlService urlService){
        this.userService = userService;
        this.urlService = urlService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserId(@PathVariable int userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/{userId}/{originalUrl}")
    public ResponseEntity<String> getShortedenUrl(@PathVariable int userId, @PathVariable String originalUrl) {
        return ResponseEntity.ok(urlService.getShortenedUrl(userId,originalUrl));
    }

    @GetMapping("/{userId}/urls")
    public ResponseEntity<List<Url>> getAllUrls(@PathVariable int userId) {
        return ResponseEntity.ok(urlService.getAllByUserId(userId));
    }
}
