package com.havi.busbooking.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "buses")
public class Bus {

	@Id
	private String id;

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

   
    private List<Seat> seats = new ArrayList<>();


	public String getId() {
		return id;
	}


	public void setId(String id) {
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


	public List<String> getAmenities() {
		return amenities;
	}


	public void setAmenities(List<String> amenities) {
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
