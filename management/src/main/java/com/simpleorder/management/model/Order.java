package com.simpleorder.management.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "orders")
public class Order implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String product_id;


    private String product_Name;


    private double product_Price;

    public Order() {
    }

    public Order(String product_Name) {
        this.product_Name = product_Name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public double getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(double product_Price) {
        this.product_Price = product_Price;
    }

}
