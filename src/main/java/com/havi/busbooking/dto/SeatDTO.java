package com.havi.busbooking.dto;

public class SeatDTO {

	private Long id;
    private String seatId;
    private String status;
    
    
    
	public SeatDTO(String id, String seatId, String status) {
		super();
		this.id = Long.parseLong(id);
		this.seatId = seatId;
		this.status = status;
	}
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
    
    
}
