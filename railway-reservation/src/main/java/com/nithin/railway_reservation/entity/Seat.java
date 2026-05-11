package com.nithin.railway_reservation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private String classType; // e.g., AC1, AC2, Sleeper, General

    @Column(nullable = false)
    private Double price;
}