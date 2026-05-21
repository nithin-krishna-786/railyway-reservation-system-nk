package com.nithin.railway_reservation.repository;

import com.nithin.railway_reservation.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Optional<Train> findByTrainNumber(String trainNumber);
}
