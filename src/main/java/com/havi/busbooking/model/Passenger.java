package com.havi.busbooking.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "passenger")
public class Passenger {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer busId;

    private String seatId;

    private String name;

    private Integer age;

    private String gender;

    private Integer userId;

    private String bookingId;

    private Integer paymentId;

    private String paymentStatus;

    private String jouneryStatus;

    private String source;

    private String destination;

    private LocalDateTime tripDate;

    private  double price;

    public Integer getId() {
        return id;
    }

    public Passenger setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getBusId() {
        return busId;
    }

    public Passenger setBusId(Integer busId) {
        this.busId = busId;
        return this;
    }

    public String getSeatId() {
        return seatId;
    }

    public Passenger setSeatId(String seatId) {
        this.seatId = seatId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Passenger setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Passenger setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Passenger setGender(String gender) {
        this.gender = gender;
        return this;
    }
    public Integer getUserId() {
        return userId;
    }
    public Passenger setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Passenger setBookingId(String bookingId) {
        this.bookingId = bookingId;
        return this;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public Passenger setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Passenger setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public String getJouneryStatus() {
        return jouneryStatus;
    }

    public Passenger setJouneryStatus(String jouneryStatus) {
        this.jouneryStatus = jouneryStatus;
        return this;
    }

    public String getSource() {
        return source;
    }

    public Passenger setSource(String source) {
        this.source = source;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public Passenger setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public Passenger setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Passenger setPrice(double price) {
        this.price = price;
        return this;
    }
}

