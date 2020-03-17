package com.repository;

import com.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlyRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findFlightByFlightId(String flightId);
}
