package com.controller.Dto;

import com.model.BuyStatus;
import com.model.dto.FlightDTO;
import com.model.dto.ReservationDTO;
import com.model.dto.TouristDTO;
import com.model.dto.request.AddFlightTouristDto;
import com.model.entity.Tourist;
import com.service.Dto.TouristServiceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/tourist")
public class TouristController {
    private TouristServiceDto touristServiceDto;

    public TouristController(TouristServiceDto touristServiceDto) {
        this.touristServiceDto = touristServiceDto;
    }

    @GetMapping("/all")
    public List<TouristDTO> getTourists() {
        return touristServiceDto.getTourist();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTourist(@RequestBody TouristDTO touristDTO) {
        TouristDTO result = touristServiceDto.addTourist(touristDTO);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PostMapping("/add/tourist-flight")
    public void addTouristFlight(@RequestBody AddFlightTouristDto addFlightTouristDto,
                                 @RequestParam(value = "reservation") BuyStatus buyStatus) {
        touristServiceDto.addTouristFlight(addFlightTouristDto, buyStatus);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTourist(@PathVariable long id) {
        touristServiceDto.deleteTourist(id);
        return new ResponseEntity<>("Delete tourist by id:" + id, HttpStatus.OK);
    }

    @PostMapping(value = "/reservation", consumes = "application/json")
    public List<Tourist> addReservation(@RequestBody ReservationDTO reservationDTO) {
        touristServiceDto.touristReservation(reservationDTO.getTransactionUUID());
        return touristServiceDto.touristReservation(reservationDTO.getTransactionUUID());
    }
}
