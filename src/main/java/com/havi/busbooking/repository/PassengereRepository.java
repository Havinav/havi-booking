package com.havi.busbooking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.havi.busbooking.model.Passenger;

import java.util.List;


public interface PassengereRepository extends JpaRepository<Passenger, Integer> {

    @Query("select p from Passenger p where p.userId = ?1")
    List<Passenger> findByUserId(Integer id);
}
