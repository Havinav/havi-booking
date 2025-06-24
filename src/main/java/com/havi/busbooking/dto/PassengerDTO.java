package com.havi.busbooking.dto;

import java.time.LocalDateTime;

public class PassengerDTO {

    private Integer id;

    private Integer busId;

    private String seatId;

    private String name;

    private Integer age;

    private String gender;

    private String jouneryStatus;

    private String bookingId;

    private String source;

    private String destination;

    private LocalDateTime tripDate;

    private Integer paymentId;

    private String paymentStatus;

    private  double price;
    
    private BusDTO busDTO;

    public Integer getId() {
        return id;
    }

    public PassengerDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getBusId() {
        return busId;
    }

    public PassengerDTO setBusId(Integer busId) {
        this.busId = busId;
        return this;
    }

    public String getSeatId() {
        return seatId;
    }

    public PassengerDTO setSeatId(String seatId) {
        this.seatId = seatId;
        return this;
    }

    public String getName() {
        return name;
    }

    public PassengerDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public PassengerDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PassengerDTO setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getJouneryStatus() {
        return jouneryStatus;
    }

    public PassengerDTO setJouneryStatus(String jouneryStatus) {
        this.jouneryStatus = jouneryStatus;
        return this;
    }

    public String getBookingId() {
        return bookingId;
    }

    public PassengerDTO setBookingId(String bookingId) {
        this.bookingId = bookingId;
        return this;
    }

    public String getSource() {
        return source;
    }

    public PassengerDTO setSource(String source) {
        this.source = source;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public PassengerDTO setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public PassengerDTO setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
        return this;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public PassengerDTO setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public PassengerDTO setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public PassengerDTO setPrice(double price) {
        this.price = price;
        return this;
    }

	public BusDTO getBusDTO() {
		return busDTO;
	}

	public void setBusDTO(BusDTO busDTO) {
		this.busDTO = busDTO;
	}
    
}
