package com.simpleorder.management.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String product_Name;

    private double product_Price;



      @OneToMany(fetch = FetchType.LAZY)
   @JoinColumn(name = "product_id",referencedColumnName = "id")
    private List<Product> Product;



    public Order() {
    }
    public List<com.simpleorder.management.model.Product> getProduct() {
        return Product;
    }

    public void setProduct(List<com.simpleorder.management.model.Product> product) {
        Product = product;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
