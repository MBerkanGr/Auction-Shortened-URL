package com.mehmetberkan.AuctionShortenedURL.convert;

import com.mehmetberkan.AuctionShortenedURL.dto.UrlDto;
import com.mehmetberkan.AuctionShortenedURL.dto.UserDto;
import com.mehmetberkan.AuctionShortenedURL.model.Url;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UrlToUrlDto {

    public UrlDto convert(Url url){
        UrlDto result=new UrlDto();
        result.setUrlId(url.getUrlId());
        result.setUrl(url.getUrl());
        result.setShortenedUrl(url.getShortenedUrl());
        if(url.getUser()!=null){
            UserDto userDto=new UserDto();
            userDto.setUserId(url.getUser().getUserId());
            userDto.setUsername(url.getUser().getUsername());
            userDto.setPassword(url.getUser().getPassword());
            result.setUser(userDto);
            userDto.addUrl(result);
        }
        return result;
    }
}
