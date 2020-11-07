package com.simpleorder.management.controller;

import com.simpleorder.management.model.User;
import com.simpleorder.management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    UserService userService;

    @PostMapping(value = "/signgup")
    public ResponseEntity signup(@RequestBody User user) {
        LOGGER.info("AuthController signup {}", user);
        userService.userSignUp(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/getUsers")
    public User getUserDetails(@RequestBody User user) {
        LOGGER.info("AuthController signup {}", user);
        return userService.findByUserName(user.getUserName());
    }
@PostMapping(value="/loginCheck")
    public User loginCheck(@RequestBody User user){
        LOGGER.info("user data {}",user);
        return userService.loginCheck(user);
    }


}
