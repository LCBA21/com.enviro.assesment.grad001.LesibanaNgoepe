package com.example.investorassessment.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class WithdrawalNotice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @DecimalMin (value = "0.01")
    private BigDecimal withdrawalAmount;


    private Date startDate;

    private Date endDate;


    private String bankingDetails;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    public WithdrawalNotice() {
    }

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public String getBankingDetails() {
        return bankingDetails;
    }

    public void setBankingDetails(String bankingDetails) {
        this.bankingDetails = bankingDetails;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public WithdrawalNotice(Long noticeId, BigDecimal withdrawalAmount,
                            Date startDate, Date endDate,
                            String bankingDetails, Product product) {
        this.noticeId = noticeId;
        this.withdrawalAmount = withdrawalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bankingDetails = bankingDetails;
        this.product = product;
    }
}
