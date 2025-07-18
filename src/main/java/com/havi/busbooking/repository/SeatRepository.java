package com.havi.busbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.havi.busbooking.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query("SELECT s FROM Seat s WHERE s.bus = :id")
	Optional<List<Seat>> findByBusId(Long busId);
}
