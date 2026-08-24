package com.nithin.railway_reservation.exception;

public class StakeholderNotFoundException extends RuntimeException {
    public StakeholderNotFoundException(Long id) {
        super("Stakeholder not found with id: " + id);
    }

    public StakeholderNotFoundException(String detail) {
        super("Stakeholder not found: " + detail);
    }
}
