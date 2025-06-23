package com.havi.busbooking.dto;

import java.time.LocalDateTime;
import java.util.List;

public class HaviDTO {

	private List<Long> busIds;

	private List<String> seatsIds;

	private List<PassengerDTO> passengers;

	private Integer userId;

	private LocalDateTime tripDate;

	private Integer paymentId;

	private String paymentStatus;

	private double price;

	public List<Long> getBusIds() {
		return busIds;
	}

	public void setBusIds(List<Long> busIds) {
		this.busIds = busIds;
	}

	public List<String> getSeatsIds() {
		return seatsIds;
	}

	public void setSeatsIds(List<String> seatsIds) {
		this.seatsIds = seatsIds;
	}

	public List<PassengerDTO> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerDTO> passengers) {
		this.passengers = passengers;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDateTime tripDate) {
		this.tripDate = tripDate;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
