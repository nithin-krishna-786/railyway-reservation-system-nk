package com.nithin.railway_reservation.repository;

import com.nithin.railway_reservation.entity.Reservation;
import com.nithin.railway_reservation.entity.Seat;
import com.nithin.railway_reservation.entity.Train;
import com.nithin.railway_reservation.entity.User;
import com.nithin.railway_reservation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByTrainAndTravelDate(Train train, LocalDate travelDate);
    List<Reservation> findByFromStationAndToStation(Station fromStation, Station toStation);
    List<Reservation> findBySeat(Seat seat);
}
