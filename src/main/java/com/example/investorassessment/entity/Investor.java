package com.example.investorassessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Investor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investorId;

    private String firstName;

    private String lastName;


    private String email;


    private String address;

    private  Integer Age;

    public Investor() {
    }

    public Investor(Long investorId, String firstName, String lastName,
                    String email, String address, Integer age, List<Product> products) {
        this.investorId = investorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        Age = age;
        this.products = products;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
}
