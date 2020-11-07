package com.simpleorder.management.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private int pincode;

   // @OneToOne(mappedBy = "address")
    private User user;

    public Address() {
    }

    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
