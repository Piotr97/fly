package com.service;

import com.exception.ResourceNotFoundException;
import com.model.entity.Flight;
import com.repository.FlyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlyService {

    private FlyRepository flyRepository;

    public FlyService(FlyRepository flyRepository) {
        this.flyRepository = flyRepository;
    }

    public List<Flight> getAllFlight() {
        return flyRepository.findAll();
    }

    public Flight addFlight(Flight flight) {
        flight.setFlightId(UUID.randomUUID().toString());
        return flyRepository.save(flight);
    }

    public Flight updateFlightById(long id){
        return flyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("fly by id: " + id + " not found"));
    }

    public Flight updateFlight(Flight flight, long id) {
        return flyRepository.findById(id).map(f -> {
            f.setPriceTicket(flight.getPriceTicket());
            /*f.setTouristList(flight.getTouristList());*/
            f.setReservation(flight.getReservation());
            f.setNumberOfSeats(flight.getNumberOfSeats());
            f.setFlyStart(flight.getFlyStart());
            f.setFlyEnd(flight.getFlyEnd());
            return flyRepository.save(f);
        }).orElseThrow(() -> new ResourceNotFoundException("fly by id: " + id + " not found"));
    }

    public ResponseEntity<?> deleteFlight(long id) {
        return flyRepository.findById(id).map(f -> {
            flyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("fly by id: " + id + " not found"));
    }
}
