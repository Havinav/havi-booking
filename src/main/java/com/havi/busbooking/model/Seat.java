package com.havi.busbooking.model;

<<<<<<< HEAD

import jakarta.persistence.Column;
=======
>>>>>>> 25e017cedb7c893c4c4de5571df215836756b255
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
<<<<<<< HEAD

=======
>>>>>>> 25e017cedb7c893c4c4de5571df215836756b255
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "seat_id", nullable = false)
    private String seatId;

    @Column(name = "status", nullable = false)
    private String status;
=======
    private String seatId;
    private String status;
    private String passengerName;
>>>>>>> 25e017cedb7c893c4c4de5571df215836756b255

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

<<<<<<< HEAD
    // Constructors
    public Seat() {}

    public Seat(String seatId, String status, Bus bus) {
        this.seatId = seatId;
        this.status = status;
        this.bus = bus;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
=======
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSeatId() { return seatId; }
    public void setSeatId(String seatId) { this.seatId = seatId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    public Bus getBus() { return bus; }
    public void setBus(Bus bus) { this.bus = bus; }
>>>>>>> 25e017cedb7c893c4c4de5571df215836756b255


}