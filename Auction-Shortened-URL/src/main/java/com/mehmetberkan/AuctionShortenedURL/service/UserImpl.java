package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getById(userId);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int userId, User dtoUser) {
        User user = dtoUser;
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(int userId) {
        try{
            userRepository.deleteById(userId);
            return "Successfully deleted";
        }catch (Exception e){
            return "Unsuccessful ( " + e.getMessage() + " )";
        }
    }
}
