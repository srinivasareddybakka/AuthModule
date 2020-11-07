package com.simpleorder.management.controller;

import com.simpleorder.management.model.Address;
import com.simpleorder.management.model.Order;
import com.simpleorder.management.model.User;
import com.simpleorder.management.repository.UserRepository;
import com.simpleorder.management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userServiceImpl;
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/create")
    public ResponseEntity createUser(@RequestBody User user) {
        LOGGER.info("Create new User {}", user);
        Order order = new Order();
        Address address = new Address("Banglore", 560100);
        user.getOrderList().add(order);
        user.setAddress(address);
        userServiceImpl.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/getuser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        LOGGER.info("Getting User: Details {}",id);
        return userServiceImpl.getUser(id).get();
    }

    @DeleteMapping(value = "/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        LOGGER.info("Deleting user details {}", id);
        userServiceImpl.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



   
}
