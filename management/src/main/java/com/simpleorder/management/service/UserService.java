package com.simpleorder.management.service;

import com.simpleorder.management.controller.UserController;
import com.simpleorder.management.model.User;
import com.simpleorder.management.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    private static final Logger LOGGER=  LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;


    @Autowired
    UserLoginRepository userLoginRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {

        return userRepository.findById(id);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User userSignUp(User user) {
        return userRepository.save(user);
    }

    public User findByUserName(String userName) {
        return userLoginRepository.findByUserName(userName);
    }

    public User loginCheck(User user) {
        User resultUser=userLoginRepository.findByUserName(user.getUserName());
        LOGGER.info("User data from db {}",resultUser);
        return resultUser;

    }
}
