package com.havi.busbooking.controller;

import com.havi.busbooking.dto.HaviDTO;
import com.havi.busbooking.dto.PassengerDTO;
import com.havi.busbooking.service.PassengerService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/passenger")
public class PassengerController {

    private final PassengerService passengerService;


    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<?> addPassenger(@RequestBody HaviDTO haviDTO) {

        return ResponseEntity.ok(passengerService.addPassenger(haviDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPassenger(@PathVariable Integer id) {

        List<PassengerDTO> passengerDTO = passengerService.getPassenger(id);
        if (!passengerDTO.isEmpty()) {
            return ResponseEntity.ok(passengerDTO);
        }
        return ResponseEntity.notFound().build();

    }
}
