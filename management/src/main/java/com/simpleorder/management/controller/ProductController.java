package com.simpleorder.management.controller;

import com.simpleorder.management.model.Product;
import com.simpleorder.management.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ProductController.class);
    @Autowired
    ProductService productService;

    @PostMapping(value = "/create")
    public void createProduct(@RequestBody Product product){
        LOGGER.info("in the product create method {}",product);
        productService.createOrder(product);
    }

    @GetMapping(value = "/getAllProducts")
    public List<Product> getAllProduct(){
        LOGGER.info("Getting prodcuts");
       return productService.getAllProducts();
    }
    @PostMapping(value = "/getAllOrdersWithIds")
    public List<Product> getOrderBasedOnIds(@RequestBody List<Integer> ids){
        System.out.println("ids "+ids);
        return productService.getOrderBasedOnIds(ids);
    }
}
