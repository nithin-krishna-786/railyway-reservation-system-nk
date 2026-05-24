package com.nithin.railway_reservation.service;

import com.nithin.railway_reservation.entity.Train;
import com.nithin.railway_reservation.exception.TrainNotFoundException;
import com.nithin.railway_reservation.repository.TrainRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;

    @Override
    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    @Override
    public Train findById(Long id) {
        return trainRepository.findById(id)
                .orElseThrow(() -> new TrainNotFoundException(id));
    }

    @Override
    public Optional<Train> findByTrainNumber(String trainNumber) {
        if (trainNumber == null || trainNumber.isEmpty()) {
            throw new IllegalArgumentException("Train number cannot be null or empty");
        }

        return trainRepository.findByTrainNumber(trainNumber);
    }

    @Override
    public Train create(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public Train update(Long id, Train train) {
        Train existing = findById(id);
        existing.setTrainNumber(train.getTrainNumber());
        existing.setName(train.getName());
        existing.setType(train.getType());
        existing.setTotalSeats(train.getTotalSeats());
        existing.setRoutes(train.getRoutes());
        existing.setSeats(train.getSeats());
        return trainRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!trainRepository.existsById(id)) {
            throw new TrainNotFoundException(id);
        }
        trainRepository.deleteById(id);
    }
}
