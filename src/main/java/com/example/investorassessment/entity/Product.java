package com.example.investorassessment.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

//    private Long inv_id;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    private String name;

    private BigDecimal currentBalance;


    @OneToMany(mappedBy = "product")
    private List<WithdrawalNotice> withdrawalNotices;


    public Product() {
    }


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;


    public Product(ProductType type, String name, BigDecimal currentBalance, List<WithdrawalNotice> withdrawalNotices, Investor investor) {
        this.type = type;
        this.name = name;
        this.currentBalance = currentBalance;
        this.withdrawalNotices = withdrawalNotices;
        this.investor = investor;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<WithdrawalNotice> getWithdrawalNotices() {
        return withdrawalNotices;
    }

    public void setWithdrawalNotices(List<WithdrawalNotice> withdrawalNotices) {
        this.withdrawalNotices = withdrawalNotices;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
