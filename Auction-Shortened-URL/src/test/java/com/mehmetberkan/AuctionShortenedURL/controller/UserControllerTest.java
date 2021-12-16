package com.mehmetberkan.AuctionShortenedURL.controller;

import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        User user = new User(1,"Test","Test");
        User user1 = new User(2,"Test","Test");
        List<User> userList = List.of(user,user1);

        when(userService.getAllUsers()).thenReturn(userList);

        List<User> users = userService.getAllUsers();
        assertEquals(2,users.size());
    }

    @Test
    void addUser() {
        User user = new User(1,"Test","Test");
        when(userService.addUser(user)).thenReturn(user);
        User user1 = userService.addUser(user);
        assertEquals("Test",user1.getPassword());
    }
}
