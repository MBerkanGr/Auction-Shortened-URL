package com.mehmetberkan.AuctionShortenedURL.convert;

import com.mehmetberkan.AuctionShortenedURL.dto.UrlDto;
import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import org.springframework.stereotype.Component;

@Component
public class UrlDtoToUrl {

    public Url convert(UrlDto urlDto) {
        Url url = new Url();
        url.setUrl(urlDto.getUrl());
        url.setShortenedUrl(urlDto.getShortenedUrl());
        url.setUrlId(urlDto.getUrlId());

        if(urlDto.getUser()!=null){
            /** TODO:
             * kullanıcıyı UserDtoToUser ile dönüştürmek yerine
             * burada yeni bir nesne oluşturup onun üzerinden convert işlemini tamamlıyoruz.
             */
            User user=new User();
            user.setUserId(urlDto.getUser().getUserId());
            user.setUsername(urlDto.getUser().getUsername());
            user.setPassword(urlDto.getUser().getPassword());
            url.setUser(user);
            user.addUrl(url);
        }
        return url;
    }
}
