package com.simpleorder.management.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String product_name;
    private String product_desc;
    private Double price;
    private String product_image;

    public Product(){}
    public Product(String product_name, String product_desc, Double price, String product_image) {
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.price = price;
        this.product_image = product_image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", product_desc='" + product_desc + '\'' +
                ", price='" + price + '\'' +
                ", product_image='" + product_image + '\'' +
                '}';
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

}
