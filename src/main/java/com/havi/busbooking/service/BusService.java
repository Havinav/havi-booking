package com.havi.busbooking.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.havi.busbooking.dto.BusDTO;
import com.havi.busbooking.dto.HaviDTO;
import com.havi.busbooking.dto.SeatDTO;
import com.havi.busbooking.model.Bus;
import com.havi.busbooking.model.Seat;
import com.havi.busbooking.repository.BusRepository;
import com.havi.busbooking.util.BusUtil;

@Service
public class BusService {

	private BusRepository busRepository;

	private MongoTemplate mongoTemplate;

	private BusUtil busUtil;

	public BusService(BusRepository busRepository, BusUtil busUtil, MongoTemplate mongoTemplate) {
		this.busRepository = busRepository;
		this.busUtil = busUtil;
		this.mongoTemplate = mongoTemplate;
	}

	@Transactional
	public void addBus(BusDTO busDTO) {
		Bus bus = new Bus();
		busDTO.setSource(busDTO.getSource().trim().toLowerCase());
		busDTO.setDestination(busDTO.getDestination().trim().toLowerCase());

		BeanUtils.copyProperties(busDTO, bus);

		busRepository.save(bus);
	}

	public List<BusDTO> getBusInfo(String source, String destination, LocalDateTime tripDate) {
		List<BusDTO> busDTOList = new ArrayList<>();

		List<Bus> busList = getBuesWithSourceDestination(source, destination, null);

		busList.forEach(bus -> {
			BusDTO busDTO = new BusDTO();

			bus.setSource(source.substring(0, 1).toUpperCase() + source.substring(1));
			bus.setDestination(destination.substring(0, 1).toUpperCase() + destination.substring(1));
			bus.setBusStartDate(tripDate);
			bus.setBusEndDate(tripDate.plusDays(1));
			BeanUtils.copyProperties(bus, busDTO);

			if (Objects.nonNull(bus.getTripDate()) && bus.getTripDate().isEqual(tripDate)) {
				Map<String, SeatDTO> seatMap = getSeatMap();
				bus.getSeats().forEach(seat -> {

					SeatDTO seatDTO = seatMap.get(seat.getSeatId());
					if (Objects.nonNull(seatDTO)) {
						seatDTO.setStatus(seat.getStatus());
						seatMap.put(seatDTO.getSeatId(), seatDTO);
					}
				});
				// bus.clearSeats();
				busDTO.setSeatsDTOList(new ArrayList<>(seatMap.values()));
				busDTOList.add(busDTO);
				seatMap.clear();
			} else {
				Map<String, SeatDTO> seatMap = getSeatMap();
				// bus.clearSeats();
				busDTO.setSeatsDTOList(new ArrayList<>(seatMap.values()));

				busDTOList.add(busDTO);
			}
		});

		return busDTOList;
	}

	private Map<String, SeatDTO> getSeatMap() {
		Map<String, SeatDTO> seatsMap = new LinkedHashMap<>();
		busUtil.getSeatDTOList().forEach(seatDTO -> {
			seatsMap.put(seatDTO.getSeatId(), seatDTO);
		});
		return seatsMap;

	}

	private List<Bus> getBuesWithSourceDestination(String source, String destination,List<String> busIds) {

		Query query = new Query();

		if(source != null && destination != null) {
			query.addCriteria(new Criteria().orOperator(
					Criteria.where("source").regex(".*" + source.toLowerCase().trim() + ".*", "i"),
					Criteria.where("destination").regex(".*" + destination.toLowerCase().trim() + ".*", "i"))

			);
		}else if (!busIds.isEmpty()) {
			new Criteria();
			query.addCriteria(
              Criteria.where("id").in(busIds));
		} 

		return mongoTemplate.find(query, Bus.class);

	}

	public String bookSeat(HaviDTO haviDTO) {

		List<Bus> busList = getBuesWithSourceDestination(null, null, haviDTO.getBusIds());

		busList.forEach(bus -> {

			List<Seat> seatList = new ArrayList<>();

			busUtil.getSeatDTOList().forEach(seatDTO -> {
				if (haviDTO.getSeatsIds().contains(seatDTO.getSeatId())) {
					Seat seat = new Seat();
					seat.setSeatId(seatDTO.getSeatId());
					seat.setStatus("Booked");
					seat.setBus(bus);
					seatList.add(seat);
				}
			});
			bus.setSeats(seatList);
			bus.setTripDate(haviDTO.getTripDate());
			busRepository.save(bus);

		});

		return "Seats booking successfully";
	}


}
