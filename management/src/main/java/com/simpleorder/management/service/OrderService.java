
package com.simpleorder.management.service;

import com.simpleorder.management.model.Order;
import com.simpleorder.management.model.Product;
import com.simpleorder.management.model.User;
import com.simpleorder.management.repository.OrderRepository;
import com.simpleorder.management.repository.ProductRepository;
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
    @Autowired
    ProductRepository productRepository;

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
        Optional<User> user = userRepository.findById((long) 1);
        System.out.println("user " + user.get());
        if (user.isPresent()) {

            Order order = new Order();
            List<Product> products = new ArrayList<Product>();

            obj.forEach(item -> {
                System.out.println("in the iterate " + item);
//                Product p=new Product((Integer) item);
                Optional<Product> p = productRepository.findById((Integer) item);
                products.add(p.get());
            });
            double totalAmount = products.stream().mapToDouble(Product::getPrice).sum();

            order.setProduct(products);
            order.setOrder_status("SUCCESS");
            order.setTotal_amount(totalAmount);

            user.get().getOrderList().add(order);
            System.out.println(" user after orders are added " + user);
            userRepository.save(user.get());
        }

    }
}

