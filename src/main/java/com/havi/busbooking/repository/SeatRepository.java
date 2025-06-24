package com.havi.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.havi.busbooking.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	
}
