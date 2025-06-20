package com.havi.busbooking.util;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.havi.busbooking.dto.SeatDTO;

@Component
public class BusUtil {

	private final Set<SeatDTO> seatDTOSet = new LinkedHashSet<>();

	public void initSeatDTOList() {

		seatDTOSet.add(new SeatDTO("1", "B1", "Available"));
		seatDTOSet.add(new SeatDTO("2", "B3", "Available"));
		seatDTOSet.add(new SeatDTO("3", "B5", "Available"));
		seatDTOSet.add(new SeatDTO("4", "B7", "Available"));
		seatDTOSet.add(new SeatDTO("5", "B9", "Available"));
		seatDTOSet.add(new SeatDTO("6", "B11", "Available"));

		seatDTOSet.add(new SeatDTO("7", "B2", "Available"));
		seatDTOSet.add(new SeatDTO("8", "B4", "Available"));
		seatDTOSet.add(new SeatDTO("9", "B6", "Available"));
		seatDTOSet.add(new SeatDTO("10", "B8", "Available"));
		seatDTOSet.add(new SeatDTO("11", "B10", "Available"));
		seatDTOSet.add(new SeatDTO("12", "B12", "Available"));

		seatDTOSet.add(new SeatDTO("13", "A1", "Available"));
		seatDTOSet.add(new SeatDTO("14", "A2", "Available"));
		seatDTOSet.add(new SeatDTO("15", "A3", "Available"));
		seatDTOSet.add(new SeatDTO("16", "A4", "Available"));
		seatDTOSet.add(new SeatDTO("17", "A5", "Available"));
		seatDTOSet.add(new SeatDTO("18", "A6", "Available"));

	}

	public Set<SeatDTO> getSeatDTOList() {
		initSeatDTOList();
		return seatDTOSet;
	}

}
