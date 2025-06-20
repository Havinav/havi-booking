package com.havi.busbooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.havi.busbooking.model.Bus;

public interface BusRepository extends MongoRepository<Bus, String> {

	

}
