package com.nithin.railway_reservation.service;

import com.nithin.railway_reservation.entity.Train;

import java.util.List;
import java.util.Optional;

public interface TrainService {
    List<Train> findAll();

    Train findById(Long id);

    Optional<Train> findByTrainNumber(String trainNumber);

    Train create(Train train);

    Train update(Long id, Train train);

    void delete(Long id);
}
