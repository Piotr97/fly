package com.mapper;

import com.model.dto.FlightDTO;
import com.model.entity.Flight;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Component
public class FlightMapper{
/*
    @Override
*/
    public static FlightDTO map(Flight from) {
       FlightDTO flightDTO = new FlightDTO();
       flightDTO.setFlyStart(from.getFlyStart());
       flightDTO.setFlyEnd(from.getFlyEnd());
       flightDTO.setNumberOfSeats(from.getNumberOfSeats());
       flightDTO.setPriceTicket(from.getPriceTicket());
       return flightDTO;
    }

    /*@Override*/
    public static Flight map(FlightDTO to) {
        Flight flight = new Flight();
        flight.setFlightId(UUID.randomUUID().toString());
        flight.setFlyStart(to.getFlyStart());
        flight.setFlyEnd(to.getFlyEnd());
        flight.setNumberOfSeats(to.getNumberOfSeats());
        flight.setPriceTicket(to.getPriceTicket());
        List<Integer> seatsPlaces = new ArrayList<>();
        IntStream.rangeClosed(1, to.numberOfSeats).forEach(seatsPlaces::add);
        flight.setSeatingPlaces(seatsPlaces);
        return flight;
    }

}
