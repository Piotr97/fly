package com.controller;

import com.model.dto.request.AddFlightTouristDto;
import com.model.entity.Flight;
import com.model.entity.Tourist;
import com.service.FlyService;
import com.service.TouristService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FlyRestController {

    private FlyService flyService;

    public FlyRestController(FlyService flyService) {
        this.flyService = flyService;
    }

    @GetMapping("/api/fly")
    public List<Flight> getFlights() {
        return flyService.getAllFlight();
    }

    @GetMapping("/api/fly/{id}")
    public Flight getFlyById(@PathVariable long id) {
        return flyService.updateFlightById(id);
    }

    @PostMapping("/api/fly")
    public Flight createFlight(@RequestBody Flight flight) {
        return flyService.addFlight(flight);
    }

    @PutMapping("/api/fly/{id}")
    public Flight updateFlight(@PathVariable long id, @RequestBody Flight flight) {
        return flyService.updateFlight(flight, id);
    }

    @DeleteMapping("/api/fly/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable long id) {
        return flyService.deleteFlight(id);
    }
}
