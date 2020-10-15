
package com.simpleorder.management.controller;

import com.simpleorder.management.model.Order;
import com.simpleorder.management.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping(value = "/orders")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);


    @Autowired
    OrderService orderService;

    @PostMapping(value = "/create")
    public ResponseEntity createrOrder(@RequestBody Order order) {
        LOGGER.info("Order Details {}", order);
        orderService.createOrder(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/getAllOrdersWithIds")
    public List<Order> getOrderBasedOnIds(@RequestBody List<Integer> ids){
        System.out.println("ids "+ids);
        return orderService.getOrderBasedOnIds(ids);
    }


}

