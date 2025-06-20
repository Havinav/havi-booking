package com.havi.busbooking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havi.busbooking.dto.BusDTO;
import com.havi.busbooking.dto.HaviDTO;
import com.havi.busbooking.service.BusService;

@RestController
@RequestMapping("/v1/bus")
public class BusController {

	private BusService busService;

	public BusController(BusService busService) {
		this.busService = busService;
	}

	@PostMapping
	public ResponseEntity<?> addBus(@RequestBody BusDTO busDTO) {
		busService.addBus(busDTO);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/busesinfo")
	public ResponseEntity<?> getBusInfo(@RequestBody BusDTO busDTO) {
		return ResponseEntity
				.ok(busService.getBusInfo(busDTO.getSource(), busDTO.getDestination(), busDTO.getTripDate()));
	}

	@PostMapping("/bookSeat")
	public ResponseEntity<?> bookSeat(@RequestBody HaviDTO haviDTO) {
		return ResponseEntity.ok(busService.bookSeat(haviDTO));
	}
}
