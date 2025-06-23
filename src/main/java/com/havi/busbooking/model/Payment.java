package com.havi.busbooking.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String cardNumber;

    private String expiry;

    private String cvv;

    private Integer userId;

    private Double totalPrice;

    private LocalDateTime paymentDate;

    private String paymentStatus;

    public Integer getId() {
        return id;
    }

    public Payment setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Payment setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Payment setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getExpiry() {
        return expiry;
    }

    public Payment setExpiry(String expiry) {
        this.expiry = expiry;
        return this;
    }

    public String getCvv() {
        return cvv;
    }

    public Payment setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Payment setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Payment setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public Payment setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public Payment setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }
}
