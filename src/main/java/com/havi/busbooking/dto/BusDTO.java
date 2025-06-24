package com.havi.busbooking.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BusDTO {

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

	private String amenities;

	private LocalDateTime busStartDate;
	private LocalDateTime busEndDate;
	private LocalDateTime tripDate;
	private List<SeatDTO> seatsDTOList;

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

	public List<SeatDTO> getSeatsDTOList() {
		return seatsDTOList;
	}

	public void setSeatsDTOList(List<SeatDTO> seatsDTOList) {
		this.seatsDTOList = seatsDTOList;
	}

}
