package com.nithin.railway_reservation.controller;

import com.nithin.railway_reservation.entity.Stakeholder;
import com.nithin.railway_reservation.entity.StakeholderType;
import com.nithin.railway_reservation.service.StakeholderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stakeholders")
public class StakeholderController {

    private final StakeholderService stakeholderService;

    public StakeholderController(StakeholderService stakeholderService) {
        this.stakeholderService = stakeholderService;
    }

    @GetMapping
    public ResponseEntity<List<Stakeholder>> getAll() {
        return ResponseEntity.ok(stakeholderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stakeholder> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stakeholderService.findById(id));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Stakeholder>> getByType(@PathVariable String type) {
        StakeholderType st = StakeholderType.valueOf(type.toUpperCase());
        return ResponseEntity.ok(stakeholderService.findByType(st));
    }

    @PostMapping
    public ResponseEntity<Stakeholder> create(@RequestBody Stakeholder stakeholder) {
        Stakeholder created = stakeholderService.create(stakeholder);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stakeholder> update(@PathVariable Long id, @RequestBody Stakeholder stakeholder) {
        return ResponseEntity.ok(stakeholderService.update(id, stakeholder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stakeholderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
