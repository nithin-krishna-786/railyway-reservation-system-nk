package com.nithin.railway_reservation.service;

import com.nithin.railway_reservation.entity.Stakeholder;
import com.nithin.railway_reservation.entity.StakeholderType;

import java.util.List;
import java.util.Optional;

public interface StakeholderService {
    List<Stakeholder> findAll();

    Stakeholder findById(Long id);

    List<Stakeholder> findByType(StakeholderType type);

    Stakeholder create(Stakeholder stakeholder);

    Stakeholder update(Long id, Stakeholder stakeholder);

    void delete(Long id);
}
