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
import com.havi.busbooking.repository.SeatRepository;
import com.havi.busbooking.util.BusUtil;

import jakarta.transaction.Transactional;

@Service
public class BusService {

	private BusRepository busRepository;

	private SeatRepository seatRepository;

	private BusUtil busUtil;

	public BusService(BusRepository busRepository, SeatRepository seatRepository, BusUtil busUtil) {
		this.busRepository = busRepository;
		this.seatRepository = seatRepository;
		this.busUtil = busUtil;
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

			bus.setSource(source);
			bus.setDestination(destination);
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
				bus.clearSeats();
				busDTO.setSeatsDTOList(new ArrayList<>(seatMap.values()));
				busDTOList.add(busDTO);
				seatMap.clear();
			} else {
				Map<String, SeatDTO> seatMap = getSeatMap();
				bus.clearSeats();
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

	public String bookSeat(HaviDTO haviDTO) {

		List<Bus> busList = busRepository.findBusByIds(haviDTO.getBusIds());

		busList.forEach(bus -> {
			bus.clearSeats();
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
