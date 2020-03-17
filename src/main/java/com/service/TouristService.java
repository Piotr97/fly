package com.service;

import com.exception.ResourceNotFoundException;
import com.model.dto.request.AddFlightTouristDto;
import com.model.entity.Flight;
import com.model.entity.Tourist;
import com.repository.FlyRepository;
import com.repository.TouristRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TouristService {
    private TouristRepository touristRepository;
    private FlyRepository flyRepository;

    public TouristService(TouristRepository touristRepository, FlyRepository flyRepository) {
        this.touristRepository = touristRepository;
        this.flyRepository = flyRepository;
    }

    public List<Tourist> getAllTourist() {
        return touristRepository.findAll();
    }

    public Tourist addTourist(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    public Tourist getTouristById(long id) {
        return touristRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("turist by id: " + id + " not found"));
    }

    public Tourist updateTourist(long id, Tourist tourist) {
        return touristRepository.findById(id).map(t -> {
            t.setName(tourist.getName());
            t.setLastName(tourist.getLastName());
            t.setGender(tourist.getGender());
            t.setDateOfBirth(tourist.getDateOfBirth());
            t.setCountry(tourist.getCountry());
            t.setNote(tourist.getNote());
            return touristRepository.save(t);
        }).orElseThrow(() -> new ResourceNotFoundException("turist by id: " + id + " not found"));
    }

    public ResponseEntity<?> deleteTourist(long id) {
        return touristRepository.findById(id).map(t -> {
            touristRepository.delete(t);
            return new ResponseEntity<>("turist " + id + " was delete", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("turist by id: " + id + " not found"));
    }

    public Tourist addFlight(AddFlightTouristDto addFlightTouristDto) {
        Flight flight = flyRepository.findFlightByFlightId(addFlightTouristDto.getFlightUUID()).orElseThrow(() -> new RuntimeException());
        Tourist tourist = touristRepository.findTouristById(addFlightTouristDto.getTouristId()).orElseThrow(() -> new RuntimeException());
        /*List<Tourist> touristList = flight.
        Set<Flight> flyList = tourist.getFlyList();
        flyList.add(flight);
        tourist.setFlyList(flyList);*/
       /* Set<Tourist> turistList = flight.getTouristList();
        turistList.add(tourist);
        flight.setTouristList(turistList);*/
        flyRepository.save(flight);
        return touristRepository.save(tourist);
    }

}
