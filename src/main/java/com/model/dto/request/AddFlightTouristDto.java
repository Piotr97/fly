package com.model.dto.request;

public class AddFlightTouristDto {
    private String flightUUID;
    private long touristId;

    public String getFlightUUID() {
        return flightUUID;
    }

    public void setFlightUUID(String flightUUID) {
        this.flightUUID = flightUUID;
    }

    public long getTouristId() {
        return touristId;
    }

    public void setTouristId(long touristId) {
        this.touristId = touristId;
    }
}
