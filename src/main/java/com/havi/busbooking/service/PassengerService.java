package com.havi.busbooking.service;



import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.havi.busbooking.dto.HaviDTO;
import com.havi.busbooking.dto.PassengerDTO;
import com.havi.busbooking.model.Passenger;
import com.havi.busbooking.repository.PassengereRepository;

@Service
public class PassengerService {

    private final PassengereRepository passengereRepository;


   
    public PassengerService(PassengereRepository passengereRepository) {
        this.passengereRepository = passengereRepository;
     
    }

    public  String addPassenger(HaviDTO haviDTO) {
          try{
              UUID uuid = UUID.randomUUID();
        haviDTO.getPassengers().forEach(passengerDTO -> {


            Passenger passenger = new Passenger();
            passenger.setBookingId(uuid.toString());
            passenger.setBusId(passengerDTO.getBusId());
            passenger.setSeatId(passengerDTO.getSeatId());
            passenger.setName(passengerDTO.getName());
            passenger.setAge(passengerDTO.getAge());
            passenger.setGender(passengerDTO.getGender());
            passenger.setUserId(haviDTO.getUserId());
            passenger.setPaymentId(haviDTO.getPaymentId());
            passenger.setPaymentStatus(haviDTO.getPaymentStatus());
            passenger.setJouneryStatus("WAITING");
            passenger.setTripDate(haviDTO.getTripDate());
            passenger.setSource(passengerDTO.getSource());
            passenger.setDestination(passengerDTO.getDestination());
            passenger.setPrice(haviDTO.getPrice());
            passengereRepository.save(passenger);
        });

          } catch (Exception e) {
              throw new RuntimeException(e);
          }
          return "Passenger added successfully";
    }


    public List<PassengerDTO> getPassenger(Integer id) {
        List<Passenger> passengerList = passengereRepository.findByUserId(id);

        return passengerList.stream().map(passenger -> {
            PassengerDTO passengerDTO = new PassengerDTO();
            BeanUtils.copyProperties(passenger, passengerDTO);
            return passengerDTO;
        }).toList();
    }


}
