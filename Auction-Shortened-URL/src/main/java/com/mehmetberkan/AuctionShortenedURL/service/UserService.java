package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int userId);
    User addUser(User user);
    User updateUser(int userId, User user);
    String deleteUser(int userId);
}
