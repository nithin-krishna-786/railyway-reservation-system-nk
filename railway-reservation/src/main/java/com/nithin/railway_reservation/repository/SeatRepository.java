package com.nithin.railway_reservation.repository;

import com.nithin.railway_reservation.entity.Seat;
import com.nithin.railway_reservation.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByTrain(Train train);
    Optional<Seat> findByTrainAndSeatNumber(Train train, String seatNumber);
}
