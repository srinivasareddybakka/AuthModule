package com.simpleorder.management.repository;

import com.simpleorder.management.model.Order;
import com.simpleorder.management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByIdIn(List<Integer> userList);

}
