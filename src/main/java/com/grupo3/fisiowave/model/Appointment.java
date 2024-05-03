package com.grupo3.fisiowave.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private OffsetDateTime time;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Physiotherapist physiotherapist;

}
