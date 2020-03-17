package com.service.Dto;

import com.mapper.FlightMapper;
import com.model.BuyStatus;
import com.model.dto.FlightDTO;
import com.model.dto.response.FlightSeatsInfoDTO;
import com.model.entity.Flight;
import com.repository.FlyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FlightServiceDto {
    private static final Logger logger = LoggerFactory.getLogger(TouristServiceDto.class);
    private FlightMapper flightMapper;
    private FlyRepository flyRepository;

    public FlightServiceDto(FlightMapper flightMapper, FlyRepository flyRepository) {
        this.flightMapper = flightMapper;
        this.flyRepository = flyRepository;
    }

    public List<FlightDTO> allFlights() {
        List<FlightDTO> flightDTOS = new ArrayList<>();
        List<Flight> flights = flyRepository.findAll();
        flights.forEach(t -> {
            flightDTOS.add(FlightMapper.map(t));
        });
        return flightDTOS;
    }

    public FlightDTO createFlight(FlightDTO flightDTO) {
        Flight flight = FlightMapper.map(flightDTO);
        flight.setFlyStart(new Date());
        flight.setFlyEnd(new Date());
        Flight result = flyRepository.save(flight);
        if (result == null) {
            logger.error("Error while save flight to data base!");
            throw new RuntimeException();
        }
        return flightDTO;
    }

    public FlightSeatsInfoDTO seatsInfo(String flightUUID) {
        Flight flight = flyRepository.findFlightByFlightId(flightUUID)
                .orElseThrow(RuntimeException::new);
        FlightSeatsInfoDTO flightSeatsInfoDTO = new FlightSeatsInfoDTO();
        flightSeatsInfoDTO.setFreeSeatsAmount(freeSeatsAmount(flight));
        flightSeatsInfoDTO.setPurchasedSeatsAmount(purchasedSeatsAmount(flight));
        flightSeatsInfoDTO.setReservationSeatsAmount(reservationSeatsAmount(flight));
        flightSeatsInfoDTO.setSeatsAmount(seatsAmount(flight));
        return flightSeatsInfoDTO;
    }

    private int seatsAmount(Flight flight) {
        return flight.getNumberOfSeats();
    }

    private int reservationSeatsAmount(Flight flight) {
        return (int) flight.getReservation().stream().filter(s -> s.getBuyStatus()
                .equals(BuyStatus.RESERVATION))
                .count();
    }

    private int purchasedSeatsAmount(Flight flight) {
        return (int) flight.getReservation().stream().filter(s -> s.getBuyStatus()
                .equals(BuyStatus.PURCHASED))
                .count();
    }

    private int freeSeatsAmount(Flight flight) {
        int seatsAmount = seatsAmount(flight);
        int busySeatsAmount = purchasedSeatsAmount(flight) + reservationSeatsAmount(flight);
        return seatsAmount - busySeatsAmount;
    }

    private void addTouristToFlight(Flight flight){
        flyRepository.findFlightByFlightId(flight.getId().toString());
    }
}
