package com.controller.Dto;

import com.model.dto.FlightDTO;
import com.model.dto.response.FlightSeatsInfoDTO;
import com.service.Dto.FlightServiceDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/flight")
public class FlightController {
    private FlightServiceDto flightServiceDto;

    public FlightController(FlightServiceDto flightServiceDto) {
        this.flightServiceDto = flightServiceDto;
    }

    @GetMapping("/all")
    public List<FlightDTO> getFlight() {
        return flightServiceDto.allFlights();
    }

    @PostMapping("/add")
    public FlightDTO addFlight(@RequestBody FlightDTO flightDTO) {
        return flightServiceDto.createFlight(flightDTO);
    }

    @GetMapping("/{flightUUID}/seats-info")
    public FlightSeatsInfoDTO seatsInfo(@PathVariable String flightUUID){
        return flightServiceDto.seatsInfo(flightUUID);
    }
}
