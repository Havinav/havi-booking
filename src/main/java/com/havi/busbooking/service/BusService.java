package com.havi.busbooking.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.havi.busbooking.dto.BusDTO;
import com.havi.busbooking.dto.HaviDTO;
import com.havi.busbooking.dto.SeatDTO;
import com.havi.busbooking.model.Bus;
import com.havi.busbooking.model.Seat;
import com.havi.busbooking.repository.BusRepository;

import jakarta.transaction.Transactional;

@Service
public class BusService {

	private BusRepository busRepository;


	public BusService(BusRepository busRepository) {
		this.busRepository = busRepository;
	}

	@Transactional
	public void addBus(List<BusDTO> busDTO) {

		List<Bus> busList = new ArrayList<>();

		busDTO.forEach(bus -> {
			Bus busModel = new Bus();
			BeanUtils.copyProperties(bus, busModel);
			busModel.setSource(bus.getSource().trim().toLowerCase());
			busModel.setDestination(bus.getDestination().trim().toLowerCase());

			busList.add(busModel);
		});

		busRepository.saveAll(busList);

	}

	public List<BusDTO> getBusInfo(String source, String destination, LocalDateTime tripDate) {
		List<BusDTO> busDTOList = new ArrayList<>();

		List<Bus> busList = busRepository.findBySourceAndDestination(source.trim().toLowerCase(),
				destination.trim().toLowerCase());

		busList.forEach(bus -> {

			BusDTO busDTO = new BusDTO();
			BeanUtils.copyProperties(bus, busDTO);
			busDTO.setTripDate(tripDate);
			busDTO.setSource(source);
			busDTO.setDestination(destination);

			if (Objects.nonNull(bus.getTripDate()) && bus.getTripDate().isEqual(tripDate)) {
				Map<String, SeatDTO> seatMap = getSeatDTOMap();
				bus.getSeats().forEach(seat -> {
					SeatDTO seatDTO = seatMap.get(seat.getSeatId());
					if (Objects.nonNull(seatDTO)) {
						seatDTO.setStatus(seat.getStatus());
						seatMap.put(seatDTO.getSeatId(), seatDTO);
					}

				});
				busDTO.setSeatsDTOList(new ArrayList<>(seatMap.values()));
				busDTOList.add(busDTO);
				seatMap.clear();
			} else {
				busDTO.setSeatsDTOList(new ArrayList<>(getSeatDTOMap().values()));
				busDTOList.add(busDTO);
			}

		});

		return busDTOList;
	}

	public String bookSeat(HaviDTO haviDTO) {

		List<Bus> busList = busRepository.findBusByIds(haviDTO.getBusIds());
		List<Seat> seatList = new ArrayList<>();

		busList.forEach(bus -> {

			haviDTO.getSeatsIds().forEach(seatId -> {
				SeatDTO seat = getSeatDTOMap().get(seatId);
				if (Objects.nonNull(seat)) {
					Seat seatModel = new Seat();
					seatModel.setSeatId(seat.getSeatId());
					seatModel.setStatus("Booked");
					seatModel.setBus(bus);

					seatList.add(seatModel);
				}
			});
     
			bus.setSeats(seatList);
			bus.setTripDate(haviDTO.getTripDate());
			busRepository.save(bus);

		});

		return "Seats booking successfully";
	}

	private Map<String, SeatDTO> getSeatDTOMap() {

		Map<String, SeatDTO> seatDTOMap = new LinkedHashMap<>();

		seatDTOMap.put("B1", new SeatDTO("1", "B1", "Available"));
		seatDTOMap.put("B3", new SeatDTO("2", "B3", "Available"));
		seatDTOMap.put("B5", new SeatDTO("3", "B5", "Available"));
		seatDTOMap.put("B7", new SeatDTO("4", "B7", "Available"));
		seatDTOMap.put("B9", new SeatDTO("5", "B9", "Available"));
		seatDTOMap.put("B11", new SeatDTO("6", "B11", "Available"));

		seatDTOMap.put("B2", new SeatDTO("7", "B2", "Available"));
		seatDTOMap.put("B4", new SeatDTO("8", "B4", "Available"));
		seatDTOMap.put("B6", new SeatDTO("9", "B6", "Available"));
		seatDTOMap.put("B8", new SeatDTO("10", "B8", "Available"));
		seatDTOMap.put("B10", new SeatDTO("11", "B10", "Available"));
		seatDTOMap.put("B12", new SeatDTO("12", "B12", "Available"));

		seatDTOMap.put("A1", new SeatDTO("13", "A1", "Available"));
		seatDTOMap.put("A2", new SeatDTO("14", "A2", "Available"));
		seatDTOMap.put("A3", new SeatDTO("15", "A3", "Available"));
		seatDTOMap.put("A4", new SeatDTO("16", "A4", "Available"));
		seatDTOMap.put("A5", new SeatDTO("17", "A5", "Available"));
		seatDTOMap.put("A6", new SeatDTO("18", "A6", "Available"));

		return seatDTOMap;
	}

}
