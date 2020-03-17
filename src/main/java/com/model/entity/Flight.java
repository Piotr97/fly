package com.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberOfSeats;
    private Date flyStart;
    private Date flyEnd;
    private BigDecimal priceTicket;
    @ElementCollection
    private List<Integer> seatingPlaces;
    //@OneToMany
    //private Set<Tourist> touristList;
    private String flightId;
    @OneToMany
    private List<Reservation> reservation;

    public List<Integer> getSeatingPlaces() {
        return seatingPlaces;
    }

    public void setSeatingPlaces(List<Integer> seatingPlaces) {
        this.seatingPlaces = seatingPlaces;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flyId) {
        this.flightId = flyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Date getFlyStart() {
        return flyStart;
    }

    public void setFlyStart(Date flyStart) {
        this.flyStart = flyStart;
    }

    public Date getFlyEnd() {
        return flyEnd;
    }

    public void setFlyEnd(Date flyEnd) {
        this.flyEnd = flyEnd;
    }

    public BigDecimal getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(BigDecimal priceTicket) {
        this.priceTicket = priceTicket;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
                ", flyStart=" + flyStart +
                ", flyEnd=" + flyEnd +
                ", priceTicket=" + priceTicket +
                ", seatingPlaces=" + seatingPlaces +
                ", flightId='" + flightId + '\'' +
                ", reservation=" + reservation +
                '}';
    }
}
