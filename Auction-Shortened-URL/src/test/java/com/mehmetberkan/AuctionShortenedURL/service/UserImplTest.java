package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class UserImplTest {

    UserImpl userImpl;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        userImpl = new UserImpl(userRepository);
    }

    @Test
    void getAllUsers() {
        List<User> userList = new ArrayList<>();
        List<Url> urlList = new ArrayList<>();
        userList.add(new User("Test","Test",urlList));
        when(userRepository.findAll()).thenReturn(userList);
        List<User> result = userImpl.getAllUsers();
        assertEquals(1,result.size());
    }

    @Test
    void addUser() {
        List<Url> urlList = new ArrayList<>();
        User user = new User(1,"Test","Test",urlList);
        when(userRepository.save(user)).thenReturn(user);
        User user1 = userImpl.addUser(user);
        assertEquals(1,user1.getUserId());
    }
}
