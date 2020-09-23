package com.simpleorder.management.controller;

import com.simpleorder.management.model.User;
import com.simpleorder.management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userServiceImpl;

    @PostMapping(value = "/create")
    public ResponseEntity createUser(@RequestBody User user) {
        LOGGER.info("Create new User {}", user);
        userServiceImpl.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/getuser/{id}")
    public List<User> getUser(@PathVariable Long id ) {
        LOGGER.info("Getting User Details{}",id);
        return userServiceImpl.getUser(id);
    }
}
