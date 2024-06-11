package com.grupo3.fisiowave.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Appointment {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private OffsetDateTime time;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Physiotherapist physiotherapist;

    @Column(length = 1000)
    private String observation;

}
