package com.model.dto;

public class ReservationDTO {

    private String transactionUUID;

    public String getTransactionUUID() {
        return transactionUUID;
    }

    public void setTransactionUUID(String transactionUUID) {
        this.transactionUUID = transactionUUID;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "transactionUUID='" + transactionUUID + '\'' +
                '}';
    }
}
