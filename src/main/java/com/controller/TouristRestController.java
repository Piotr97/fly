package com.controller;

import com.model.dto.request.AddFlightTouristDto;
import com.model.entity.Tourist;
import com.service.TouristService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TouristRestController {

    private TouristService touristService;

    public TouristRestController(TouristService touristService) {
        this.touristService = touristService;
    }


    @GetMapping("/api/tourist")
    public List<Tourist> getTurists() {
        return touristService.getAllTourist();
    }

    @GetMapping("/api/tourist/{id}")
    public Tourist getTuristById(@PathVariable long id) {
        return touristService.getTouristById(id);
    }

    @PostMapping("/api/tourist")
    public Tourist createTurist(@RequestBody Tourist tourist) {
        return touristService.addTourist(tourist);
    }

    @PostMapping("/api/tourist/add-flight")
    public Tourist addFlightToTourist(@RequestBody AddFlightTouristDto addFlightTouristDto) {
        return touristService.addFlight(addFlightTouristDto);
    }

    @PutMapping("/api/tourist/{id}")
    public Tourist updateTurist(@PathVariable long id, @RequestBody Tourist tourist) {
        return touristService.updateTourist(id, tourist);
    }

    @DeleteMapping("/api/tourist/{id}")
    public ResponseEntity<?> deleteTurist(@PathVariable long id) {
        return touristService.deleteTourist(id);
    }

}
