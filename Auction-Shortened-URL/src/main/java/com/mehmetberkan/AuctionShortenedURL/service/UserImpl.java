package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService{

    private final UserRepository userRepository;

    public UserImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
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
