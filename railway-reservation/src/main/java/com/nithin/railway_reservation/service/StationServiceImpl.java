package com.nithin.railway_reservation.service;

import com.nithin.railway_reservation.entity.Station;
import com.nithin.railway_reservation.exception.StationNotFoundException;
import com.nithin.railway_reservation.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Station findById(Long id) {
        return stationRepository.findById(id)
                .orElseThrow(() -> new StationNotFoundException(id));
    }

    @Override
    public Optional<Station> findByCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        return stationRepository.findByCode(code);
    }

    @Override
    public Station create(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public Station update(Long id, Station station) {
        Station existing = findById(id);
        existing.setCode(station.getCode());
        existing.setName(station.getName());
        existing.setCity(station.getCity());
        existing.setState(station.getState());
        return stationRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!stationRepository.existsById(id)) {
            throw new StationNotFoundException(id);
        }
        stationRepository.deleteById(id);
    }
}
