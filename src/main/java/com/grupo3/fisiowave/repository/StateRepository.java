package com.grupo3.fisiowave.repository;

import com.grupo3.fisiowave.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateRepository extends JpaRepository<State, UUID> {
}
