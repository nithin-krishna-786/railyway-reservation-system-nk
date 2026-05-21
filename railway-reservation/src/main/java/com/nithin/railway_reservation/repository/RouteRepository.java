package com.nithin.railway_reservation.repository;

import com.nithin.railway_reservation.entity.Route;
import com.nithin.railway_reservation.entity.Train;
import com.nithin.railway_reservation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByTrainOrderBySequenceAsc(Train train);
    List<Route> findByStation(Station station);
}
