package com.grupo3.fisiowave.repository;

import com.grupo3.fisiowave.model.Anamnesis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnamnesisRepository extends JpaRepository<Anamnesis, UUID> {
}
