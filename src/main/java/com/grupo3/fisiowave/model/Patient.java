package com.grupo3.fisiowave.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 14)
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "date")
    private LocalDate birthDate;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Embedded
    private Address address;
}
