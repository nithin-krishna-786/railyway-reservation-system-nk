package com.nithin.railway_reservation.service;

import com.nithin.railway_reservation.entity.Stakeholder;
import com.nithin.railway_reservation.entity.StakeholderType;
import com.nithin.railway_reservation.exception.StakeholderNotFoundException;
import com.nithin.railway_reservation.repository.StakeholderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StakeholderServiceImpl implements StakeholderService {

    private final StakeholderRepository stakeholderRepository;

    public StakeholderServiceImpl(StakeholderRepository stakeholderRepository) {
        this.stakeholderRepository = stakeholderRepository;
    }

    @Override
    public List<Stakeholder> findAll() {
        return stakeholderRepository.findAll();
    }

    @Override
    public Stakeholder findById(Long id) {
        return stakeholderRepository.findById(id)
                .orElseThrow(() -> new StakeholderNotFoundException(id));
    }

    @Override
    public List<Stakeholder> findByType(StakeholderType type) {
        return stakeholderRepository.findByType(type);
    }

    @Override
    public Stakeholder create(Stakeholder stakeholder) {
        return stakeholderRepository.save(stakeholder);
    }

    @Override
    public Stakeholder update(Long id, Stakeholder stakeholder) {
        Stakeholder existing = stakeholderRepository.findById(id)
                .orElseThrow(() -> new StakeholderNotFoundException(id));

        existing.setName(stakeholder.getName());
        existing.setEmail(stakeholder.getEmail());
        existing.setPhone(stakeholder.getPhone());
        existing.setOrganization(stakeholder.getOrganization());
        existing.setType(stakeholder.getType());

        return stakeholderRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Stakeholder existing = stakeholderRepository.findById(id)
                .orElseThrow(() -> new StakeholderNotFoundException(id));
        stakeholderRepository.delete(existing);
    }
}
