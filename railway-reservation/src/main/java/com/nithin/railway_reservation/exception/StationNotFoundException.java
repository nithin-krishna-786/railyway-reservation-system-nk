package com.nithin.railway_reservation.exception;

public class StationNotFoundException extends RuntimeException {
    public StationNotFoundException(Long id) {
        super("Station not found with id: " + id);
    }

    public StationNotFoundException(String code) {
        super("Station not found with code: " + code);
    }
}
