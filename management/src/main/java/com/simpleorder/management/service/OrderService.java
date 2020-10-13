
package com.simpleorder.management.service;

import com.simpleorder.management.model.Order;
import com.simpleorder.management.model.User;
import com.simpleorder.management.repository.OrderRepository;
import com.simpleorder.management.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderService {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;


    public void createOrder(Order order) {

        Optional<User> user = userRepository.findById((long) 1);
        if(user.isPresent()){
            user.get().getOrderList().add(order);
            LOGGER.info("Order details {}", order);
            userRepository.save(user.get());
        }

    }

}

