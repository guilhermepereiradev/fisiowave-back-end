package com.grupo3.fisiowave.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Anamnesis {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Gender gender;
    private String profession;
    private BigDecimal weight;
    private BigDecimal height;
    private String chiefComplaint;
    private String pastMedicalHistory;
    private String currentMedications;

    @Column(length = 1000)
    private String observation;

    @OneToOne(mappedBy = "anamnesis")
    private Patient patient;
}