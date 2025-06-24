package com.havi.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.havi.busbooking.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	
=======
import org.springframework.data.jpa.repository.Query;

import com.havi.busbooking.model.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query("SELECT s FROM Seat s WHERE s.bus = :id")
	Optional<List<Seat>> findByBusId(Long busId);
>>>>>>> 25e017cedb7c893c4c4de5571df215836756b255
}
