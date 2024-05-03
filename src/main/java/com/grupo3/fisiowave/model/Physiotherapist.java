package com.grupo3.fisiowave.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Physiotherapist extends User {

    @OneToMany(mappedBy = "physiotherapist")
    private Set<Appointment> appointments = new HashSet<>();
}
