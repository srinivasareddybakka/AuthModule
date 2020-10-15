package com.simpleorder.management.repository;

import com.simpleorder.management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByIdIn(List<Integer> userList);
}

