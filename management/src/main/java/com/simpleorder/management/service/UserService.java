package com.simpleorder.management.service;

import com.simpleorder.management.model.User;
import com.simpleorder.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;


    @Autowired
    UserLoginRespository userLoginRespository;


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
        return userLoginRespository.findByUserName(userName);
    }

}
