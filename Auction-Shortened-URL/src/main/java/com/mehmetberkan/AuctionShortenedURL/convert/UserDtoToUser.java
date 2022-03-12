package com.mehmetberkan.AuctionShortenedURL.convert;

import com.mehmetberkan.AuctionShortenedURL.dto.UserDto;
import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoToUser {
    private final UrlDtoToUrl urlDtoToUrl;

    public UserDtoToUser(UrlDtoToUrl urlDtoToUrl) {
        this.urlDtoToUrl = urlDtoToUrl;
    }

    public User convert(UserDto userDto){
        User user=new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        if(userDto.getUrls()!=null){
            userDto.getUrls().forEach(url->{
                user.getUrls()
                        .add(urlDtoToUrl.convert(url));
            });
        }
        return user;
    }
}
