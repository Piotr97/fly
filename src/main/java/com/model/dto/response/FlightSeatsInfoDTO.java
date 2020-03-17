package com.model.dto.response;

public class FlightSeatsInfoDTO {
    private int seatsAmount;
    private int reservationSeatsAmount;
    private int purchasedSeatsAmount;
    private int freeSeatsAmount;

    public int getSeatsAmount() {
        return seatsAmount;
    }

    public void setSeatsAmount(int seatsAmount) {
        this.seatsAmount = seatsAmount;
    }

    public int getReservationSeatsAmount() {
        return reservationSeatsAmount;
    }

    public void setReservationSeatsAmount(int reservationSeatsAmount) {
        this.reservationSeatsAmount = reservationSeatsAmount;
    }

    public int getPurchasedSeatsAmount() {
        return purchasedSeatsAmount;
    }

    public void setPurchasedSeatsAmount(int purchasedSeatsAmount) {
        this.purchasedSeatsAmount = purchasedSeatsAmount;
    }

    public int getFreeSeatsAmount() {
        return freeSeatsAmount;
    }

    public void setFreeSeatsAmount(int freeSeatsAmount) {
        this.freeSeatsAmount = freeSeatsAmount;
    }

    @Override
    public String toString() {
        return "FlightSeatsInfoDTO{" +
                "seatsAmount=" + seatsAmount +
                ", reservationSeatsAmount=" + reservationSeatsAmount +
                ", purchasedSeatsAmount=" + purchasedSeatsAmount +
                ", freeSeatsAmount=" + freeSeatsAmount +
                '}';
    }
}
