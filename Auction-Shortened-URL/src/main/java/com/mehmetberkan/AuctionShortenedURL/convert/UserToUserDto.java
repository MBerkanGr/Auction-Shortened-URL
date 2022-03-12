package com.mehmetberkan.AuctionShortenedURL.convert;

import com.mehmetberkan.AuctionShortenedURL.dto.UrlDto;
import com.mehmetberkan.AuctionShortenedURL.dto.UserDto;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToUserDto {
    private final UrlToUrlDto urlToUrlDto;

    public UserToUserDto(UrlToUrlDto urlToUrlDto) {
        this.urlToUrlDto = urlToUrlDto;
    }


    public UserDto convert(User user) {
        UserDto userDto=new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        if(user.getUrls()!=null){
            List<UrlDto> urlDtos= user
                    .getUrls()
                    .stream()
                    .map(urlToUrlDto::convert)
                    .collect(Collectors.toList());
            userDto.setUrls(urlDtos);
        }
        return userDto;
    }
}
