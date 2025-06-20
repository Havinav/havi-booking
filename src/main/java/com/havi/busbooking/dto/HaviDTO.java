package com.havi.busbooking.dto;

import java.time.LocalDateTime;
import java.util.List;

public class HaviDTO {

	   private List<String> busIds;

	    private List<String> seatsIds;

	    private LocalDateTime tripDate;

		public List<String> getBusIds() {
			return busIds;
		}

		public void setBusIds(List<String> busIds) {
			this.busIds = busIds;
		}

		public List<String> getSeatsIds() {
			return seatsIds;
		}

		public void setSeatsIds(List<String> seatsIds) {
			this.seatsIds = seatsIds;
		}

		public LocalDateTime getTripDate() {
			return tripDate;
		}

		public void setTripDate(LocalDateTime tripDate) {
			this.tripDate = tripDate;
		}
	    
}
