package com.grupo3.fisiowave.repository;

import com.grupo3.fisiowave.model.Physiotherapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhysiotherapistRepository extends JpaRepository<Physiotherapist, UUID> {
}
