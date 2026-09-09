package com.nithin.railway_reservation.repository;

import com.nithin.railway_reservation.entity.Stakeholder;
import com.nithin.railway_reservation.entity.StakeholderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StakeholderRepository extends JpaRepository<Stakeholder, Long> {
    List<Stakeholder> findByType(StakeholderType type);
}
