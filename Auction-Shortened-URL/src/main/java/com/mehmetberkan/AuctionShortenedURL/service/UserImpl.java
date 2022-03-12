package com.mehmetberkan.AuctionShortenedURL.service;

import com.mehmetberkan.AuctionShortenedURL.convert.UserToUserDto;
import com.mehmetberkan.AuctionShortenedURL.dto.UserDto;
import com.mehmetberkan.AuctionShortenedURL.model.User;
import com.mehmetberkan.AuctionShortenedURL.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService{

    private final UserRepository userRepository;
    private final UserToUserDto userToUserDto;

    public UserImpl(UserRepository userRepository, UserToUserDto userToUserDto){
        this.userRepository = userRepository;
        this.userToUserDto = userToUserDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userToUserDto::convert).collect(Collectors.toList());
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
