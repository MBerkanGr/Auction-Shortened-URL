package com.mehmetberkan.AuctionShortenedURL.controller;

import com.mehmetberkan.AuctionShortenedURL.model.Url;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    UserService userService;

    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
    }

    @Test
    void getAllUsers() {
        List<Url> urlList = new ArrayList<>();
        User user = new User("Test","Test",urlList);
        User user1 = new User("Test2","Test2",urlList);
        List<User> userList = List.of(user,user1);

        when(userService.getAllUsers()).thenReturn(userList);

        List<User> users = userService.getAllUsers();
        assertEquals(2,users.size());
    }

    @Test
    void addUser() {
        List<Url> urlList = new ArrayList<>();
        User user = new User("Test","Test",urlList);
        when(userService.addUser(user)).thenReturn(user);
        User user1 = userService.addUser(user);
        assertEquals("Test",user1.getPassword());
    }

}
