package com.havi.busbooking.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bus_name", nullable = false)
    private String busName;

    @Column(name = "bus_no", nullable = false, unique = true)
    private String busNo;

    @Column(name = "bus_type", nullable = false)
    private String busType;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name = "arrival_time", nullable = false)
    private String arrivalTime;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "rating")
    private String rating;

   
    @Column(name = "amenity")
    private String amenities;

    @Column(name = "bus_start_date")
    private LocalDateTime busStartDate;

    @Column(name = "bus_end_date")
    private LocalDateTime busEndDate;

    @Column(name = "trip_date")
    private LocalDateTime tripDate;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();

    // Constructors
    public Bus() {}

    public Bus(String busName, String busNo, String busType, String source, String destination,
               String startTime, String endTime, String arrivalTime, Double price, String rating,
              String amenities, LocalDateTime busStartDate, LocalDateTime busEndDate, LocalDateTime tripDate) {
        this.busName = busName;
        this.busNo = busNo;
        this.busType = busType;
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
        this.endTime = endTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.rating = rating;
        this.amenities = amenities;
        this.busStartDate = busStartDate;
        this.busEndDate = busEndDate;
        this.tripDate = tripDate;
    }

    // Helper method to maintain bidirectional relationship
    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setBus(this);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public LocalDateTime getBusStartDate() {
        return busStartDate;
    }

    public void setBusStartDate(LocalDateTime busStartDate) {
        this.busStartDate = busStartDate;
    }

    public LocalDateTime getBusEndDate() {
        return busEndDate;
    }

    public void setBusEndDate(LocalDateTime busEndDate) {
        this.busEndDate = busEndDate;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}