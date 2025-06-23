package com.havi.busbooking.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busName;
    private String busNo;
    private String busType;
    private String source;
    private String destination;
    private String startTime;
    private String endTime;
    private String arrivalTime;
    private Double price;
    private String rating;

  
    private List<String> amenities;

    private LocalDateTime busStartDate;
    private LocalDateTime busEndDate;
    private LocalDateTime tripDate;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Seat> seats = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBusName() { return busName; }
    public void setBusName(String busName) { this.busName = busName; }
    public String getBusNo() { return busNo; }
    public void setBusNo(String busNo) { this.busNo = busNo; }
    public String getBusType() { return busType; }
    public void setBusType(String busType) { this.busType = busType; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
    public List<String> getAmenities() { return amenities; }
    public void setAmenities(List<String> amenities) { this.amenities = amenities; }
    public LocalDateTime getBusStartDate() { return busStartDate; }
    public void setBusStartDate(LocalDateTime busStartDate) { this.busStartDate = busStartDate; }
    public LocalDateTime getBusEndDate() { return busEndDate; }
    public void setBusEndDate(LocalDateTime busEndDate) { this.busEndDate = busEndDate; }
    public LocalDateTime getTripDate() { return tripDate; }
    public void setTripDate(LocalDateTime tripDate) { this.tripDate = tripDate; }
    public List<Seat> getSeats() { return seats; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(getId(), bus.getId()) && Objects.equals(getBusName(), bus.getBusName()) && Objects.equals(getBusNo(), bus.getBusNo()) && Objects.equals(getBusType(), bus.getBusType()) && Objects.equals(getSource(), bus.getSource()) && Objects.equals(getDestination(), bus.getDestination()) && Objects.equals(getStartTime(), bus.getStartTime()) && Objects.equals(getEndTime(), bus.getEndTime()) && Objects.equals(getArrivalTime(), bus.getArrivalTime()) && Objects.equals(getPrice(), bus.getPrice()) && Objects.equals(getRating(), bus.getRating()) && Objects.equals(getAmenities(), bus.getAmenities()) && Objects.equals(getBusStartDate(), bus.getBusStartDate()) && Objects.equals(getBusEndDate(), bus.getBusEndDate()) && Objects.equals(getTripDate(), bus.getTripDate()) && Objects.equals(getSeats(), bus.getSeats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBusName(), getBusNo(), getBusType(), getSource(), getDestination(), getStartTime(), getEndTime(), getArrivalTime(), getPrice(), getRating(), getAmenities(), getBusStartDate(), getBusEndDate(), getTripDate(), getSeats());
    }

    // Prevent replacing the seats collection
    public void setSeats(List<Seat> seats) {
        this.seats.clear();
        if (seats != null) {
            seats.forEach(this::addSeat);
        }
    }

    // Helper methods to manage bidirectional relationship
    public void addSeat(Seat seat) {
        if (seat != null && !seats.contains(seat)) {
            seats.add(seat);
            seat.setBus(this);
        }
    }

    public void removeSeat(Seat seat) {
        if (seat != null && seats.contains(seat)) {
            seats.remove(seat);
            seat.setBus(null);
        }
    }

    public void clearSeats() {
        new ArrayList<>(seats).forEach(this::removeSeat);
    }
}
