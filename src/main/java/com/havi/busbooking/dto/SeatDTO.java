package com.havi.busbooking.dto;

public class SeatDTO {

	private String id;
    private String seatId;
    private String status;
    
    
    
	public SeatDTO(String id, String seatId, String status) {
		super();
		this.id = id;
		this.seatId = seatId;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
    
    
}
