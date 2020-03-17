package com.service.Dto;

import com.mapper.TouristMapper;
import com.model.BuyStatus;
import com.model.dto.TouristDTO;
import com.model.dto.request.AddFlightTouristDto;
import com.model.entity.Flight;
import com.model.entity.Reservation;
import com.model.entity.Tourist;
import com.repository.FlyRepository;
import com.repository.ReservationRepository;
import com.repository.TouristRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristServiceDto {
    private static final Logger logger = LoggerFactory.getLogger(TouristServiceDto.class);
    private TouristRepository touristRepository;
    private TouristMapper touristMapper;
    private FlyRepository flyRepository;
    private ReservationRepository reservationRepository;

    public TouristServiceDto(TouristRepository touristRepository, TouristMapper touristMapper, FlyRepository flyRepository, ReservationRepository reservationRepository) {
        this.touristRepository = touristRepository;
        this.touristMapper = touristMapper;
        this.flyRepository = flyRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<TouristDTO> getTourist() {
        List<TouristDTO> touristDTOS = new ArrayList<>();
        touristRepository.findAll().forEach(t -> {
            touristDTOS.add(touristMapper.map(t));
        });
        return touristDTOS;
    }

    public TouristDTO addTourist(TouristDTO touristDTO) {
        Tourist tourist = new Tourist();
        tourist.setName(touristDTO.getName());
        tourist.setLastName(touristDTO.getLastName());
        tourist.setCountry(touristDTO.getCountry());
        tourist.setNote(touristDTO.getCountry());
        tourist.setGender(touristDTO.getGender());
        tourist.setDateOfBirth(touristDTO.getDateOfBirth());
        Tourist result = touristRepository.save(tourist);
        if (result == null) {
            logger.error("Error while save tourist to data base!");
            return null;
        }
        return touristMapper.map(tourist);
    }

    public void addTouristFlight(AddFlightTouristDto addFlightTouristDto, BuyStatus buyStatus) {
        Flight flight = flyRepository.findFlightByFlightId(addFlightTouristDto.getFlightUUID()).get();
        Tourist tourist = touristRepository.findTouristById(addFlightTouristDto.getTouristId()).get();
        Reservation reservation = new Reservation();
        reservation.setBuyStatus(buyStatus);
        reservation.setTourist(tourist);
        int freeSeat = flight.getSeatingPlaces().stream().findAny().get();
        reservation.setSeatPlace(freeSeat);
        flight.getSeatingPlaces().removeIf(t -> t.equals(freeSeat));
        reservationRepository.saveAndFlush(reservation);
        flight.getReservation().add(reservation);
        flyRepository.save(flight);

    }

    public void deleteTourist(long id) {
        touristRepository.deleteById(id);
    }

    public List<Tourist> touristReservation(String transactionUUID) {
        List<Tourist> reservation = new ArrayList<>();
        reservationRepository.findAllByTransactionUUID(transactionUUID).forEach(r -> {
            reservation.add(r.getTourist());
        });
        return reservation;

    }

}
