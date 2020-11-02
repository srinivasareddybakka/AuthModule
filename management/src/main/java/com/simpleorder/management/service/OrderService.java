
package com.simpleorder.management.service;

import com.simpleorder.management.model.Order;
import com.simpleorder.management.model.Product;
import com.simpleorder.management.model.User;
import com.simpleorder.management.repository.OrderRepository;
import com.simpleorder.management.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
        if (user.isPresent()) {
            user.get().getOrderList().add(order);
            LOGGER.info("Order details {}", order);
            userRepository.save(user.get());
        }

    }

    public List<Order> getOrderBasedOnIds(List<Integer> ids) {
        return orderRepository.findByIdIn(ids);
    }

    public void insertOrders(List obj) {
        System.out.println("obj " + obj);
        Optional<User> user = userRepository.findById((long) 34);
        System.out.println("user "+user.get());
        if (user.isPresent()) {

            List<Order> orders=new ArrayList<Order>();
            obj.forEach(item->{
                System.out.println("in the iterate "+item);
                Product p=new Product((Integer) item);
                Order o=new Order();
                o.setProduct(p);
                orders.add(o);
            });
            System.out.println("orders "+orders);
            user.get().getOrderList().addAll(orders);
            System.out.println(" user after orders are added "+user);
            userRepository.save(user.get());
        }

    }
}

