package com.havi.busbooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.havi.busbooking.model.Bus;

public interface BusRepository extends JpaRepository<Bus,Long> {

    @Query("SELECT b FROM Bus b WHERE b.source LIKE %:source% AND b.destination LIKE %:destination%")
    List<Bus> findBySourceAndDestination(String source, String destination);

    @Query("SELECT b FROM Bus b WHERE b.id IN :busIds")
    List<Bus> findBusByIds(List<Long> busIds);
}
