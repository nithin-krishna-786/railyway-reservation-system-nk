package com.nithin.railway_reservation.service;

import com.nithin.railway_reservation.entity.Station;

import java.util.List;
import java.util.Optional;

public interface StationService {
    List<Station> findAll();

    Station findById(Long id);

    Optional<Station> findByCode(String code);

    Station create(Station station);

    Station update(Long id, Station station);

    void delete(Long id);
}
