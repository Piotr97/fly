package com.model.dto;

import java.math.BigDecimal;
import java.util.Date;


public class FlightDTO {

    public int numberOfSeats;
    public Date flyStart;
    public Date flyEnd;
    public BigDecimal priceTicket;


    public FlightDTO() {
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
        return "FlightDTO{" +
                "numberOfSeats=" + numberOfSeats +
                ", flyStart=" + flyStart +
                ", flyEnd=" + flyEnd +
                ", priceTicket=" + priceTicket +
                '}';
    }
}
