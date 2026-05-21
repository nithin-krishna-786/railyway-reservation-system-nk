package com.nithin.railway_reservation.repository;

import com.nithin.railway_reservation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {
    Optional<Station> findByCode(String code);
}
