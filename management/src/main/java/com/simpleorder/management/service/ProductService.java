package com.simpleorder.management.service;

import com.simpleorder.management.model.Order;
import com.simpleorder.management.model.Product;
import com.simpleorder.management.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ProductService {

    private static final Logger LOGGER= LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductRepository productRepository;

    public void createOrder(Product product){
        LOGGER.info("In the create order service {}",product);
        productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsBasedOnIds(List<Integer> ids){
        return  productRepository.findByIdIn(ids);
    }
}
